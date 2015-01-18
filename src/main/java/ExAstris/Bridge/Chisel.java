package ExAstris.Bridge;

import cpw.mods.fml.common.registry.GameRegistry;
import ExAstris.ExAstrisItem;
import ExAstris.Data.ModData;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import exnihilo.registries.SieveRegistry;

public class Chisel {

	public static void init()
	{
		if (ModData.allowChiselBlocksFromSifting)
		{
			SieveRegistry.register(Blocks.stone, 0, ExAstrisItem.chiselStone, 0, 1);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisItem.chiselStone, 0, 2);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisItem.chiselStone, 0, 4);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisItem.chiselStone, 0, 16);

			SieveRegistry.register(Blocks.stone, 0, ExAstrisItem.chiselStone, 1, 1);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisItem.chiselStone, 1, 2);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisItem.chiselStone, 1, 4);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisItem.chiselStone, 1, 16);

			GameRegistry.addRecipe(new ItemStack(GameRegistry.findItem("chisel", "marble"), 1, 0), new Object[]{"aa","aa", 'a', new ItemStack(ExAstrisItem.chiselStone, 1, 0)});
			GameRegistry.addRecipe(new ItemStack(GameRegistry.findItem("chisel", "limestone"), 1, 0), new Object[]{"aa","aa", 'a', new ItemStack(ExAstrisItem.chiselStone, 1, 1)});
		}
	}

}
