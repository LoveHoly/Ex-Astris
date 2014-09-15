package ExAstris.Block.TileEntity;

import ExAstris.ExAstrisBlock;
import ExAstris.ExAstrisItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.Fluids;
import exnihilo.data.BlockData;
import exnihilo.data.ModData;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.helpers.Color;
import exnihilo.registries.helpers.Compostable;

public class TileEntityBarrelThaumium extends TileEntity implements IFluidHandler, ISidedInventory{	
	private static final float MIN_RENDER_CAPACITY = 0.1f;
	private static final float MAX_RENDER_CAPACITY = 0.9f;
	private static final int MAX_COMPOSTING_TIME = 1000;
	private static final int MAX_FLUID = 1000;
	private static final int UPDATE_INTERVAL = 10;

	private static final int MOSS_SPREAD_X_POS = 2;
	private static final int MOSS_SPREAD_X_NEG = -2;
	private static final int MOSS_SPREAD_Y_POS = 2;
	private static final int MOSS_SPREAD_Y_NEG = -1;
	private static final int MOSS_SPREAD_Z_POS = 2;
	private static final int MOSS_SPREAD_Z_NEG = -2;

	public enum BarrelMode
	{
		EMPTY(0, ExtractMode.None), 
		FLUID(1, ExtractMode.None), 
		COMPOST(2, ExtractMode.None), 
		DIRT(3, ExtractMode.Always), 
		CLAY(4, ExtractMode.Always), 
		SPORED(5, ExtractMode.None), 
		SLIME(6, ExtractMode.Always), 
		NETHERRACK(7, ExtractMode.Always), 
		ENDSTONE(8, ExtractMode.Always), 
		MILKED(9, ExtractMode.None), 
		SOULSAND(10, ExtractMode.Always),
		BEETRAP(11, ExtractMode.Always), 
		OBSIDIAN(12, ExtractMode.Always),
		COBBLESTONE(13, ExtractMode.Always),
		BLAZE_COOKING(14, ExtractMode.None),
		BLAZE(15, ExtractMode.PeacefulOnly),
		ENDER_COOKING(16, ExtractMode.None),
		ENDER(17, ExtractMode.PeacefulOnly),
		DARKOAK(18, ExtractMode.Always),
		BLOCK(19, ExtractMode.Always),
		OBSIDIANTOTEM(20, ExtractMode.Always),
		PECK_COOKING(21, ExtractMode.None),
		PECK(22, ExtractMode.None),
		BEEINFUSED(23, ExtractMode.Always),
		BLIZZ_COOKING(24, ExtractMode.None),
		BLIZZ(25, ExtractMode.None);

		private BarrelMode(int v, ExtractMode extract){this.value = v; this.canExtract = extract;}
		public int value;
		public ExtractMode canExtract;
	}

	public enum ExtractMode
	{
		None,
		Always,
		PeacefulOnly;
	}

	public FluidStack fluid;
	private float volume;
	private int timer;
	private BarrelMode mode;
	public Block block;
	public int blockMeta;
	public Color color;
	private Color colorBase;
	public IIcon icon;

	private boolean needsUpdate = false;
	private int updateTimer = 0;

	public BarrelMode getMode() {
		return mode;
	}
	public void setMode(BarrelMode mode) {
		this.mode = mode;
		this.needsUpdate = true;
	}

	public TileEntityBarrelThaumium()
	{
		color = ColorRegistry.color("white");
		colorBase = color;
		setMode(BarrelMode.EMPTY);
		volume = 0;
		timer = 0;
		fluid = new FluidStack(FluidRegistry.WATER, 0);
	}

	@Override
	public void updateEntity()
	{	
		//XXX Barrel state logic.
		if (updateTimer >= UPDATE_INTERVAL)
		{
			updateTimer = 0;
			if (needsUpdate)
			{
				needsUpdate = false;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		}
		else
		{
			updateTimer++;
		}

		switch(this.getMode())
		{
		case EMPTY:
			//Handle Rain
			if (!worldObj.isRemote && worldObj.isRaining() && yCoord >= worldObj.getTopSolidOrLiquidBlock(xCoord, zCoord) - 1 && worldObj.getBiomeGenForCoords(xCoord, zCoord).rainfall > 0.0f)
			{
				fluid = new FluidStack(FluidRegistry.WATER, 0);
				setMode(BarrelMode.FLUID);
			}
			break;

		case FLUID:
			//WATER!
			if (fluid.fluidID == FluidRegistry.WATER.getID())
			{
				//Handle Rain
				if (!worldObj.isRemote && !isFull() && worldObj.isRaining() && yCoord >= worldObj.getTopSolidOrLiquidBlock(xCoord, zCoord) - 1 && worldObj.getBiomeGenForCoords(xCoord, zCoord).rainfall > 0.0f)
				{
					volume += worldObj.getBiomeGenForCoords(xCoord, zCoord).rainfall / (float)1000;

					if (volume > 1)
					{
						volume = 1;
					}

					fluid.amount = (int)(MAX_FLUID * volume);
					needsUpdate = true;
				}

				//Check for spores.
				if(!worldObj.isRemote && isFull() && ModData.ALLOW_BARREL_RECIPE_SOULSAND && getNearbyBlocks(Blocks.mycelium, 0) > 0)
				{
					colorBase = new Color(fluid.getFluid().getColor());
					setMode(BarrelMode.SPORED);
					needsUpdate = true;
				}

				//Turn into cobblestone?
				if (isFull() && worldObj.getBlock(xCoord, yCoord + 1, zCoord) == FluidRegistry.LAVA.getBlock())
				{
					setMode(BarrelMode.COBBLESTONE);
				}

				//Spread moss.
				if(!worldObj.isRemote && fluid.amount > 0 && worldObj.getBlock(xCoord, yCoord, zCoord).getMaterial().getCanBurn() && worldObj.rand.nextInt(500) == 0)
				{
					int x = xCoord + (worldObj.rand.nextInt(MOSS_SPREAD_X_POS - MOSS_SPREAD_X_NEG + 1) + MOSS_SPREAD_X_NEG);
					int y = yCoord + (worldObj.rand.nextInt(MOSS_SPREAD_Y_POS - MOSS_SPREAD_Y_NEG + 1) + MOSS_SPREAD_Y_NEG);
					int z = zCoord + (worldObj.rand.nextInt(MOSS_SPREAD_Z_POS - MOSS_SPREAD_Z_NEG + 1) + MOSS_SPREAD_Z_NEG);
					int lightLevel = worldObj.getBlockLightValue(x,y+1,z);

					if(!worldObj.isAirBlock(x, y, z) && worldObj.getTopSolidOrLiquidBlock(x, z) > y && lightLevel >= 9 && lightLevel <= 11)
					{
						Block selected = worldObj.getBlock(x, y, z);
						int meta = worldObj.getBlockMetadata(x, y, z);

						if (selected == Blocks.stonebrick && meta == 0)
						{
							worldObj.setBlock(x, y, z, Blocks.stonebrick, 1, 3);
							drain(ForgeDirection.DOWN, 100, true);
						}

						if (selected == Blocks.cobblestone)
						{
							worldObj.setBlock(x, y, z, Blocks.mossy_cobblestone, 0, 3);
							drain(ForgeDirection.DOWN, 100, true);
						}
					}
				}
			}

			//LAVA!
			if (fluid.fluidID == FluidRegistry.LAVA.getID())
			{
				//Burn the barrel it is flammable.
				if(worldObj.getBlock(xCoord, yCoord, zCoord).getMaterial().getCanBurn())
				{
					timer++;
					if (timer % 30 == 0)
					{
						worldObj.spawnParticle("largesmoke", (double)xCoord + Math.random(), (double)yCoord + 1.2D, (double)zCoord + Math.random(), 0.0D, 0.0D, 0.0D);
					}

					if (timer % 5 == 0)
					{
						worldObj.spawnParticle("smoke", (double)xCoord + Math.random(), (double)yCoord + 1.2D, (double)zCoord + Math.random(), 0.0D, 0.0D, 0.0D);
					}

					if (timer >= 400)
					{
						timer = 0;
						if (fluid.amount < 1000)
						{
							//burn
							worldObj.setBlock(xCoord, yCoord + 2, zCoord, Blocks.fire);
							return;
						}
						else
						{
							//spit lava on the ground
							worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.lava, 0, 3);
							return;
						}	
					}
				}

				//Turn into obsidian
				if (isFull() && worldObj.getBlock(xCoord, yCoord + 1, zCoord) == FluidRegistry.WATER.getBlock())
				{
					setMode(BarrelMode.OBSIDIAN);
				}
			}
			break;

		case COMPOST:
			if (volume >= 1.0F)
			{
				timer++;

				//Change color
				Color colorDirt = ColorRegistry.color("dirt");
				color = Color.average(colorBase, colorDirt, (float)timer / (float)MAX_COMPOSTING_TIME);

				//Are we done yet?
				if(timer >= TileEntityBarrelThaumium.MAX_COMPOSTING_TIME)
				{
					setMode(BarrelMode.DIRT);
					timer = 0;
					color = ColorRegistry.color("white");
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
			}
			break;

		case MILKED:
			timer++;

			Color colorSlime = ColorRegistry.color("water_slime_offset");
			color = Color.average(colorBase, colorSlime, (float)timer / (float)MAX_COMPOSTING_TIME);

			if (isDone())
			{
				timer = 0;
				setMode(BarrelMode.SLIME);
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
			break;

		case SLIME:
			if(worldObj.difficultySetting != EnumDifficulty.PEACEFUL)
			{
				timer++;

				if(isDone())
				{
					timer = 0;

					if(!worldObj.isRemote)
					{
						EntitySlime slime = new EntitySlime(worldObj);
						slime.setPosition(xCoord, yCoord + 1, zCoord);

						worldObj.spawnEntityInWorld(slime);
					}
					resetBarrel();
				}
			}

			break;

		case SPORED:
			int nearbyMycelium = getNearbyBlocks(Blocks.mycelium, 0);

			timer += 1 + (nearbyMycelium / 2);

			Color colorWitchy = ColorRegistry.color("water_witchy_offset");
			color = Color.average(colorBase, colorWitchy, (float)timer / (float)MAX_COMPOSTING_TIME);

			if(!worldObj.isRemote && nearbyMycelium > 0)
			{
				//Spawn Mushrooms
				for (int x = -2; x <= 2; x++)
				{
					for (int y = -1; y <= 1; y++)
					{
						for (int z = -2; z <= 2; z++)
						{
							if(worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z) == Blocks.mycelium && worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) && worldObj.rand.nextInt(1500) == 0)
							{
								int choice = worldObj.rand.nextInt(2);

								if (choice == 0)
									worldObj.setBlock(xCoord + x, yCoord + y + 1, zCoord + z, Blocks.brown_mushroom, 0, 3);
								if (choice == 1)
									worldObj.setBlock(xCoord + x, yCoord + y + 1, zCoord + z, Blocks.red_mushroom, 0, 3);
							}
						}
					}
				}
			}

			if (isDone())
			{
				timer = 0;
				fluid = FluidRegistry.getFluidStack("witchwater", fluid.amount);
				setMode(BarrelMode.FLUID);

				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
			break;

			//BLAZE
		case BLAZE_COOKING:
			timer++;

			if (!worldObj.isRemote && worldObj.getBlock(xCoord, yCoord, zCoord).getMaterial().getCanBurn())
			{
				//an earth-shattering kaboom...
				worldObj.func_147480_a(xCoord, yCoord, zCoord, false);
				this.worldObj.createExplosion(null, xCoord, yCoord, zCoord, 4.0f, true);
			}

			if (worldObj.isRemote && worldObj.rand.nextInt(20) == 0)
			{
				//spawn lava particles
				this.worldObj.spawnParticle("lava", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, 0.0d, 0.0d, 0.0d);
			}

			if (timer >= (int)(0.7 * MAX_COMPOSTING_TIME) && worldObj.isAirBlock(xCoord, yCoord + 1, zCoord))
			{
				//Spawn fire!
				worldObj.setBlock(xCoord, yCoord+1, zCoord, Blocks.fire);
			}

			if(isDone())
			{
				setMode(BarrelMode.BLAZE);
				timer = 0;
			}
			break;

		case BLAZE:
			if (worldObj.isRemote)
			{
				if (worldObj.rand.nextInt(5) == 0)
				{
					//spawn lava particles
					this.worldObj.spawnParticle("lava", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, 0.0d, 0.0d, 0.0d);

				}
			}

			if (!worldObj.isRemote && worldObj.difficultySetting != EnumDifficulty.PEACEFUL)
			{
				if(isDone())
				{
					timer = 0;
					resetBarrel();
					break;
				}

				//Try to spawn blaze, if you can't keep trying.
				for (int x = -1; x <= 1; x++)
				{
					for (int y = -1; y <= 1; y++)
					{
						for (int z = -1; z <= 1; z++)
						{
							if (
									(worldObj.isAirBlock(xCoord + x, yCoord + y, zCoord + z) || worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z) == Blocks.fire) && 
									(worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) || worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z) == Blocks.fire) && 
									worldObj.rand.nextInt(10) == 0 && !isDone())
							{
								timer = MAX_COMPOSTING_TIME;

								EntityBlaze blaze = new EntityBlaze(worldObj);
								blaze.setPosition(xCoord + x + 0.5d, yCoord + y, zCoord + z + 0.5d);

								worldObj.spawnEntityInWorld(blaze);
							}
						}
					}
				}
			}

			break;

			//ENDER
		case ENDER_COOKING:
			timer++;

			if (worldObj.isRemote && worldObj.rand.nextInt(20) == 0)
			{
				//spawn ender particles
				float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				this.worldObj.spawnParticle("portal", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, (double)f, (double)f1, (double)f2);
			}

			if(isDone())
			{
				setMode(BarrelMode.ENDER);
				timer = 0;
			}
			break;

		case ENDER:
			if (worldObj.isRemote && worldObj.rand.nextInt(5) == 0)
			{
				//spawn ender particles
				float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				this.worldObj.spawnParticle("portal", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, (double)f, (double)f1, (double)f2);
			}

			if (!worldObj.isRemote && worldObj.difficultySetting.getDifficultyId() > 0)
			{
				if(isDone())
				{
					timer = 0;
					resetBarrel();
					break;
				}

				//Try to spawn enderman, if you can't keep trying.
				for (int x = -1; x <= 1; x++)
				{
					for (int y = -1; y <= 1; y++)
					{
						for (int z = -1; z <= 1; z++)
						{
							if (
									worldObj.isAirBlock(xCoord + x, yCoord + y, zCoord + z) && 
									worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) && 
									worldObj.isAirBlock(xCoord + x, yCoord + y + 2, zCoord + z) &&
									worldObj.rand.nextInt(10) == 0 && !isDone())
							{
								timer = MAX_COMPOSTING_TIME;

								EntityEnderman enderman = new EntityEnderman(worldObj);
								enderman.setPosition(xCoord + x + 0.5d, yCoord + y, zCoord + z + 0.5d);

								worldObj.spawnEntityInWorld(enderman);
							}
						}
					}
				}
			}

			break;
		case PECK_COOKING:
			timer++;

			if (worldObj.isRemote && worldObj.rand.nextInt(20) == 0)
			{
				float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				this.worldObj.spawnParticle("witchMagic", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, (double)f, (double)f1, (double)f2);
			}

			if(isDone())
			{
				setMode(BarrelMode.PECK);
				timer = 0;
			}
			break;

		case PECK:
			if (worldObj.isRemote && worldObj.rand.nextInt(5) == 0)
			{
				//spawn ender particles
				float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				this.worldObj.spawnParticle("witchMagic", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, (double)f, (double)f1, (double)f2);
			}

			if (!worldObj.isRemote && worldObj.difficultySetting.getDifficultyId() > 0)
			{
				if(isDone())
				{
					timer = 0;
					resetBarrel();
					break;
				}

				//Try to spawn enderman, if you can't keep trying.
				for (int x = -1; x <= 1; x++)
				{
					for (int y = -1; y <= 1; y++)
					{
						for (int z = -1; z <= 1; z++)
						{
							if (
									worldObj.isAirBlock(xCoord + x, yCoord + y, zCoord + z) && 
									worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) && 
									worldObj.isAirBlock(xCoord + x, yCoord + y + 2, zCoord + z) &&
									worldObj.rand.nextInt(10) == 0 && !isDone())
							{
								timer = MAX_COMPOSTING_TIME;
								
								ExAstris.Bridge.Thaumcraft.summonPeck(worldObj,xCoord + x + 0.5d,yCoord + y,zCoord + z + 0.5d);							}
						}
					}
				}
			}

			break;
		case BLIZZ_COOKING:
			timer++;

			if (worldObj.isRemote && worldObj.rand.nextInt(20) == 0)
			{
				float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				this.worldObj.spawnParticle("snowballpoof", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, (double)f, (double)f1, (double)f2);
			}

			if(isDone())
			{
				setMode(BarrelMode.BLIZZ);
				timer = 0;
			}
			break;

		case BLIZZ:
			if (worldObj.isRemote && worldObj.rand.nextInt(5) == 0)
			{
				//spawn ender particles
				float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
				this.worldObj.spawnParticle("snowballpoof", xCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, yCoord + 1, zCoord + (double)(worldObj.rand.nextFloat() * 0.6) + 0.2d, (double)f, (double)f1, (double)f2);
			}

			if (!worldObj.isRemote && worldObj.difficultySetting.getDifficultyId() > 0)
			{
				if(isDone())
				{
					timer = 0;
					resetBarrel();
					break;
				}

				//Try to spawn enderman, if you can't keep trying.
				for (int x = -1; x <= 1; x++)
				{
					for (int y = -1; y <= 1; y++)
					{
						for (int z = -1; z <= 1; z++)
						{
							if (
									worldObj.isAirBlock(xCoord + x, yCoord + y, zCoord + z) && 
									worldObj.isAirBlock(xCoord + x, yCoord + y + 1, zCoord + z) && 
									worldObj.isAirBlock(xCoord + x, yCoord + y + 2, zCoord + z) &&
									worldObj.rand.nextInt(10) == 0 && !isDone())
							{
								timer = MAX_COMPOSTING_TIME;
								ExAstris.Bridge.ThermalExpansion.summonBlizz(worldObj,xCoord + x + 0.5d, yCoord + y, zCoord + z + 0.5d);
								
							}
						}
					}
				}
			}

			break;

		default:
			break;
		}
	}

	public boolean addCompostItem(Compostable item)
	{
		if (getMode() == BarrelMode.EMPTY)
		{
			setMode(BarrelMode.COMPOST);
			timer = 0;
		}

		if (getMode() == BarrelMode.COMPOST && volume < 1.0f)
		{
			volume += item.value;

			if (volume > 1.0f)
			{
				volume = 1.0f;
			}

			//Calculate the average of the colors
			float weightA = item.value / volume;
			float weightB = 1.0f - weightA;

			float r = weightA * item.color.r + weightB * color.r;
			float g = weightA * item.color.g + weightB * color.g;
			float b = weightA * item.color.b + weightB * color.b;
			float a = weightA * item.color.a + weightB * color.a;

			color = new Color(r,g,b,a);

			//Set the starting color that will be used in the cooking process.
			if (volume == 1.0f)
			{
				colorBase = color;
			}

			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			//needsUpdate = true;
			return true;
		}
		else
		{
			return false;
		}
	}	

	public boolean isFull()
	{
		if (volume >= 1.0f)
		{
			return true;
		}else
		{
			return false;
		}
	}

	public boolean isDone()
	{
		return timer >= MAX_COMPOSTING_TIME;
	}

	public void resetColor()
	{
		colorBase = ColorRegistry.color("white");
		color = ColorRegistry.color("white");
	}

	public void giveAppropriateItem()
	{
		giveItem(getExtractItem());
	}

	private void giveItem(ItemStack item)
	{
		if(!worldObj.isRemote)
		{
			EntityItem entityitem = new EntityItem(worldObj, (double)xCoord + 0.5D, (double)yCoord + 1.5D, (double)zCoord + 0.5D, item);

			double f3 = 0.05F;
			entityitem.motionX = worldObj.rand.nextGaussian() * f3;
			entityitem.motionY = (0.2d);
			entityitem.motionZ = worldObj.rand.nextGaussian() * f3;

			worldObj.spawnEntityInWorld(entityitem);

			timer = 0;
		}

		resetBarrel();
	}

	private ItemStack getExtractItem()
	{
		//XXX getExtractItem
		switch (getMode())
		{
		case CLAY:
			return new ItemStack(Blocks.clay, 1, 0);

		case DIRT:
			return new ItemStack(Blocks.dirt, 1, 0);

		case ENDSTONE:
			return new ItemStack(Blocks.end_stone, 1, 0);

		case NETHERRACK:
			return new ItemStack(Blocks.netherrack, 1, 0);

		case SLIME:
			return new ItemStack(Items.slime_ball, 1 + worldObj.rand.nextInt(4));

		case SOULSAND:
			return new ItemStack(Blocks.soul_sand, 1, 0);

		case OBSIDIAN:
			return new ItemStack(Blocks.obsidian, 1, 0);

		case COBBLESTONE:
			return new ItemStack(Blocks.cobblestone, 1, 0);

		case BLAZE:
			return new ItemStack(Items.blaze_rod, 1, 0);

		case ENDER:
			return new ItemStack(Items.ender_pearl, 1, 0);
			
		case BEETRAP:
			return new ItemStack(ENBlocks.BeeTrapTreated, 1, 0);
			
		case DARKOAK:
			return new ItemStack(Blocks.sapling, 1, 5);

		case BLOCK:
			return new ItemStack(block);
			
		case OBSIDIANTOTEM:
			return new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCosmeticSolid"), 1, 0);
			
		case BEEINFUSED:
			return new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0);
			
		default:
			return null;
		}
	}
	
	public float getVolume() {
		return volume;
	}
	
	public int getTimer() {
		return timer;
	}

	public float getAdjustedVolume()
	{
		float capacity = MAX_RENDER_CAPACITY - MIN_RENDER_CAPACITY;
		float adjusted = volume * capacity;		
		adjusted += MIN_RENDER_CAPACITY;
		return adjusted;
	}

	private void resetBarrel()
	{
		fluid = new FluidStack(FluidRegistry.WATER, 0);
		volume = 0;
		color = ColorRegistry.color("white");
		colorBase = ColorRegistry.color("white");
		setMode(BarrelMode.EMPTY);
		needsUpdate = true;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		switch (compound.getInteger("mode"))
		{
		case 0:
			setMode(BarrelMode.EMPTY);
			break;

		case 1:
			setMode(BarrelMode.FLUID);
			break;

		case 2:
			setMode(BarrelMode.COMPOST);
			break;

		case 3:
			setMode(BarrelMode.DIRT);
			break;	

		case 4:
			setMode(BarrelMode.CLAY);
			break;

		case 5:
			setMode(BarrelMode.SPORED);
			break;

		case 6:
			setMode(BarrelMode.SLIME);
			break;

		case 7:
			setMode(BarrelMode.NETHERRACK);
			break;	

		case 8:
			setMode(BarrelMode.ENDSTONE);
			break;	

		case 9:
			setMode(BarrelMode.MILKED);
			break;	

		case 10:
			setMode(BarrelMode.SOULSAND);
			break;	

		case 11:
			setMode(BarrelMode.BEETRAP);
			break;

		case 12:
			setMode(BarrelMode.OBSIDIAN);
			break;

		case 13:
			setMode(BarrelMode.COBBLESTONE);
			break;

		case 14:
			setMode(BarrelMode.BLAZE_COOKING);
			break;

		case 15:
			setMode(BarrelMode.BLAZE);
			break;

		case 16:
			setMode(BarrelMode.ENDER_COOKING);
			break;

		case 17:
			setMode(BarrelMode.ENDER);
			break;
			
		case 18:
			setMode(BarrelMode.DARKOAK);
			break;
			
		case 19:
			setMode(BarrelMode.BLOCK);
			break;
			
		case 20:
			setMode(BarrelMode.OBSIDIANTOTEM);
			break;

		case 21:
			setMode(BarrelMode.PECK_COOKING);
			break;

		case 22:
			setMode(BarrelMode.PECK);
			break;
			
		case 23:
			setMode(BarrelMode.BEEINFUSED);
			break;
			
		case 24:
			setMode(BarrelMode.BLIZZ_COOKING);
			break;

		case 25:
			setMode(BarrelMode.BLIZZ);
			break;
		}

		volume = compound.getFloat("volume");
		timer = compound.getInteger("timer");

		color = new Color(compound.getInteger("color"));
		colorBase = new Color (compound.getInteger("colorBase"));
		fluid = new FluidStack(FluidRegistry.getFluid(compound.getShort("fluid")), (int)(volume * MAX_FLUID));
		needsUpdate = true;
		
		if(!compound.getString("block").equals("")) {
			block = (Block)Block.blockRegistry.getObject(compound.getString("block"));
		}else{
			block = null;
		}
		blockMeta = compound.getInteger("blockMeta");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("mode", getMode().value);
		compound.setFloat("volume", volume);
		compound.setInteger("timer", timer);
		compound.setInteger("color", color.toInt());
		compound.setInteger("colorBase", colorBase.toInt());
		compound.setShort("fluid", (short)fluid.fluidID);
		
		if(block == null) {
			compound.setString("block", "");
		}else{
			compound.setString("block", Block.blockRegistry.getNameForObject(block));
		}
		compound.setInteger("blockMeta", blockMeta);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.func_148857_g();
		readFromNBT(tag);
	}



	//IFluidHandler!	
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		//Simulate the fill to see if there is room for incoming liquids.
		int capacity = MAX_FLUID - fluid.amount;

		if (!doFill)
		{
			if (getMode() == BarrelMode.EMPTY)
			{
				return resource.amount;
			}

			if (getMode() == BarrelMode.FLUID && resource.fluidID == fluid.fluidID)
			{
				if (capacity >= resource.amount)
				{
					return resource.amount;
				}else
				{
					return capacity;
				}
			}
		}else
			//Really fill the barrel.
		{
			if (getMode() == BarrelMode.EMPTY)
			{
				if (resource.fluidID != fluid.fluidID)
				{
					fluid =  new FluidStack(FluidRegistry.getFluid(resource.fluidID),resource.amount);
				}else
				{
					fluid.amount = resource.amount;
				}
				setMode(BarrelMode.FLUID);
				volume = (float)fluid.amount / (float)MAX_FLUID;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				//needsUpdate = true;
				return resource.amount;
			}

			if (getMode() == BarrelMode.FLUID && resource.fluidID == fluid.fluidID)
			{
				if (capacity >= resource.amount)
				{
					fluid.amount += resource.amount;
					volume = (float)fluid.amount / (float)MAX_FLUID;
					//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
					needsUpdate = true;
					return resource.amount;
				}else
				{
					fluid.amount = MAX_FLUID;
					volume = 1.0f;
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
					//needsUpdate = true;
					return capacity;
				}
			}
		}

		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (resource == null || getMode() != BarrelMode.FLUID || !resource.isFluidEqual(fluid))
			return null;

		if (!doDrain)
		{
			if (fluid.amount >= resource.amount)
			{
				FluidStack simulated = new FluidStack(FluidRegistry.getFluid(resource.fluidID),resource.amount);
				return simulated;
			}else
			{
				FluidStack simulated = new FluidStack(FluidRegistry.getFluid(resource.fluidID),fluid.amount);
				return simulated;
			}
		}else
		{
			if (fluid.amount > resource.amount)
			{
				FluidStack drained = new FluidStack(FluidRegistry.getFluid(resource.fluidID),resource.amount);
				fluid.amount -= resource.amount;
				volume = (float)fluid.amount / (float)MAX_FLUID;
				//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = true;
				//System.out.println("A Server: " + worldObj.isRemote + ". Amount: " + fluid.amount);
				return drained;
			}else
			{
				FluidStack drained = new FluidStack(FluidRegistry.getFluid(resource.fluidID),fluid.amount);
				fluid.amount = 0;
				volume = 0;
				setMode(BarrelMode.EMPTY);
				timer = 0;
				//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = true;
				//System.out.println("A Server: " + worldObj.isRemote + ". Amount: " + fluid.amount);
				return drained;
			}
		}
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (getMode() != BarrelMode.FLUID)
			return null;

		if (!doDrain)
		{
			if (fluid.amount >= maxDrain)
			{
				FluidStack simulated = new FluidStack(FluidRegistry.getFluid(fluid.fluidID),maxDrain);
				return simulated;
			}else
			{
				FluidStack simulated = new FluidStack(FluidRegistry.getFluid(fluid.fluidID),fluid.amount);
				return simulated;
			}
		}else
		{
			if (fluid.amount > maxDrain)
			{
				FluidStack drained = new FluidStack(FluidRegistry.getFluid(fluid.fluidID),maxDrain);
				fluid.amount -= maxDrain;
				volume = (float)fluid.amount / (float)MAX_FLUID;
				//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = true;
				//System.out.println("B Server: " + worldObj.isRemote + ". Amount: " + fluid.amount);
				return drained;
			}else
			{
				FluidStack drained = new FluidStack(FluidRegistry.getFluid(fluid.fluidID),fluid.amount);
				fluid.amount = 0;
				volume = 0;
				setMode(BarrelMode.EMPTY);
				timer = 0;
				//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				needsUpdate = true;
				//System.out.println("B Server: " + worldObj.isRemote + ". Amount: " + fluid.amount);
				return drained;
			}
		}
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		FluidTankInfo info = new FluidTankInfo(fluid, MAX_FLUID);
		FluidTankInfo[] array =  new FluidTankInfo[1];
		array[0] = info;
		return array;
	}

	public int getNearbyBlocks(Block block, int blockMeta)
	{
		int count = 0;

		for (int x = -1; x <= 1; x++)
		{
			for (int y = -1; y <= 1; y++)
			{
				for (int z = -1; z <= 1; z++)
				{
					if(worldObj.getBlock(xCoord + x, yCoord + y, zCoord + z) == block && worldObj.getBlockMetadata(xCoord + x, yCoord + y, zCoord + z) == blockMeta)
					{
						count++;
					}
				}
			}
		}

		return count;
	}

	public int getLightLevel()
	{
		if (getMode() == BarrelMode.FLUID)
		{
			return fluid.getFluid().getLuminosity();
		}

		if(getMode() == BarrelMode.BLAZE || getMode() == BarrelMode.BLAZE_COOKING)
		{
			return 15;
		}

		return 0;
	}



	//ISidedInventory!
	@Override
	public int getSizeInventory() {
		return 2;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		if (slot == 0)
		{
			return getExtractItem();
		}

		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (slot == 0)
		{
			ItemStack item = getExtractItem();

			resetBarrel();
			return item;
		}

		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		//XXX addItemFromPipe
		
		if (stack == null || stack.getItem() == null)
		{
			if (slot == 0)
			{
				resetBarrel();
			}
		}
		else
		{
			Item item = stack.getItem();
			int meta = stack.getItemDamage();

			if (slot == 1)
			{
				if (getMode() == BarrelMode.COMPOST || getMode() == BarrelMode.EMPTY)
				{
					if(CompostRegistry.containsItem(item, meta))
					{
						this.addCompostItem(CompostRegistry.getItem(item, meta));
					}
				}

				if(getMode() == BarrelMode.FLUID && this.isFull())
				{
					if(fluid.fluidID == FluidRegistry.WATER.getID())
					{
						if (ModData.ALLOW_BARREL_RECIPE_CLAY && Block.getBlockFromItem(item) == ENBlocks.Dust)
						{
							setMode(BarrelMode.CLAY);
						}
						
						if(item == ExAstrisItem.DollFreezing)
						{
							setMode(BarrelMode.BLIZZ_COOKING);
						}
					}

					if(fluid.fluidID == FluidRegistry.LAVA.getID())
					{
						if (ModData.ALLOW_BARREL_RECIPE_NETHERRACK && item == Items.redstone)
						{
							setMode(BarrelMode.NETHERRACK);
						}

						if (ModData.ALLOW_BARREL_RECIPE_ENDSTONE && item == Items.glowstone_dust)
						{
							setMode(BarrelMode.ENDSTONE);
						}

						if(ModData.ALLOW_BARREL_RECIPE_BLAZE_RODS && item == ENItems.DollAngry)
						{
							setMode(BarrelMode.BLAZE_COOKING);
						}
					}

					if (fluid.fluidID == Fluids.fluidWitchWater.getID())
					{
						if(ModData.ALLOW_BARREL_RECIPE_SOULSAND && Block.getBlockFromItem(item) == Blocks.sand)
						{
							resetColor();
							setMode(BarrelMode.SOULSAND);
						}

						if(ModData.ALLOW_BARREL_RECIPE_ENDER_PEARLS && item == ENItems.DollCreepy)
						{
							setMode(BarrelMode.ENDER_COOKING);
						}
						
						if(ModData.ALLOW_BARREL_RECIPE_DARK_OAK && Block.getBlockFromItem(item) == Blocks.sapling && meta == 0)
						{
							setMode(BarrelMode.DARKOAK);
						}
						
						if(Block.getBlockFromItem(item) == Blocks.obsidian )
						{
							resetColor();
							setMode(BarrelMode.OBSIDIANTOTEM);
						}
						
						if(Block.getBlockFromItem(item) == ENBlocks.BeeTrap )
						{
							resetColor();
							setMode(BarrelMode.BEEINFUSED);
						}
						
						if(item == ExAstrisItem.DollThaumic)
						{
							setMode(BarrelMode.PECK_COOKING);
						}
						
					}
					
					Fluid seedOil = FluidRegistry.getFluid("seedoil");
					if (seedOil != null && fluid.fluidID == seedOil.getID())
					{
						setMode(BarrelMode.BEETRAP);
					}
				}
			}
		}

		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return false;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {	
		if (slot == 1)
		{
			return isItemValid(item);
		}

		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		if (side == 0)
		{
			return new int[]{0};
		}else if (side == 1)
		{
			return new int[]{1};
		}

		return new int[0];
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side) {
		if (side == 1 && slot == 1)
		{
			return isItemValid(item);
		}

		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) {
		if (side == 0 && slot == 0)
		{
			if (getMode().canExtract == ExtractMode.Always)
			{
				return true;
			}

			if (worldObj.difficultySetting.getDifficultyId() == 0 && getMode().canExtract == ExtractMode.PeacefulOnly)
			{
				return true;
			}
		}

		return false;
	}

	public boolean isItemValid(ItemStack stack)
	{
		///XXX isItemValid
		Item item = stack.getItem();
		int meta = stack.getItemDamage();
		
		if (!this.isFull() && getMode() == BarrelMode.COMPOST || getMode() == BarrelMode.EMPTY)
		{
			if(ModData.ALLOW_BARREL_RECIPE_DIRT && CompostRegistry.containsItem(item, meta))
			{
				return true;
			}
		}

		if(getMode() == BarrelMode.FLUID && this.isFull())
		{
			if(fluid.fluidID == FluidRegistry.WATER.getID())
			{
				if (ModData.ALLOW_BARREL_RECIPE_CLAY && Block.getBlockFromItem(item) == ENBlocks.Dust)
				{
					return true;
				}
				
				if(item == ExAstrisItem.DollFreezing)
				{
					return true;
				}
			}


			if(fluid.fluidID == FluidRegistry.LAVA.getID())
			{
				if (ModData.ALLOW_BARREL_RECIPE_NETHERRACK && item == Items.redstone)
				{
					return true;
				}

				if (ModData.ALLOW_BARREL_RECIPE_ENDSTONE && item == Items.glowstone_dust)
				{
					return true;
				}

				if(ModData.ALLOW_BARREL_RECIPE_BLAZE_RODS && item == ENItems.DollAngry)
				{
					return true;
				}
			}


			if (fluid.fluidID == Fluids.fluidWitchWater.getID())
			{
				if(ModData.ALLOW_BARREL_RECIPE_SOULSAND && Block.getBlockFromItem(item) == Blocks.sand)
				{
					return true;
				}
				
				if(Block.getBlockFromItem(item) == Blocks.obsidian)
				{
					return true;
				}
				
				if(item == ExAstrisItem.DollThaumic)
				{
					return true;
				}
				
				if(Block.getBlockFromItem(item) == ExAstrisBlock.BeeTrapInfused)
				{
					return true;
				}
				
				if(ModData.ALLOW_BARREL_RECIPE_ENDER_PEARLS && item == ENItems.DollCreepy)
				{
					return true;
				}
				
				if(ModData.ALLOW_BARREL_RECIPE_DARK_OAK && Block.getBlockFromItem(item) == Blocks.sapling && meta == 0)
				{
					return true;
				}
			}
			
			Fluid seedOil = FluidRegistry.getFluid("seedoil");
			if (seedOil != null && fluid.fluidID == seedOil.getID() && Block.getBlockFromItem(item) == ENBlocks.BeeTrap)
			{
				return true;
			}
		}

		return false;
	}
}
