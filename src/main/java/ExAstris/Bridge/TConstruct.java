package ExAstris.Bridge;

import ExAstris.Data.MoltenData;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.helpers.Color;
import static net.minecraftforge.fluids.FluidRegistry.getFluid;

public class TConstruct {
	public static void Initialize()
	{
		OreRegistry.createNetherOre("cobalt",new Color("2376dd"), 100, GameRegistry.findItem("TConstruct", "materials:3"));
		OreRegistry.createNetherOre("ardite",new Color("f48a00"), 100, GameRegistry.findItem("TConstruct", "materials:4"));
		addSmeltery();
	}
	public static void addSmeltery()
	{

		Smeltery.addMelting(GameRegistry.findBlock("exastris", "cobalt_dust"), 0, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
		Smeltery.addMelting(GameRegistry.findBlock("exastris", "ardite_dust"), 0, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));		

		Smeltery.addMelting(GameRegistry.findBlock("exastris", "cobalt_sand"), 0, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
		Smeltery.addMelting(GameRegistry.findBlock("exastris", "ardite_sand"), 0, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));	
		
		Smeltery.addMelting(GameRegistry.findBlock("exastris", "nether_cobalt_gravel"), 0, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
		Smeltery.addMelting(GameRegistry.findBlock("exastris", "nether_ardite_gravel"), 0, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));	

	}
}
