package ExAstris;

import ExAstris.Block.BlockBarrelThaumium;
import ExAstris.Block.BlockBeeTrapInfused;
import ExAstris.Block.BlockEndCake;
import ExAstris.Block.BlockHammerAutomatic;
import ExAstris.Block.BlockOre;
import ExAstris.Block.BlockQStronglyCompressedStone;
import ExAstris.Block.BlockRotaryAlveary;
import ExAstris.Block.BlockSieveAutomatic;
import ExAstris.Block.BlockStronglyCompressedStone;
import ExAstris.Block.ItemBlock.ItemBlockBarrelThaumium;
import ExAstris.Block.ItemBlock.ItemBlockEndCake;
import ExAstris.Block.ItemBlock.ItemBlockOre;
import ExAstris.Block.ItemBlock.ItemBlockQStronglyCompressedStone;
import ExAstris.Block.ItemBlock.ItemBlockRotaryAlveary;
import ExAstris.Block.ItemBlock.ItemBlockSieveAutomatic;
import ExAstris.Block.ItemBlock.ItemBlockStronglyCompressedStone;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ExAstrisBlock {
	public static Block BarrelThaumium;
	public static Block BeeTrapInfused;
	public static Block SieveAutomatic;
	public static Block EndCake;
	public static Block HammerAutomatic;

	public static Block cobaltOreBlock;
	public static Block arditeOreBlock;

	public static Block StronglyCompressedStone;
	public static Block QStronglyCompressedStone;
	public static Block RotaryAlveary;
	
	public static Block eximiteOreBlock;
	public static Block meutoiteOreBlock;
	
	public static Block prometheumOreBlock;
	public static Block deepironOreBlock;
	public static Block infuscoliumOreBlock;
	public static Block oureclaseOreBlock;
	public static Block astralsilverOreBlock;
	public static Block carmotOreBlock;
	public static Block mithrilOreBlock;
	public static Block rubraciumOreBlock;
	public static Block orichalcumOreBlock;
	public static Block adamantineOreBlock;
	public static Block atlarusOreBlock;

	public static Block ignatiusOreBlock;
	public static Block shadowironOreBlock;
	public static Block lemuriteOreBlock;
	public static Block midasiumOreBlock;
	public static Block vyroxeresOreBlock;
	public static Block ceruclaseOreBlock;
	public static Block alduoriteOreBlock;
	public static Block kalendriteOreBlock;
	public static Block vulcaniteOreBlock;
	public static Block sanguiniteOreBlock;
	
	public static void registerBlocks()
	{
		if(Loader.isModLoaded("Thaumcraft")){
			BarrelThaumium = new BlockBarrelThaumium();
			GameRegistry.registerBlock(BarrelThaumium, ItemBlockBarrelThaumium.class, BlockData.BARREL_THAUMIUM_KEY);
			if(Loader.isModLoaded("MagicBees")){
				BeeTrapInfused = new BlockBeeTrapInfused();
				GameRegistry.registerBlock(BeeTrapInfused, BlockData.BEE_TRAP_INFUSED_KEY);
			}
		}
		
		if(Loader.isModLoaded("ThermalFoundation") || Loader.isModLoaded("EnderIO")) {
			SieveAutomatic = new BlockSieveAutomatic();
			GameRegistry.registerBlock(SieveAutomatic, ItemBlockSieveAutomatic.class, BlockData.SIEVE_AUTOMATIC_KEY);
			HammerAutomatic = new BlockHammerAutomatic();
			GameRegistry.registerBlock(HammerAutomatic, BlockData.HAMMER_AUTOMATIC_KEY);
		}
		
		EndCake = new BlockEndCake();
		GameRegistry.registerBlock(EndCake, ItemBlockEndCake.class, BlockData.ENDCAKE_KEY);
		
		if(Loader.isModLoaded("TConstruct") && ModData.allowAddTConstructNetherOre)
		{
			cobaltOreBlock = new BlockOre("Cobalt");
			GameRegistry.registerBlock(cobaltOreBlock, ItemBlockOre.class, "CobaltOreBlock");
			
			arditeOreBlock = new BlockOre("Ardite");
			GameRegistry.registerBlock(arditeOreBlock, ItemBlockOre.class, "ArditeOreBlock");
			
		}
		
		if(Loader.isModLoaded("RotaryCraft") && ModData.allowStronglyCompressedStone)
		{
			StronglyCompressedStone = new BlockStronglyCompressedStone();
			GameRegistry.registerBlock(StronglyCompressedStone, ItemBlockStronglyCompressedStone.class, BlockData.STRONGLY_COMPRESSED_STONE_KEY);
			
			QStronglyCompressedStone = new BlockQStronglyCompressedStone();
			GameRegistry.registerBlock(QStronglyCompressedStone, ItemBlockQStronglyCompressedStone.class, BlockData.STRONGLY_COMPRESSED_STONE_KEY + "3");
			
			RotaryAlveary = new BlockRotaryAlveary();
			GameRegistry.registerBlock(RotaryAlveary, ItemBlockRotaryAlveary.class, BlockData.ROTARY_ALVEARY_KEY);
			
		}
		
		if(Loader.isModLoaded("Metallurgy") && ModData.allowMetallurgyOres)
		{
			eximiteOreBlock = new BlockOre("Eximite");
			GameRegistry.registerBlock(eximiteOreBlock, ItemBlockOre.class, "EximiteOreBlock");
			
			meutoiteOreBlock = new BlockOre("Meutoite");
			GameRegistry.registerBlock(meutoiteOreBlock, ItemBlockOre.class, "MeutoiteOreBlock");

			prometheumOreBlock = new BlockOre("Prometheum");
			deepironOreBlock = new BlockOre("DeepIron");
			infuscoliumOreBlock = new BlockOre("Infuscolium");
			oureclaseOreBlock = new BlockOre("Oureclase");
			astralsilverOreBlock = new BlockOre("AstralSilver");
			carmotOreBlock = new BlockOre("Carmot");
			mithrilOreBlock = new BlockOre("Mithril");
			rubraciumOreBlock = new BlockOre("Rubracium");
			orichalcumOreBlock = new BlockOre("Orichalcum");
			adamantineOreBlock = new BlockOre("Adamantine");
			atlarusOreBlock = new BlockOre("Atlarus");
			
			GameRegistry.registerBlock(prometheumOreBlock, ItemBlockOre.class, "PrometheumOreBlock");
			GameRegistry.registerBlock(deepironOreBlock, ItemBlockOre.class, "DeepIronOreBlock");
			GameRegistry.registerBlock(infuscoliumOreBlock, ItemBlockOre.class, "InfuscoliumOreBlock");
			GameRegistry.registerBlock(oureclaseOreBlock, ItemBlockOre.class, "OureclaseOreBlock");
			GameRegistry.registerBlock(astralsilverOreBlock, ItemBlockOre.class, "AstralSilverOreBlock");
			GameRegistry.registerBlock(carmotOreBlock, ItemBlockOre.class, "CarmotOreBlock");
			GameRegistry.registerBlock(mithrilOreBlock, ItemBlockOre.class, "MithrilOreBlock");
			GameRegistry.registerBlock(rubraciumOreBlock, ItemBlockOre.class, "RubraciumOreBlock");
			GameRegistry.registerBlock(orichalcumOreBlock, ItemBlockOre.class, "OrichalcumOreBlock");
			GameRegistry.registerBlock(adamantineOreBlock, ItemBlockOre.class, "AdamantineOreBlock");
			GameRegistry.registerBlock(atlarusOreBlock, ItemBlockOre.class, "AtlarusOreBlock");
			
			ignatiusOreBlock = new BlockOre("Ignatius");
			shadowironOreBlock = new BlockOre("ShadowIron");
			lemuriteOreBlock = new BlockOre("Lemurite");
			midasiumOreBlock = new BlockOre("Midasium");
			vyroxeresOreBlock = new BlockOre("Vyroxeres");
			ceruclaseOreBlock = new BlockOre("Ceruclase");
			alduoriteOreBlock = new BlockOre("Alduorite");
			kalendriteOreBlock = new BlockOre("Kalendrite");
			vulcaniteOreBlock = new BlockOre("Vulcanite");
			sanguiniteOreBlock = new BlockOre("Sanguinite");
			
			GameRegistry.registerBlock(ignatiusOreBlock, ItemBlockOre.class, "IgnatiusOreBlock");
			GameRegistry.registerBlock(shadowironOreBlock, ItemBlockOre.class, "ShadowIronOreBlock");
			GameRegistry.registerBlock(lemuriteOreBlock, ItemBlockOre.class, "LemuriteOreBlock");
			GameRegistry.registerBlock(midasiumOreBlock, ItemBlockOre.class, "MidasiumOreBlock");
			GameRegistry.registerBlock(vyroxeresOreBlock, ItemBlockOre.class, "VyroxeresOreBlock");
			GameRegistry.registerBlock(ceruclaseOreBlock, ItemBlockOre.class, "CeruclaseOreBlock");
			GameRegistry.registerBlock(alduoriteOreBlock, ItemBlockOre.class, "AlduoriteOreBlock");
			GameRegistry.registerBlock(kalendriteOreBlock, ItemBlockOre.class, "KalendriteOreBlock");
			GameRegistry.registerBlock(vulcaniteOreBlock, ItemBlockOre.class, "VulcaniteOreBlock");
			GameRegistry.registerBlock(sanguiniteOreBlock, ItemBlockOre.class, "SanguiniteOreBlock");
		}
	}
}
