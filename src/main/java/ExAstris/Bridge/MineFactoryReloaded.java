package ExAstris.Bridge;

import ExAstris.Data.ModData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.helpers.Color;
import exnihilo.registries.ColorRegistry;
public class MineFactoryReloaded {
	public static void Initialize()
	{
		addColorRegistry();
		if(ModData.ALLOW_MFR_COMPOST)
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
