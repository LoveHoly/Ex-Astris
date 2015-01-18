package ExAstris.Bridge;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.SieveRegistry;

public class Botania {
	
	public static void init()
	{
		SieveRegistry.register(Blocks.grass, GameRegistry.findItem("Botania", "fertilizer"), 0, 4);
	}

}
