package ExAstris.Bridge;

import ExAstris.ExAstrisBlock;
import ExAstris.ExAstrisItem;
import ExAstris.Data.ModData;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.common.config.ConfigResearch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import exnihilo.ENItems;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;

public class Thaumcraft {
	public static void Initialize()
	{
		HammerRegistry.register(Blocks.double_stone_slab, 1, GameRegistry.findItem("Thaumcraft", "ItemShard"), 0, 1.00f, 0.0f);
		HammerRegistry.register(Blocks.nether_brick, 0, GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 1.00f, 0.0f);
		HammerRegistry.register(Blocks.grass, 0, GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 1.00f, 0.0f);
		HammerRegistry.register(Blocks.ice, 0, GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 1.00f, 0.0f);
		HammerRegistry.register(Blocks.tnt, 0, GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 1.00f, 0.0f);
		HammerRegistry.register(Blocks.obsidian, 0, GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 1.00f, 0.0f);
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("Thaumcraft", "ItemNugget"), 5, 128);
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("Thaumcraft", "ItemResource"), 6, 128);
		addPages();
		addInfusion();
		addArcane();
		addCrucible();
		addResearch();
	}
	public static void addResearch()
	{
		new ResearchItem("EXASTRIS_SHARD",
				"EXASTRIS_THAUM",
				new AspectList(),
				0,
				0,
				0,
				new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 0)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.1"), new ResearchPage("exastris.page.EXASTRISTHAUM.2")
				}).setStub().setRound().setAutoUnlock().registerResearchItem();
		new ResearchItem("EXASTRIS_BARRELTHAUMIUM",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.TOOL, 10).add(Aspect.WATER, 10).add(Aspect.MAGIC, 10).add(Aspect.CRAFT, 10),
				0,
				-2,
				0,
				new ItemStack(ExAstrisBlock.BarrelThaumium, 1, 0)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.3"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("exastrisbarrelthaumium"))
				}).setConcealed().registerResearchItem();
		new ResearchItem("EXASTRIS_DOLLTHAUMIC",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.SOUL, 10).add(Aspect.GREED, 10).add(Aspect.MAGIC, 10),
				2,
				-2,
				0,
				new ItemStack(ExAstrisItem.DollThaumic, 1, 0)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.4"),new ResearchPage((CrucibleRecipe)ConfigResearch.recipes.get("exastrisdollthaumic"))
				}).setConcealed().setParents("EXASTRIS_BARRELTHAUMIUM").registerResearchItem();
		new ResearchItem("EXASTRIS_VISFILTER",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.WATER, 10).add(Aspect.ORDER, 10),
				-2,
				0,
				0,
				new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 8)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.5"),new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("exastrisvisfilter"))
				}).setConcealed().registerResearchItem();
		new ResearchItem("EXASTRIS_MATRIX",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.WATER, 10).add(Aspect.FIRE, 10).add(Aspect.EARTH, 10).add(Aspect.AIR, 10),
				-2,
				-2,
				0,
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockStoneDevice"), 1, 2)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.6"),new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("exastrismatrix"))
				}).setConcealed().setParents("EXASTRIS_VISFILTER").registerResearchItem();
		new ResearchItem("EXASTRIS_HAMMERTHAUMIUM",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.TOOL, 10).add(Aspect.MAGIC, 10),
				0,
				2,
				0,
				new ItemStack(ExAstrisItem.HammerThaumium, 1, 0)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.7"),new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("exastrishammerthaumium"))
				}).setConcealed().registerResearchItem();
		new ResearchItem("EXASTRIS_SHIMMERLEAF",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10).add(Aspect.EXCHANGE, 10),
				4,
				0,
				0,
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 2)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.8"),new ResearchPage((CrucibleRecipe)ConfigResearch.recipes.get("exastrisshimmerleaf"))
				}).setConcealed().registerResearchItem();
		new ResearchItem("EXASTRIS_CINDERPEARL",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10).add(Aspect.FIRE, 10),
				4,
				-2,
				0,
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 3)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.9"),new ResearchPage((CrucibleRecipe)ConfigResearch.recipes.get("exastriscinderpearl"))
				}).setConcealed().registerResearchItem();
				
		new ResearchItem("EXASTRIS_VISHROOM",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10).add(Aspect.FIRE, 10),
				4,
				2,
				0,
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 5)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.10"),new ResearchPage((CrucibleRecipe)ConfigResearch.recipes.get("exastrisvishroom"))
				}).setConcealed().registerResearchItem();
		
		new ResearchItem("EXASTRIS_GREATWOOD",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.TREE, 10).add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10).add(Aspect.PLANT, 10),
				0,
				4,
				0,
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 0)).setPages(new ResearchPage[] {
						new ResearchPage("exastris.page.EXASTRISTHAUM.11"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("exastrisgreatwood"))
				}).setConcealed().registerResearchItem();
		new ResearchItem("EXASTRIS_SILVERWOOD",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.MAGIC, 20).add(Aspect.TREE, 20).add(Aspect.ORDER, 20).add(Aspect.VOID, 20),
				2,
				4,
				0,
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 1)).setPages(new ResearchPage[] {
						new ResearchPage("exastris.page.EXASTRISTHAUM.12"), new ResearchPage((InfusionRecipe)ConfigResearch.recipes.get("exastrissilverwood"))
				}).setConcealed().setSpecial().setParents("EXASTRIS_GREATWOOD").registerResearchItem();
		new ResearchItem("EXASTRIS_BEEHIVES",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.MAGIC, 10).add(Aspect.AIR, 10).add(Aspect.BEAST, 10).add(Aspect.CRAFT, 10),
				0,
				-4,
				0,
				new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.13"), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("exastriscurioushive")), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("exastrisunusualhive")), new ResearchPage((IArcaneRecipe)ConfigResearch.recipes.get("exastrisresonatinghive"))
				}).setConcealed().setParents("EXASTRIS_BARRELTHAUMIUM").registerResearchItem();
		new ResearchItem("EXASTRIS_ADVANCEBEEHIVES",
				"EXASTRIS_THAUM",
				new AspectList().add(Aspect.MAGIC, 10).add(Aspect.AIR, 10).add(Aspect.BEAST, 10).add(Aspect.CRAFT, 10),
				-2,
				-4,
				0,
				new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0)).setPages(new ResearchPage[] {
				new ResearchPage("exastris.page.EXASTRISTHAUM.14"), new ResearchPage("exastris.page.EXASTRISTHAUM.15")
				}).setConcealed().setSpecial().setParents("EXASTRIS_BEEHIVES").registerResearchItem();
	}
	public static void addPages()
	{
		ResearchCategories.registerCategory("EXASTRIS_THAUM", new ResourceLocation(ModData.TEXTURE_LOCATION,"textures/misc/thaumicpage.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
	}
	public static void addInfusion()
	{
		ConfigResearch.recipes.put("exastrisgreatwood", ThaumcraftApi.addInfusionCraftingRecipe("EXASTRIS_GREATWOOD",
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 0),
				10,
				new AspectList().add(Aspect.TREE, 128).add(Aspect.AIR, 64).add(Aspect.EARTH, 64).add(Aspect.FIRE, 64).add(Aspect.WATER, 64).add(Aspect.ORDER, 64).add(Aspect.ENTROPY, 64),
				new ItemStack(Blocks.sapling, 1, 3),
				new ItemStack[] {
				new ItemStack(GameRegistry.findItem("exnihilo", "bucket_witchwater"), 1, 0), new ItemStack(GameRegistry.findItem("exnihilo", "bucket_witchwater"), 1, 0), new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 3), 
				new ItemStack(GameRegistry.findItem("exnihilo", "bucket_witchwater"), 1, 0), new ItemStack(GameRegistry.findItem("exnihilo", "bucket_witchwater"), 1, 0), new ItemStack(GameRegistry.findItem("exnihilo", "bucket_witchwater"), 1, 0), 
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 2), new ItemStack(GameRegistry.findItem("exnihilo", "bucket_witchwater"), 1, 0)
		}));
		
		ConfigResearch.recipes.put("exastrissilverwood",ThaumcraftApi.addInfusionCraftingRecipe("EXASTRIS_SILVERWOOD",
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 1),
				12,
				new AspectList().add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64).add(Aspect.CRYSTAL, 64).add(Aspect.TREE, 128),
				new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 0),
				new ItemStack[] { 
					new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 14), new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 4), new ItemStack(Blocks.diamond_block, 1, 0),
					new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 4), new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 14), new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 4),
					new ItemStack(Blocks.diamond_block, 1, 0), new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 4)
		}));
		
		ConfigResearch.recipes.put("exastrisdeephive",ThaumcraftApi.addInfusionCraftingRecipe("EXASTRIS_ADVANCEBEEHIVES",
				new ItemStack(GameRegistry.findItem("MagicBees", "hive"), 1, 3),
				12,
				new AspectList().add(Aspect.MAGIC, 64).add(Aspect.BEAST, 64).add(Aspect.VOID, 32),
				new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0),
				new ItemStack[] { 
					new ItemStack(Blocks.stone, 1, 0), new ItemStack(Blocks.stone, 1, 0),
					new ItemStack(Blocks.stone, 1, 0), new ItemStack(Blocks.stone, 1, 0),
					new ItemStack(Blocks.stone, 1, 0), new ItemStack(Blocks.stone, 1, 0),
					new ItemStack(Blocks.stone, 1, 0), new ItemStack(Blocks.stone, 1, 0)
		}));
		
		ConfigResearch.recipes.put("exastrisinfernalhive",ThaumcraftApi.addInfusionCraftingRecipe("EXASTRIS_ADVANCEBEEHIVES",
				new ItemStack(GameRegistry.findItem("MagicBees", "hive"), 1, 4),
				12,
				new AspectList().add(Aspect.MAGIC, 64).add(Aspect.BEAST, 64).add(Aspect.FIRE, 32),
				new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0),
				new ItemStack[] { 
					new ItemStack(Blocks.nether_brick, 1, 0), new ItemStack(Blocks.nether_brick, 1, 0),
					new ItemStack(Blocks.nether_brick, 1, 0), new ItemStack(Blocks.nether_brick, 1, 0),
					new ItemStack(Blocks.nether_brick, 1, 0), new ItemStack(Blocks.nether_brick, 1, 0),
					new ItemStack(Blocks.nether_brick, 1, 0), new ItemStack(Blocks.nether_brick, 1, 0)
		}));
		
		ConfigResearch.recipes.put("exastrisoblivionhive",ThaumcraftApi.addInfusionCraftingRecipe("EXASTRIS_ADVANCEBEEHIVES",
				new ItemStack(GameRegistry.findItem("MagicBees", "hive"), 1, 5),
				12,
				new AspectList().add(Aspect.MAGIC, 64).add(Aspect.BEAST, 64).add(Aspect.ELDRITCH, 32),
				new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0),
				new ItemStack[] { 
					new ItemStack(Blocks.end_stone, 1, 0), new ItemStack(Blocks.end_stone, 1, 0),
					new ItemStack(Blocks.end_stone, 1, 0), new ItemStack(Blocks.end_stone, 1, 0),
					new ItemStack(Blocks.end_stone, 1, 0), new ItemStack(Blocks.end_stone, 1, 0),
					new ItemStack(Blocks.end_stone, 1, 0), new ItemStack(Blocks.end_stone, 1, 0)
		}));
	}
	public static void addArcane()
	{
		ConfigResearch.recipes.put("exastrisbarrelthaumium", ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_BARRELTHAUMIUM", new ItemStack(ExAstrisBlock.BarrelThaumium, 1, 0), new AspectList().add(Aspect.FIRE, 5).add(Aspect.WATER, 5), new Object[] { "a a", "a a", "aba", 'a', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"),1,2), 'b', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemNugget"),1,6) }));
		//ConfigResearch.recipes.put("exastrisdollthaumic", ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_DOLLTHAUMIC", new ItemStack(ExAstrisItem.DollThaumic, 1, 0), new AspectList().add(Aspect.EARTH, 10).add(Aspect.FIRE, 10), new Object[] { "aba", "cdc", "aea", 'a', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"),1,4), 'b', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"),1,6), 'c', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"),1,14), 'd', new ItemStack(ENItems.Doll,1,0), 'e', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"),1,3) }));
		ConfigResearch.recipes.put("exastrisvisfilter", ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_VISFILTER", new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 8), new AspectList().add(Aspect.ORDER, 5).add(Aspect.WATER, 5), new Object[] { "mmm", "imi", "mmm", 'i', Items.gold_ingot, 'm', new ItemStack(ENItems.Mesh, 1, 0) }));
		ConfigResearch.recipes.put("exastrismatrix", ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_MATRIX", new ItemStack(GameRegistry.findItem("Thaumcraft", "blockStoneDevice"), 1, 2), new AspectList().add(Aspect.AIR, 10).add(Aspect.EARTH, 10).add(Aspect.FIRE, 10).add(Aspect.WATER, 10).add(Aspect.ORDER, 10).add(Aspect.ENTROPY, 10), new Object[] { "bcb", "cec", "bcb", 'b', new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCosmeticSolid"), 1, 6), 'c', new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCrystal"), 1, 6), 'e', Items.ender_pearl }));
		ConfigResearch.recipes.put("exastrishammerthaumium", ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_HAMMERTHAUMIUM", new ItemStack(ExAstrisItem.HammerThaumium, 1, 0), new AspectList().add(Aspect.AIR, 2).add(Aspect.EARTH, 2).add(Aspect.FIRE, 2).add(Aspect.WATER, 2).add(Aspect.ORDER, 2).add(Aspect.ENTROPY, 2), new Object[] { " a ", " ba", "b  ", 'a', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 2), 'b', Items.stick}));
		ConfigResearch.recipes.put("exastriscurioushive", ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_BEEHIVES", new ItemStack(GameRegistry.findItem("MagicBees", "hive"), 1, 0), new AspectList().add(Aspect.AIR, 4).add(Aspect.EARTH, 4).add(Aspect.FIRE, 4).add(Aspect.WATER, 4), new Object[] { " a ", "aba", " a ", 'a', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 4), 'b', new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0)}));
		ConfigResearch.recipes.put("exastrisunusualhive", ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_BEEHIVES", new ItemStack(GameRegistry.findItem("MagicBees", "hive"), 1, 1), new AspectList().add(Aspect.AIR, 4).add(Aspect.EARTH, 4).add(Aspect.FIRE, 4).add(Aspect.WATER, 4), new Object[] { " a ", "aba", " a ", 'a', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 3), 'b', new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0)}));
		ConfigResearch.recipes.put("exastrisresonatinghive", ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_BEEHIVES", new ItemStack(GameRegistry.findItem("MagicBees", "hive"), 1, 2), new AspectList().add(Aspect.AIR, 4).add(Aspect.EARTH, 4).add(Aspect.FIRE, 4).add(Aspect.WATER, 4), new Object[] { " a ", "aba", " a ", 'a', new ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"), 1, 6), 'b', new ItemStack(ExAstrisBlock.BeeTrapInfused, 1, 0)}));
	}
	public static void addCrucible()
	{
		ConfigResearch.recipes.put("exastrisdollthaumic", ThaumcraftApi.addCrucibleRecipe("EXASTRIS_DOLLTHAUMIC", new ItemStack(ExAstrisItem.DollThaumic, 1, 0), new ItemStack(ENItems.Doll, 1, 0), new AspectList().add(Aspect.MAGIC, 8).add(Aspect.SOUL, 8).add(Aspect.GREED, 8)));
		ConfigResearch.recipes.put("exastrisshimmerleaf", ThaumcraftApi.addCrucibleRecipe("EXASTRIS_SHIMMERLEAF", new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 2), new ItemStack(Blocks.red_flower, 1, 0), new AspectList().add(Aspect.MAGIC, 4).add(Aspect.EXCHANGE, 4).add(Aspect.PLANT, 4)));
		ConfigResearch.recipes.put("exastriscinderpearl", ThaumcraftApi.addCrucibleRecipe("EXASTRIS_CINDERPEARL", new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 3), new ItemStack(Blocks.yellow_flower, 1, 0),new AspectList().add(Aspect.MAGIC, 4). add(Aspect.PLANT, 4).add(Aspect.FIRE, 4)));
		ConfigResearch.recipes.put("exastrisvishroom", ThaumcraftApi.addCrucibleRecipe("EXASTRIS_VISHROOM", new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCustomPlant"), 1, 5), new ItemStack(Blocks.brown_mushroom, 1, 0),new AspectList().add(Aspect.MAGIC, 4). add(Aspect.PLANT, 4).add(Aspect.POISON, 4)));
	}
}
