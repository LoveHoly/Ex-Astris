package ExAstris;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExAstrisRecipe {
	public static void registerCraftingRecipes()
	{
		if(Loader.isModLoaded("RedstoneArsenal")){
			GameRegistry.addRecipe(new ItemStack(ExAstrisItem.HammerRF, 1, 0),
					" x ",
					" yx",
					"y  ",
					'x', new ItemStack(GameRegistry.findItem("RedstoneArsenal", "material"), 1, 32), 
					'y', new ItemStack(GameRegistry.findItem("RedstoneArsenal", "material"), 1, 193));
		}
		if(Loader.isModLoaded("ThermalExpansion")){
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.SieveAutomatic, 1, 0),
					"aba",
					"aca",
					"d d",
					'a', new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 72), 
					'b', new ItemStack(GameRegistry.findItem("exnihilo", "mesh"), 1, 0), 
					'c', new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 135), 
					'd', new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 104));
		}
		
	}
}
