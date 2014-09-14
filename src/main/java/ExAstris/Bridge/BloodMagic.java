package ExAstris.Bridge;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ExAstris.ExAstrisItem;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;;
public class BloodMagic {
	public static void Initialize()
	{
		addAlterRegistry();
	}
	public static void addAlterRegistry()
	{
		AltarRecipeRegistry.registerAltarRecipe(new ItemStack(Items.nether_star), new ItemStack(ExAstrisItem.UnchargedNetherStar), 4, 20000, 20, 20, true);
	}
}
