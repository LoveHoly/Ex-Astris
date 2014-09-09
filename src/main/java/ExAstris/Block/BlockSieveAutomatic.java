package ExAstris.Block;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.registries.SieveRegistry;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic.SieveMode;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSieveAutomatic extends BlockContainer{
	public static IIcon meshIcon;

	public BlockSieveAutomatic() {
		super(Material.iron);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(2.0f);

		setBlockName(ModData.ID + "." + BlockData.SIEVE_AUTOMATIC_KEY);
		GameRegistry.registerTileEntity(TileEntitySieveAutomatic.class, ModData.ID + "." + BlockData.SIEVE_AUTOMATIC_KEY);
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = Blocks.planks.getIcon(0,0);
		meshIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":" + "IconSieveMesh");
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		subItems.add(new ItemStack(item, 1, 0));
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean hasTileEntity()
	{
		return true;
	}

	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySieveAutomatic();
	}


	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (player == null)
		{
			return false;
		}


		return true;
	}

	private boolean isHuman(EntityPlayer player)
	{
		boolean isHuman = (player instanceof EntityPlayerMP);

		if (player.toString().contains("CoFH"))
		{
			isHuman = false;
		}

		return isHuman;
	}

	private void removeCurrentItem(EntityPlayer player)
	{
		ItemStack item = player.getCurrentEquippedItem();

		if (!player.capabilities.isCreativeMode)
		{
			item.stackSize -= 1;
			if (item.stackSize == 0)
			{
				item = null;
			}
		}

	}
}


/*
		TileEntitySieveAutomatic sieve = (TileEntitySieveAutomatic) world.getTileEntity(x, y, z);

		if (sieve.mode == SieveMode.EMPTY && player.getCurrentEquippedItem() != null)
		{
			ItemStack held = player.getCurrentEquippedItem();
			
			if (SieveRegistry.Contains(Block.getBlockFromItem(held.getItem()), held.getItemDamage()))
			{
				sieve.addSievable(Block.getBlockFromItem(held.getItem()), held.getItemDamage());
				removeCurrentItem(player);
			}
		}else
		{
			if (world.isRemote)
			{
				sieve.ProcessContents(false);
			}else
			{
				if (sieve.mode != SieveMode.EMPTY)
				{
					if(isHuman(player))//ModData.ALLOW_SIEVE_AUTOMATION
					{
						sieve.ProcessContents(false);
					}				
				}
			}
		}
 */ 

