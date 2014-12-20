package ExAstris.Bridge;

import ExAstris.Data.ModData;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;
public class MineFactoryReloaded {
	public static void Initialize()
	{
		addColorRegistry();
		if(ModData.allowMFRCompost)
		{
			addCompostRegistry();
		}
	}
	public static void addColorRegistry()
	{
		ColorRegistry.register("rubberwood", new Color("29410A"));
	}
	public static void addCompostRegistry()
	{
		
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "tile.mfr.rubberwood.sapling"), 0, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "tile.mfr.rubberwood.leaves"), 0, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "tile.mfr.rubberwood.leaves"), 1, 0.125F, ColorRegistry.color("rubberwood"));
		
	}
}
