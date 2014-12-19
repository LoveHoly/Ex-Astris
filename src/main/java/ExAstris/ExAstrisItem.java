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
import ExAstris.Item.ItemSieveUpgrade;
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
	
	//TConstruct Nether ores
	public static Item cobaltOreItem;
	public static Item arditeOreItem;
	
	//Metallurgy
	public static Item eximiteOreItem;
	public static Item meutoiteOreItem;

	public static Item prometheumOreItem;
	public static Item deepironOreItem;
	public static Item infuscoliumOreItem;
	public static Item oureclaseOreItem;
	public static Item astralsilverOreItem;
	public static Item carmotOreItem;
	public static Item mithrilOreItem;
	public static Item rubraciumOreItem;
	public static Item orichalcumOreItem;
	public static Item adamantineOreItem;
	public static Item atlarusOreItem;
	
	public static Item ignatiusOreItem;
	public static Item shadowironOreItem;
	public static Item lemuriteOreItem;
	public static Item midasiumOreItem;
	public static Item vyroxeresOreItem;
	public static Item ceruclaseOreItem;
	public static Item alduoriteOreItem;
	public static Item kalendriteOreItem;
	public static Item vulcaniteOreItem;
	public static Item sanguiniteOreItem;
	
	public static Item sieveUpgradeItem;
	
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
			GameRegistry.registerItem(cobaltOreItem, "CobaltOreItem");

			arditeOreItem = new ItemOre("Ardite");
			GameRegistry.registerItem(arditeOreItem, "ArditeOreItem");
		}
		
		if(Loader.isModLoaded("Metallurgy") && ModData.ALLOW_METALLURGY_ORES)
		{
			eximiteOreItem = new ItemOre("Eximite");
			GameRegistry.registerItem(eximiteOreItem, "EximiteOreItem");

			meutoiteOreItem = new ItemOre("Meutoite");
			GameRegistry.registerItem(meutoiteOreItem, "MeutoiteOreItem");
			
			prometheumOreItem = new ItemOre("Prometheum");
			deepironOreItem = new ItemOre("DeepIron");
			infuscoliumOreItem = new ItemOre("Infuscolium");
			oureclaseOreItem = new ItemOre("Oureclase");
			astralsilverOreItem = new ItemOre("AstralSilver");
			carmotOreItem = new ItemOre("Carmot");
			mithrilOreItem = new ItemOre("Mithril");
			rubraciumOreItem = new ItemOre("Rubracium");
			orichalcumOreItem = new ItemOre("Orichalcum");
			adamantineOreItem = new ItemOre("Adamantine");
			atlarusOreItem = new ItemOre("Atlarus");
			
			GameRegistry.registerItem(prometheumOreItem,  "PrometheumOreItem");
			GameRegistry.registerItem(deepironOreItem,  "DeepIronOreItem");
			GameRegistry.registerItem(infuscoliumOreItem, "InfuscoliumOreItem");
			GameRegistry.registerItem(oureclaseOreItem,  "OureclaseOreItem");
			GameRegistry.registerItem(astralsilverOreItem,  "AstralSilverOreItem");
			GameRegistry.registerItem(carmotOreItem,  "CarmotOreItem");
			GameRegistry.registerItem(mithrilOreItem,  "MithrilOreItem");
			GameRegistry.registerItem(rubraciumOreItem, "RubraciumOreItem");
			GameRegistry.registerItem(orichalcumOreItem, "OrichalcumOreItem");
			GameRegistry.registerItem(adamantineOreItem, "AdamantineOreItem");
			GameRegistry.registerItem(atlarusOreItem,  "AtlarusOreItem");
			
			ignatiusOreItem = new ItemOre("Ignatius");
			shadowironOreItem = new ItemOre("ShadowIron");
			lemuriteOreItem = new ItemOre("Lemurite");
			midasiumOreItem = new ItemOre("Midasium");
			vyroxeresOreItem = new ItemOre("Vyroxeres");
			ceruclaseOreItem = new ItemOre("Ceruclase");
			alduoriteOreItem = new ItemOre("Alduorite");
			kalendriteOreItem = new ItemOre("Kalendrite");
			vulcaniteOreItem = new ItemOre("Vulcanite");
			sanguiniteOreItem = new ItemOre("Sanguinite");
			
			GameRegistry.registerItem(ignatiusOreItem,  "IgnatiusOreItem");
			GameRegistry.registerItem(shadowironOreItem,  "ShadowIronOreItem");
			GameRegistry.registerItem(lemuriteOreItem,  "LemuriteOreItem");
			GameRegistry.registerItem(midasiumOreItem,  "MidasiumOreItem");
			GameRegistry.registerItem(vyroxeresOreItem,  "VyroxeresOreItem");
			GameRegistry.registerItem(ceruclaseOreItem,  "CeruclaseOreItem");
			GameRegistry.registerItem(alduoriteOreItem,  "AlduoriteOreItem");
			GameRegistry.registerItem(kalendriteOreItem,  "KalendriteOreItem");
			GameRegistry.registerItem(vulcaniteOreItem,  "VulcaniteOreItem");
			GameRegistry.registerItem(sanguiniteOreItem,  "SanguiniteOreItem");
		}
		if (ModData.ALLOW_SIEVE_AUTOMATIC)
		{
			sieveUpgradeItem = new ItemSieveUpgrade();
			GameRegistry.registerItem(sieveUpgradeItem, "SieveUpgradeItem");
		}
	}
}
