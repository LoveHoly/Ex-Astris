package ExAstris.Bridge;

/*import java.util.ArrayList;
import java.util.Iterator;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.data.ModData;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.helpers.Smashable;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;

public class TConstructModifier extends ActiveToolMod {
	
	@Override
	public boolean beforeBlockBreak (ToolCore tool, ItemStack item, int X, int Y, int Z, EntityLivingBase player)
	{
		NBTTagCompound tags = item.getTagCompound().getCompoundTag("InfiTool");
		if (tags.getBoolean("Crooked"))
		{
			World world = player.worldObj;
			Block block = world.getBlock(X,Y,Z);
			int meta = world.getBlockMetadata(X, Y, Z);
			boolean validTarget = false;
			boolean extraDropped = false;
	
	
			if (!world.isRemote && block != null && block.isLeaves(world, X, Y, Z))
			{
						
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(130) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(GameRegistry.findItem("exnihilo", "silkworm"), 1, 0)));
				}
					
				if (block.equals(GameRegistry.findBlock("exnihilo", "infested_leaves")))
				{
					if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(20) == 0)
					{
						world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(GameRegistry.findItem("exnihilo", "silkworm"), 1, 0)));
					}
				}
					
				AbilityHelper.damageTool(item, 1, player, false);
			}
			return false;
		}
		if (tags.getBoolean("Hammered"))
		{
			World world = player.worldObj;
			Block block = world.getBlock(X,Y,Z);
			int blockMeta = world.getBlockMetadata(X,Y,Z);
			int fortune = EnchantmentHelper.getFortuneModifier(player);

			ArrayList<Smashable> rewards = HammerRegistry.getRewards(block, blockMeta);
			boolean validTarget = false;
			
			if (!rewards.isEmpty())
			{
				Iterator<Smashable> it = rewards.iterator();
				while(it.hasNext())
				{
					Smashable reward = it.next();

					if (!world.isRemote && world.rand.nextFloat() <= reward.chance + (reward.luckMultiplier * fortune))
					{
						EntityItem entityitem = new EntityItem(world, (double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, new ItemStack(reward.item, 1, reward.meta));

						double f3 = 0.05F;
						entityitem.motionX = world.rand.nextGaussian() * f3;
						entityitem.motionY = (0.2d);
						entityitem.motionZ = world.rand.nextGaussian() * f3;

						world.spawnEntityInWorld(entityitem);
					}

					validTarget = true;
				}

				if (validTarget)
				{
					AbilityHelper.damageTool(item, 1, player, false);
					
					if (!world.isRemote)
					{
						world.setBlockToAir(X, Y, Z);
					}
				}

				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	
	@Override
	public int attackDamage (int modDamage, int currentDamage, ToolCore tool, NBTTagCompound tags, NBTTagCompound toolTags, ItemStack stack, EntityLivingBase player, Entity entity)
    {
		if (toolTags.hasKey("Crooked"))
		{
			return 0;
		}
		else return currentDamage;
    }
}*/
