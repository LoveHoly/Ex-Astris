package ExAstris;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
			
			if(Loader.isModLoaded("Thaumcraft")){
				GameRegistry.addRecipe(new ItemStack(ExAstrisItem.DollFreezing, 1, 0),
						"aba",
						"ded",
						"aca",
						'a', Items.snowball, 
						'b', Items.nether_wart, 
						'c', Items.redstone, 
						'd', Items.glowstone_dust, 
						'e', new ItemStack(GameRegistry.findItem("exnihilo", "doll"), 1, 0));
			}
			
		}
		if(Loader.isModLoaded("AWWayofTime")){
			GameRegistry.addRecipe(new ItemStack(ExAstrisItem.UnchargedNetherStar, 1, 0),
					"aaa",
					"dbd",
					"cef",
					'a', Items.skull, 
					'b', Items.quartz, 
					'c', Items.diamond_axe, 
					'd', Blocks.soul_sand, 
					'e', Items.diamond_pickaxe, 
					'f', Items.diamond_sword);
		}
		
	}
}
