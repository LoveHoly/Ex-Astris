package ExAstris.Bridge;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.helpers.Color;

public class DraconicEvolution {
	
	public static void addSiftingRegistry()
	{
		OreRegistry.createEnderOre("draconiumDust", new Color("BF3FBF"), 25, GameRegistry.findItem("DraconicEvolution","draconiumDust"), true);
		HammerRegistry.register(GameRegistry.findBlock("exastris", "draconiumdust_dust"), 0, GameRegistry.findItem("DraconicEvolution","draconiumDust"), 0, 0.8f, 0);
		HammerRegistry.register(GameRegistry.findBlock("exastris", "draconiumdust_dust"), 0, GameRegistry.findItem("DraconicEvolution","draconiumDust"), 0, 0.1f, 0.1f);
	}

}
