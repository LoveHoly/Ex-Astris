package ExAstris.Bridge;

import ExAstris.Data.ModData;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.SieveRegistry;

public class Botania {
	
	public static void init()
	{
		if (ModData.allowBotaniaFertilizer)
			SieveRegistry.register(Blocks.grass, GameRegistry.findItem("Botania", "fertilizer"), 0, 4);
	}

}
