package ExAstris.Bridge;

import net.minecraft.init.Blocks;
import ExAstris.Data.ModData;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Color;
public class MineFactoryReloaded {
	public static void Initialize()
	{
		addColorRegistry();
		if(ModData.allowMFRCompost)
		{
			addCompostRegistry();
		}
		if (ModData.allowMFRSeedFromSifting)
		{
			SieveRegistry.register(Blocks.dirt, 0, GameRegistry.findItem("MineFactoryReloaded", "rubberwood.sapling"), 0, 90);
		}
	}
	public static void addColorRegistry()
	{
		ColorRegistry.register("rubberwood", new Color("29410A"));
	}
	public static void addCompostRegistry()
	{
		
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "rubberwood.sapling"), 0, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "rubberwood.sapling"), 1, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "rubberwood.leaves"), 0, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "rubberwood.leaves"), 1, 0.125F, ColorRegistry.color("rubberwood"));
		
	}
}
