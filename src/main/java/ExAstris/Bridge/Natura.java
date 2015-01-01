package ExAstris.Bridge;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import exnihilo.registries.SieveRegistry;
import ExAstris.Data.ModData;

public class Natura {
	
	public static void init()
	{
		if (ModData.allowNaturaPlants)
		{
			//Saplings
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 0, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 1, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 2, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 3, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 4, 128);
			
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","florasapling"), 0, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","florasapling"), 1, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","florasapling"), 2, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","florasapling"), 3, 128);
			
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","florasapling"), 4, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","florasapling"), 5, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","florasapling"), 6, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","florasapling"), 7, 128);
			
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","BerryBush"), 12, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","BerryBush"), 13, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","BerryBush"), 14, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","BerryBush"), 15, 128);
			
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","soil.tainted"), 0, 32);
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","heatsand"), 0, 32);	
			
			SieveRegistry.register(GameRegistry.findBlock("Natura", "soil.tainted"), 0, GameRegistry.findItem("Natura","NetherBerryBush"), 12, 64);
			SieveRegistry.register(GameRegistry.findBlock("Natura", "soil.tainted"), 0, GameRegistry.findItem("Natura","NetherBerryBush"), 13, 64);
			SieveRegistry.register(GameRegistry.findBlock("Natura", "soil.tainted"), 0, GameRegistry.findItem("Natura","NetherBerryBush"), 14, 64);
			SieveRegistry.register(GameRegistry.findBlock("Natura", "soil.tainted"), 0, GameRegistry.findItem("Natura","NetherBerryBush"), 15, 64);
			
		}
	}

}
