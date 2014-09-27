package ExAstris;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import ExAstris.Bridge.RedstoneArsenal;
import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import ExAstris.Item.ItemDollThaumic;
import ExAstris.Item.ItemHammerThaumium;
import ExAstris.Item.ItemDollFreezing;
import ExAstris.Item.ItemOre;
import ExAstris.Item.ItemUnchargedNetherStar;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ExAstrisItem {
	public static Item DollThaumic;
	public static Item HammerThaumium;
	public static Item HammerRF;
	public static Item DollFreezing;
	public static Item UnchargedNetherStar;
	

	public static Item cobaltOreItem;
	public static Item arditeOreItem;
	public static void registerItems()
	{
		if(Loader.isModLoaded("Thaumcraft")){
			DollThaumic = new ItemDollThaumic();
			GameRegistry.registerItem(DollThaumic, ItemData.THAUMIC_DOLL_UNLOCALIZED_NAME);
			
			HammerThaumium = new ItemHammerThaumium();
			GameRegistry.registerItem(HammerThaumium, ItemData.HAMMER_THAUMIUM_UNLOCALIZED_NAME);
			if(Loader.isModLoaded("ThermalExpansion")){
				DollFreezing = new ItemDollFreezing();
				GameRegistry.registerItem(DollFreezing, ItemData.FREEZING_DOLL_UNLOCALIZED_NAME);
			}
		}
		if(Loader.isModLoaded("RedstoneArsenal"))
		{
			HammerRF = RedstoneArsenal.HammerRF();
			GameRegistry.registerItem(HammerRF, ItemData.HAMMER_RF_UNLOCALIZED_NAME);
		}
		
				
		if(Loader.isModLoaded("AWWayofTime") && ModData.ALLOW_UNCHARGED_NETHERSTAR){
			UnchargedNetherStar = new ItemUnchargedNetherStar();
			GameRegistry.registerItem(UnchargedNetherStar, ItemData.UNCHARGED_NETHERSTAR_UNLOCALIZED_NAME);
		}
		
		if(Loader.isModLoaded("TConstruct") && ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			cobaltOreItem = new ItemOre("Cobalt");
			GameRegistry.registerItem(cobaltOreItem, "OreCobaltItem");

			arditeOreItem = new ItemOre("Ardite");
			GameRegistry.registerItem(arditeOreItem, "OreArditeItem");
		}
		
		//GameRegistry.addRecipe(new ShapedOreRecipe(HammerRF, new Object[] { " a ", " ba", "b  ", Character.valueOf('a'), RAItems.ingotElectrumFlux, Character.valueOf('b'), RAItems.rodObsidianFlux }));
	}
}
