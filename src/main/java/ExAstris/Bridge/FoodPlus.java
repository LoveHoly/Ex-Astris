package ExAstris.Bridge;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.SieveRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import ExAstris.ExAstrisItem;
import ExAstris.Data.ModData;
import ExAstris.Item.ItemFoodPlusSeed;

public class FoodPlus {
	
	public static void init()
	{
		Block[] saplingBlocks = {GameRegistry.findBlock("FoodPlus", "cherry_sapling"),
			GameRegistry.findBlock("FoodPlus", "banana_sapling"),
			GameRegistry.findBlock("FoodPlus", "orange_sapling"),
			GameRegistry.findBlock("FoodPlus", "kiwi_sapling"),
			GameRegistry.findBlock("FoodPlus", "walnut_sapling"),
			GameRegistry.findBlock("FoodPlus", "coconut_sapling"),
			GameRegistry.findBlock("FoodPlus", "pear_sapling")};	
		ItemFoodPlusSeed.addPlants(saplingBlocks);
		
		SieveRegistry.register(Blocks.grass, ExAstrisItem.foodPlusSeed, 0, ModData.foodPlusSaplingSiftingChance);
		
		if (ModData.allowFoodPlusSaplingsToBeComposted)
		{
			for (Block bl : saplingBlocks)
				CompostRegistry.register(Item.getItemFromBlock(bl), 0, 0.125f, ColorRegistry.color("oak"));
		}
	}
	
	public static Item foodPlusSeed()
	{
		return new ItemFoodPlusSeed();
	}

}
