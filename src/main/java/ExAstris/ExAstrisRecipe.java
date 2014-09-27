package ExAstris;

import ExAstris.Data.ModData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.HammerRegistry;



public class ExAstrisRecipe {
	public static void registerFurnaceRecipes()
	{
		if(Loader.isModLoaded("TConstruct") && ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			ItemStack cobaltOreBlock = new ItemStack(ExAstrisBlock.cobaltOreBlock);
			ItemStack cobaltOreBlock1 = new ItemStack(ExAstrisBlock.cobaltOreBlock);
			ItemStack cobaltOreBlock2 = new ItemStack(ExAstrisBlock.cobaltOreBlock);
			
			ItemStack arditeOreBlock = new ItemStack(ExAstrisBlock.arditeOreBlock);
			ItemStack arditeOreBlock1 = new ItemStack(ExAstrisBlock.arditeOreBlock);
			ItemStack arditeOreBlock2 = new ItemStack(ExAstrisBlock.arditeOreBlock);
			
			cobaltOreBlock1.setItemDamage(1);
			cobaltOreBlock2.setItemDamage(2);
			GameRegistry.addSmelting(cobaltOreBlock, new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 3), 0.1f);
			GameRegistry.addSmelting(cobaltOreBlock1, new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 3), 0.1f);
			GameRegistry.addSmelting(cobaltOreBlock2, new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 3), 0.1f);
			
			
			arditeOreBlock1.setItemDamage(1);
			arditeOreBlock2.setItemDamage(2);
			GameRegistry.addSmelting(arditeOreBlock, new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 4), 0.1f);
			GameRegistry.addSmelting(arditeOreBlock1, new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 4), 0.1f);
			GameRegistry.addSmelting(arditeOreBlock2, new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 4), 0.1f);
		}
	}
	public static void registerCraftingRecipes()
	{
		if(Loader.isModLoaded("RedstoneArsenal") && ModData.ALLOW_HAMMER_RF){
			GameRegistry.addRecipe(new ItemStack(ExAstrisItem.HammerRF, 1, 0),
					" x ",
					" yx",
					"y  ",
					'x', new ItemStack(GameRegistry.findItem("RedstoneArsenal", "material"), 1, 32), 
					'y', new ItemStack(GameRegistry.findItem("RedstoneArsenal", "material"), 1, 193));
		}
		if(Loader.isModLoaded("ThermalExpansion")){
			if(ModData.ALLOW_SIEVE_AUTOMATIC)
			{
				GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.SieveAutomatic, 1, 0),
						"aba",
						"aca",
						"d d",
						'a', new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 72), 
						'b', new ItemStack(GameRegistry.findItem("exnihilo", "mesh"), 1, 0), 
						'c', new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 135), 
						'd', new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 104));
			}
			
			
			if(Loader.isModLoaded("Thaumcraft") && ModData.ALLOW_DOLL_FREEZING && ModData.ALLOW_BARREL_THAUMIUM){

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
		
		if(ModData.ALLOW_ENDCAKE)
		{
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.EndCake, 1, 0),
					"aaa",
					"bcb",
					"aaa",
					'a', Items.ender_eye, 
					'b', Items.cake, 
					'c', Items.golden_apple);
		}
		
		if(Loader.isModLoaded("TConstruct") && ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			//ExAstris.log.info("+++ - TOOOLLLLLLLLLLLLL"+
				//	Blocks.cobblestone.getHarvestTool(0));
			
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.cobaltOreBlock, 1, 0),
					"aa ",
					"aa ",
					"   ",
					'a', new ItemStack(ExAstrisItem.cobaltOreItem, 1, 0));
			
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.cobaltOreBlock, 1,1),
					"aa ",
					"aa ",
					"   ",
					'a', new ItemStack(ExAstrisItem.cobaltOreItem, 1, 1));
			
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.cobaltOreBlock, 1, 2),
					"aa ",
					"aa ",
					"   ",
					'a', new ItemStack(ExAstrisItem.cobaltOreItem, 1, 2));
			
			
			
			
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.arditeOreBlock, 1, 0),
					"aa ",
					"aa ",
					"   ",
					'a', new ItemStack(ExAstrisItem.arditeOreItem, 1, 0));
			
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.arditeOreBlock, 1,1),
					"aa ",
					"aa ",
					"   ",
					'a', new ItemStack(ExAstrisItem.arditeOreItem, 1, 1));
			
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.arditeOreBlock, 1, 2),
					"aa ",
					"aa ",
					"   ",
					'a', new ItemStack(ExAstrisItem.arditeOreItem, 1, 2));
			

			HammerRegistry.register(Blocks.netherrack, 0,ExAstrisItem.cobaltOreItem , 0, 1.00f, 0.0f);
			HammerRegistry.register(ExAstrisBlock.cobaltOreBlock, 0,ExAstrisItem.cobaltOreItem , 1, 1.00f, 0.0f);
			HammerRegistry.register(ExAstrisBlock.cobaltOreBlock, 1,ExAstrisItem.cobaltOreItem , 2, 1.00f, 0.0f);
			

			HammerRegistry.register(Blocks.netherrack, 0,ExAstrisItem.arditeOreItem , 0, 1.00f, 0.0f);
			HammerRegistry.register(ExAstrisBlock.arditeOreBlock, 0,ExAstrisItem.arditeOreItem , 1, 1.00f, 0.0f);
			HammerRegistry.register(ExAstrisBlock.arditeOreBlock, 1,ExAstrisItem.arditeOreItem , 2, 1.00f, 0.0f);
		}
		if(Loader.isModLoaded("RotaryCraft") && ModData.ALLOW_STRONGLY_COMPRESSED_STONE)
		{
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.StronglyCompressedStone, 1, 0),
					"aaa",
					"aaa",
					"aaa",
					'a', new ItemStack(Blocks.obsidian, 1, 0));
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.StronglyCompressedStone, 1, 1),
					"aaa",
					"aaa",
					"aaa",
					'a', new ItemStack(ExAstrisBlock.StronglyCompressedStone, 1, 0));
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.StronglyCompressedStone, 1, 2),
					"aaa",
					"aaa",
					"aaa",
					'a', new ItemStack(ExAstrisBlock.StronglyCompressedStone, 1, 1));
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.StronglyCompressedStone, 1, 3),
					"aaa",
					"aaa",
					"aaa",
					'a', new ItemStack(ExAstrisBlock.StronglyCompressedStone, 1, 2));
		}
	}
}
