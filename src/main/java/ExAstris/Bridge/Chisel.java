package ExAstris.Bridge;

import com.cricketcraft.chisel.api.IMC;

import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import ExAstris.ExAstrisItem;
import ExAstris.Data.ModData;
import ExAstris.Item.ItemChiselStones;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
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
	
	public static Item chiselStones()
	{
		return new ItemChiselStones();
	}

	public static void sendIMC()
	{
		if (ModData.allowBarrelsToBeChiselled)
		{
			// Convenience recipe for barrels
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ENBlocks.Barrel), "x x", "x x", "xyx", 'x', "plankWood", 'y', "slabWood"));
			for (int i = 0; i < 6; i++)
			{
				FMLInterModComms.sendMessage(IMC.CHISEL_MODID, IMC.ADD_VARIATION.key, "ENBarrel|exnihilo:barrel|"+i);
			}
		}
		
		if (ModData.allowSievesToBeChiselled)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ENBlocks.Sieve), "aba", "cbc", "c c", 'a', "plankWood", 'b', ENItems.Mesh, 'c', "stickWood"));
			for (int i = 0; i < 6; i++)
			{
				FMLInterModComms.sendMessage(IMC.CHISEL_MODID, IMC.ADD_VARIATION.key, "ENSieve|exnihilo:sifting_table|"+i);
			}
		}
	}

}
