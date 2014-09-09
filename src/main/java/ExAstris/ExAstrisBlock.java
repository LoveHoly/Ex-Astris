package ExAstris;

import ExAstris.Block.BlockBarrelThaumium;
import ExAstris.Block.BlockBeeTrapInfused;
import ExAstris.Block.BlockSieveAutomatic;
import ExAstris.Block.ItemBlock.ItemBlockBarrelThaumium;
import ExAstris.Block.ItemBlock.ItemBlockSieveAutomatic;
import ExAstris.Data.BlockData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ExAstrisBlock {
	public static Block BarrelThaumium;
	public static Block BeeTrapInfused;
	public static Block SieveAutomatic;
	public static void registerBlocks()
	{
		BarrelThaumium = new BlockBarrelThaumium();
		GameRegistry.registerBlock(BarrelThaumium, ItemBlockBarrelThaumium.class, BlockData.BARREL_THAUMIUM_KEY);
		
		BeeTrapInfused = new BlockBeeTrapInfused();
		GameRegistry.registerBlock(BeeTrapInfused, BlockData.BEE_TRAP_INFUSED_KEY);
		
		SieveAutomatic = new BlockSieveAutomatic();
		GameRegistry.registerBlock(SieveAutomatic, ItemBlockSieveAutomatic.class, BlockData.SIEVE_AUTOMATIC_KEY);
	}
}
