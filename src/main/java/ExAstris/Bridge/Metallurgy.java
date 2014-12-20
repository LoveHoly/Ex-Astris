package ExAstris.Bridge;

import ExAstris.ExAstrisBlock;
import ExAstris.ExAstrisItem;
import ExAstris.Data.ModData;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.registries.SieveRegistry;

public class Metallurgy {
	public static void init()
	{
		addHammerRegistry();
		addSieveRegistry();
	}
	public static void addHammerRegistry()
	{
		if(ModData.allowMetallurgyOres)
		{
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.eximiteOreBlock, ExAstrisItem.eximiteOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.meutoiteOreBlock, ExAstrisItem.meutoiteOreItem);
			
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.prometheumOreBlock,  ExAstrisItem.prometheumOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.deepironOreBlock,  ExAstrisItem.deepironOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.infuscoliumOreBlock,  ExAstrisItem.infuscoliumOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.oureclaseOreBlock,  ExAstrisItem.oureclaseOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.astralsilverOreBlock,  ExAstrisItem.astralsilverOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.carmotOreBlock,  ExAstrisItem.carmotOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.mithrilOreBlock,  ExAstrisItem.mithrilOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.rubraciumOreBlock,  ExAstrisItem.rubraciumOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.orichalcumOreBlock,  ExAstrisItem.orichalcumOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.adamantineOreBlock,  ExAstrisItem.adamantineOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.atlarusOreBlock,  ExAstrisItem.atlarusOreItem);
			
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.ignatiusOreBlock,  ExAstrisItem.ignatiusOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.shadowironOreBlock,  ExAstrisItem.shadowironOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.lemuriteOreBlock,  ExAstrisItem.lemuriteOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.midasiumOreBlock,  ExAstrisItem.midasiumOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.vyroxeresOreBlock,  ExAstrisItem.vyroxeresOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.ceruclaseOreBlock,  ExAstrisItem.ceruclaseOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.alduoriteOreBlock,  ExAstrisItem.alduoriteOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.kalendriteOreBlock,  ExAstrisItem.kalendriteOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.vulcaniteOreBlock,  ExAstrisItem.vulcaniteOreItem);
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.sanguiniteOreBlock,  ExAstrisItem.sanguiniteOreItem);
		}
		

	}
	public static void addSieveRegistry()
	{
		if(ModData.allowMetallurgyOres)
		{
			//Sulfur
			SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 0, 128);
			//phosphorus
			SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 1, 128);
			//saltpeter
			SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 2, 128);
			//magnesium
			SieveRegistry.register(Blocks.gravel, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 3, 128);
			//bitumen
			SieveRegistry.register(Blocks.gravel, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 4, 128);
			//potash
			SieveRegistry.register(Blocks.gravel, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 5, 128);
			

			SieveRegistry.register(ENBlocks.EnderGravel, 0, ExAstrisItem.eximiteOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.EnderGravel, 0, ExAstrisItem.meutoiteOreItem, 0, 128);
			
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.prometheumOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.deepironOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.infuscoliumOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.oureclaseOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.astralsilverOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.carmotOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.mithrilOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.rubraciumOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.orichalcumOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.adamantineOreItem);
			RegistryFactory.SieveOreRegistryFactory(ExAstrisItem.atlarusOreItem);

			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.ignatiusOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.shadowironOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.lemuriteOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.midasiumOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.vyroxeresOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.ceruclaseOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.alduoriteOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.kalendriteOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.vulcaniteOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.sanguiniteOreItem, 0, 128);
		}		
	}
}
