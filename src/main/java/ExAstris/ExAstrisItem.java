package ExAstris;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import ExAstris.Bridge.BloodMagic;
import ExAstris.Bridge.Botania;
import ExAstris.Bridge.Chisel;
import ExAstris.Bridge.EnderIO;
import ExAstris.Bridge.Metallurgy;
import ExAstris.Bridge.RedstoneArsenal;
import ExAstris.Bridge.TConstruct;
import ExAstris.Bridge.Thaumcraft;
import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import ExAstris.Item.ItemSieveUpgrade;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ExAstrisItem {
	public static Item DollThaumic;
	public static Item HammerThaumium;
	public static Item HammerRF;
	public static Item DollFreezing;
	public static Item UnchargedNetherStar;
	public static Item CrookRF;
	
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
	
	public static Item nuggetElectricalSteel;
	
	public static Item chiselStone;
	
	public static Item manaHammer;
	
	public static void registerItems()
	{
		if(Loader.isModLoaded("Thaumcraft")){
			DollThaumic = Thaumcraft.dollThaumic();
			GameRegistry.registerItem(DollThaumic, ItemData.THAUMIC_DOLL_UNLOCALIZED_NAME);
			
			HammerThaumium = Thaumcraft.hammerThaumic();
			GameRegistry.registerItem(HammerThaumium, ItemData.HAMMER_THAUMIUM_UNLOCALIZED_NAME);
			if(Loader.isModLoaded("ThermalExpansion")){
				DollFreezing = Thaumcraft.dollFreezing();
				GameRegistry.registerItem(DollFreezing, ItemData.FREEZING_DOLL_UNLOCALIZED_NAME);
			}
		}
		if(Loader.isModLoaded("RedstoneArsenal"))
		{
			if (ModData.allowHammerRF)
			{
				HammerRF = RedstoneArsenal.HammerRF();
				GameRegistry.registerItem(HammerRF, ItemData.HAMMER_RF_UNLOCALIZED_NAME);
			}
			if (ModData.allowCrookRF)
			{
				CrookRF = RedstoneArsenal.CrookRF();
				GameRegistry.registerItem(CrookRF, ItemData.CROOK_RF_UNLOCALIZED_NAME);
			}
		}
		
				
		if(Loader.isModLoaded("AWWayofTime") && ModData.allowUnchargedNetherstar){
			UnchargedNetherStar = BloodMagic.unchargedNetherStar();
			GameRegistry.registerItem(UnchargedNetherStar, ItemData.UNCHARGED_NETHERSTAR_UNLOCALIZED_NAME);
		}
		
		if(Loader.isModLoaded("TConstruct") && ModData.allowAddTConstructNetherOre)
		{
			cobaltOreItem = TConstruct.oreItem("Cobalt");
			GameRegistry.registerItem(cobaltOreItem, "CobaltOreItem");

			arditeOreItem = TConstruct.oreItem("Ardite");
			GameRegistry.registerItem(arditeOreItem, "ArditeOreItem");
		}
		
		if(Loader.isModLoaded("Metallurgy") && ModData.allowMetallurgyOres)
		{
			eximiteOreItem = Metallurgy.oreItem("Eximite");
			GameRegistry.registerItem(eximiteOreItem, "EximiteOreItem");

			meutoiteOreItem = Metallurgy.oreItem("Meutoite");
			GameRegistry.registerItem(meutoiteOreItem, "MeutoiteOreItem");
			
			prometheumOreItem = Metallurgy.oreItem("Prometheum");
			deepironOreItem = Metallurgy.oreItem("DeepIron");
			infuscoliumOreItem = Metallurgy.oreItem("Infuscolium");
			oureclaseOreItem = Metallurgy.oreItem("Oureclase");
			astralsilverOreItem = Metallurgy.oreItem("AstralSilver");
			carmotOreItem = Metallurgy.oreItem("Carmot");
			mithrilOreItem = Metallurgy.oreItem("Mithril");
			rubraciumOreItem = Metallurgy.oreItem("Rubracium");
			orichalcumOreItem = Metallurgy.oreItem("Orichalcum");
			adamantineOreItem = Metallurgy.oreItem("Adamantine");
			atlarusOreItem = Metallurgy.oreItem("Atlarus");
			
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
			
			ignatiusOreItem = Metallurgy.oreItem("Ignatius");
			shadowironOreItem = Metallurgy.oreItem("ShadowIron");
			lemuriteOreItem = Metallurgy.oreItem("Lemurite");
			midasiumOreItem = Metallurgy.oreItem("Midasium");
			vyroxeresOreItem = Metallurgy.oreItem("Vyroxeres");
			ceruclaseOreItem = Metallurgy.oreItem("Ceruclase");
			alduoriteOreItem = Metallurgy.oreItem("Alduorite");
			kalendriteOreItem = Metallurgy.oreItem("Kalendrite");
			vulcaniteOreItem = Metallurgy.oreItem("Vulcanite");
			sanguiniteOreItem = Metallurgy.oreItem("Sanguinite");
			
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
		if (ModData.allowSieveAutomatic)
		{
			sieveUpgradeItem = new ItemSieveUpgrade();
			GameRegistry.registerItem(sieveUpgradeItem, "SieveUpgradeItem");
		}
		
		if (Loader.isModLoaded("chisel"))
		{
			chiselStone = Chisel.chiselStones();
			GameRegistry.registerItem(chiselStone, "chiselStone");
		}
		
		if (Loader.isModLoaded("EnderIO"))
		{
			nuggetElectricalSteel = EnderIO.electricalNugget();
			GameRegistry.registerItem(nuggetElectricalSteel, "nuggetElectricalSteel");
			OreDictionary.registerOre("nuggetElectricalSteel", nuggetElectricalSteel);
		}
		
		if (Loader.isModLoaded("Botania"))
		{
			manaHammer = Botania.manaHammer();
			GameRegistry.registerItem(manaHammer, "manaHammer");
		}
	}
}
