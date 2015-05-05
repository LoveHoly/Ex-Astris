package ExAstris.Bridge;

import com.emoniph.witchery.entity.EntityCovenWitch;

import ExAstris.Data.ModData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import exnihilo.Fluids;
import exnihilo.registries.BarrelRecipeRegistry;
import exnihilo.registries.SieveRegistry;

public class Witchery {
	
	public static void init()
	{
		addSifting();
		if (ModData.witcheryEnableCovenWitch)
			BarrelRecipeRegistry.addMobRecipe(Fluids.fluidWitchWater, new ItemStack(GameRegistry.findItem("witchery", "witchhand")), covenWitchClass(), "portal", null);
	}
	
	private static void addSifting()
	{
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsartichoke"), 0, ModData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedswolfsbane"), 0, ModData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsmandrake"), 0, ModData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsbelladonna"), 0, ModData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedssnowbell"), 0, ModData.witcherySeedsChance);
	}
	
	private static Class covenWitchClass()
	{
		return EntityCovenWitch.class;
	}

}
