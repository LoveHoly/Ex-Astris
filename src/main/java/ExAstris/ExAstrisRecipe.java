package ExAstris;

import ExAstris.Bridge.RegistryFactory;
import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ExAstrisRecipe {
	public static void registerFurnaceRecipes()
	{
		if(Loader.isModLoaded("TConstruct") && ModData.allowAddTConstructNetherOre)
		{
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.cobaltOreBlock,new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 3));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.arditeOreBlock,new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 4));
		}
		if(Loader.isModLoaded("Metallurgy") && ModData.allowMetallurgyOres)
		{
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.eximiteOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "eximite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.meutoiteOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "meutoite.ingot"), 1, 0));
			
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.prometheumOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "prometheum.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.deepironOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "deep.iron.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.infuscoliumOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "infuscolium.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.oureclaseOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "oureclase.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.astralsilverOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "astral.silver.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.carmotOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "carmot.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.mithrilOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "mithril.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.rubraciumOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "rubracium.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.orichalcumOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "orichalcum.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.adamantineOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "adamantine.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.atlarusOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "atlarus.ingot"), 1, 0));
			
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.ignatiusOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "ignatius.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.shadowironOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "shadow.iron.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.lemuriteOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "lemurite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.midasiumOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "midasium.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.vyroxeresOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "vyroxeres.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.ceruclaseOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "ceruclase.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.alduoriteOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "alduorite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.kalendriteOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "kalendrite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.vulcaniteOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "vulcanite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(ExAstrisBlock.sanguiniteOreBlock,new ItemStack(GameRegistry.findItem("Metallurgy", "sanguinite.ingot"), 1, 0));
		}
	}
	public static void registerCraftingRecipes()
	{
		if(Loader.isModLoaded("RedstoneArsenal") && ModData.allowHammerRF){
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExAstrisItem.HammerRF, 1, 0),
					" x ",
					" yx",
					"y  ",
					'x', "ingotElectrumFlux",
					'y', new ItemStack(GameRegistry.findItem("RedstoneArsenal", "material"), 1, 193)));
		}
		if(Loader.isModLoaded("ThermalExpansion")){
			if(ModData.allowSieveAutomatic)
			{
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExAstrisBlock.SieveAutomatic, 1, 0),
						"aba",
						"aca",
						"d d",
						'a', "ingotInvar",
						'b', new ItemStack(GameRegistry.findItem("exnihilo", "mesh"), 1, 0), 
						'c', "gearElectrum",
						'd', "nuggetInvar"));
			}
			
			if (ModData.allowUpgrades)
			{
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExAstrisItem.sieveUpgradeItem, 2, 0), "aba", "bcb", "aba",
						'a', "nuggetElectrum",
						'b', "ingotInvar",
						'c', "dustPyrotheum"));

				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExAstrisItem.sieveUpgradeItem, 2, 1), "aba", "bcb", "aba",
						'a', "nuggetElectrum",
						'b', "ingotInvar",
						'c', "gemDiamond"));
			}
			if (ModData.allowHammerAutomatic)
			{
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExAstrisBlock.HammerAutomatic, 1, 0),
						"ada",
						"aba",
						"aca", 
						'a', "ingotInvar",
						'd', Blocks.piston,
						'c', Blocks.anvil,
						'b', Blocks.heavy_weighted_pressure_plate));
			}
			
			
			if(Loader.isModLoaded("Thaumcraft") && ModData.allowDollFreezing && ModData.allowThaumiumbarrel){

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
		
		if(ModData.allowEndCake)
		{
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.EndCake, 1, 0),
					"aaa",
					"bcb",
					"aaa",
					'a', Items.ender_eye, 
					'b', Items.cake, 
					'c', Items.golden_apple);
		}
		
		if(Loader.isModLoaded("TConstruct") && ModData.allowAddTConstructNetherOre)
		{
			OreRecipeFactory(ExAstrisBlock.cobaltOreBlock,ExAstrisItem.cobaltOreItem);
			OreRecipeFactory(ExAstrisBlock.arditeOreBlock,ExAstrisItem.arditeOreItem);
		}
		if(Loader.isModLoaded("RotaryCraft") && ModData.allowStronglyCompressedStone)
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
			GameRegistry.addRecipe(new ItemStack(ExAstrisBlock.QStronglyCompressedStone, 1, 0),
					"aaa",
					"aaa",
					"aaa",
					'a', new ItemStack(ExAstrisBlock.StronglyCompressedStone, 1, 2));
		}
		if(Loader.isModLoaded("Metallurgy") && ModData.allowMetallurgyOres)
		{
			OreRecipeFactory(ExAstrisBlock.eximiteOreBlock,ExAstrisItem.eximiteOreItem);
			OreRecipeFactory(ExAstrisBlock.meutoiteOreBlock,ExAstrisItem.meutoiteOreItem);
			
			OreRecipeFactory(ExAstrisBlock.prometheumOreBlock,ExAstrisItem.prometheumOreItem);
			OreRecipeFactory(ExAstrisBlock.deepironOreBlock,ExAstrisItem.deepironOreItem);
			OreRecipeFactory(ExAstrisBlock.infuscoliumOreBlock,ExAstrisItem.infuscoliumOreItem);
			OreRecipeFactory(ExAstrisBlock.oureclaseOreBlock,ExAstrisItem.oureclaseOreItem);
			OreRecipeFactory(ExAstrisBlock.astralsilverOreBlock,ExAstrisItem.astralsilverOreItem);
			OreRecipeFactory(ExAstrisBlock.carmotOreBlock,ExAstrisItem.carmotOreItem);
			OreRecipeFactory(ExAstrisBlock.mithrilOreBlock,ExAstrisItem.mithrilOreItem);
			OreRecipeFactory(ExAstrisBlock.rubraciumOreBlock,ExAstrisItem.rubraciumOreItem);
			OreRecipeFactory(ExAstrisBlock.orichalcumOreBlock,ExAstrisItem.orichalcumOreItem);
			OreRecipeFactory(ExAstrisBlock.adamantineOreBlock,ExAstrisItem.adamantineOreItem);
			OreRecipeFactory(ExAstrisBlock.atlarusOreBlock,ExAstrisItem.atlarusOreItem);
			
			OreRecipeFactory(ExAstrisBlock.ignatiusOreBlock,ExAstrisItem.ignatiusOreItem);
			OreRecipeFactory(ExAstrisBlock.shadowironOreBlock,ExAstrisItem.shadowironOreItem);
			OreRecipeFactory(ExAstrisBlock.lemuriteOreBlock,ExAstrisItem.lemuriteOreItem);
			OreRecipeFactory(ExAstrisBlock.midasiumOreBlock,ExAstrisItem.midasiumOreItem);
			OreRecipeFactory(ExAstrisBlock.vyroxeresOreBlock,ExAstrisItem.vyroxeresOreItem);
			OreRecipeFactory(ExAstrisBlock.ceruclaseOreBlock,ExAstrisItem.ceruclaseOreItem);
			OreRecipeFactory(ExAstrisBlock.alduoriteOreBlock,ExAstrisItem.alduoriteOreItem);
			OreRecipeFactory(ExAstrisBlock.kalendriteOreBlock,ExAstrisItem.kalendriteOreItem);
			OreRecipeFactory(ExAstrisBlock.vulcaniteOreBlock,ExAstrisItem.vulcaniteOreItem);
			OreRecipeFactory(ExAstrisBlock.sanguiniteOreBlock,ExAstrisItem.sanguiniteOreItem);
		}
	}
	public static void OreRecipeFactory(Block block,Item item)
	{
		GameRegistry.addRecipe(new ItemStack(block, 1, 0),
				"aa ",
				"aa ",
				"   ",
				'a', new ItemStack(item, 1, 0));
		
		GameRegistry.addRecipe(new ItemStack(block, 1,1),
				"aa ",
				"aa ",
				"   ",
				'a', new ItemStack(item, 1, 1));
		
		GameRegistry.addRecipe(new ItemStack(block ,1, 2),
				"aa ",
				"aa ",
				"   ",
				'a', new ItemStack(item, 1, 2));
	}
}
