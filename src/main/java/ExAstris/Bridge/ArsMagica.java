package ExAstris.Bridge;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.registries.SieveRegistry;

public class ArsMagica {
	public static void init()
	{
		addSieveRegistry();
	}
	public static void addSieveRegistry()
	{
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("arsmagica2", "itemOre"), 0, 128);
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("arsmagica2", "itemOre"), 4, 128);
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("arsmagica2", "itemOre"), 5, 128);
		SieveRegistry.register(ENBlocks.NetherGravel, 0, GameRegistry.findItem("arsmagica2", "itemOre"), 6, 128);
	}
}
