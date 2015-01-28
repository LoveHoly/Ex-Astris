package ExAstris.Util;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.data.ModData;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CrookUtils {

	public static boolean doCrooking(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		Block block = world.getBlock(X,Y,Z);
		int meta = world.getBlockMetadata(X, Y, Z);
		boolean extraDropped = false;

		if (block != null && block.isLeaves(world, 0, 0, 0))
		{
			if (!world.isRemote)
			{

				block.dropBlockAsItem(world, X, Y, Z, meta, 0);


				//Silkworms
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(100) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(GameRegistry.findItem("exnihilo", "silkworm"), 1, 0)));
				}
			}

			extraDropped = true;
		}

		if (block.equals(GameRegistry.findBlock("exnihilo", "infested_leaves")))
		{
			if (!world.isRemote)
			{
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(15) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(GameRegistry.findItem("exnihilo", "silkworm"), 1, 0)));
				}
			}
			extraDropped = true;
		}

		return extraDropped;
	}

	
}
