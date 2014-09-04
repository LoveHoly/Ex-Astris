package ExAstris;

import cpw.mods.fml.common.registry.GameRegistry;
import ExAstris.Data.ItemData;
import ExAstris.Item.ItemDollThaumic;
import ExAstris.Item.ItemHammerThaumium;
import net.minecraft.item.Item;

public class ExAstrisItem {
	public static Item DollThaumic;
	public static Item HammerThaumium;
	public static void registerItems()
	{
		DollThaumic = new ItemDollThaumic();
		GameRegistry.registerItem(DollThaumic, ItemData.THAUMIC_DOLL_UNLOCALIZED_NAME);
		
		HammerThaumium = new ItemHammerThaumium();
		GameRegistry.registerItem(HammerThaumium, ItemData.HAMMER_THAUMIUM_UNLOCALIZED_NAME);
	}
}
