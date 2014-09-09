package ExAstris;

import ExAstris.Block.BlockBarrelThaumium;
import ExAstris.Block.BlockBeeTrapInfused;
import ExAstris.Block.BlockSieveAutomatic;
import ExAstris.Block.ItemBlock.ItemBlockBarrelThaumium;
import ExAstris.Block.ItemBlock.ItemBlockSieveAutomatic;
import ExAstris.Data.BlockData;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ExAstrisBlock {
	public static Block BarrelThaumium;
	public static Block BeeTrapInfused;
	public static Block SieveAutomatic;
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
		
		if(Loader.isModLoaded("ThermalExpansion")){
			SieveAutomatic = new BlockSieveAutomatic();
			GameRegistry.registerBlock(SieveAutomatic, ItemBlockSieveAutomatic.class, BlockData.SIEVE_AUTOMATIC_KEY);
		}
	}
}
