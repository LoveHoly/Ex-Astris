package ExAstris;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExAstrisRecipe {
	public static void registerCraftingRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(ExAstrisItem.HammerRF, 1, 0),
			" x ",
			" yx",
			"y  ",
			'x', new ItemStack(GameRegistry.findItem("RedstoneArsenal", "material"), 1, 32), 
			'y', new ItemStack(GameRegistry.findItem("RedstoneArsenal", "material"), 1, 193));
	}
}
