package ExAstris;

import ExAstris.Block.BlockBarrelThaumium;
import ExAstris.Block.BlockBeeTrapInfused;
import ExAstris.Block.BlockEndCake;
import ExAstris.Block.BlockOre;
import ExAstris.Block.BlockSieveAutomatic;
import ExAstris.Block.BlockStronglyCompressedStone;
import ExAstris.Block.ItemBlock.ItemBlockBarrelThaumium;
import ExAstris.Block.ItemBlock.ItemBlockEndCake;
import ExAstris.Block.ItemBlock.ItemBlockOre;
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

	public static Block cobaltOreBlock;
	public static Block arditeOreBlock;
	
	public static Block StronglyCompressedStone;
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
		
		EndCake = new BlockEndCake();
		GameRegistry.registerBlock(EndCake, ItemBlockEndCake.class, BlockData.ENDCAKE_KEY);
		
		if(Loader.isModLoaded("TConstruct") && ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			cobaltOreBlock = new BlockOre("Cobalt");
			GameRegistry.registerBlock(cobaltOreBlock, ItemBlockOre.class, "CobaltOreBlock");
			
			arditeOreBlock = new BlockOre("Ardite");
			GameRegistry.registerBlock(arditeOreBlock, ItemBlockOre.class, "ArditeOreBlock");
			
		}
		
		if(Loader.isModLoaded("RotaryCraft") && ModData.ALLOW_STRONGLY_COMPRESSED_STONE)
		{
			StronglyCompressedStone = new BlockStronglyCompressedStone();
			GameRegistry.registerBlock(StronglyCompressedStone, ItemBlockStronglyCompressedStone.class, BlockData.STRONGLY_COMPRESSED_STONE_KEY);
			
		}
	}
}
