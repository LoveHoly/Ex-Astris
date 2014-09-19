package ExAstris.Bridge;

import ExAstris.Data.ModData;
import ExAstris.Data.MoltenData;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.helpers.Color;
//import static net.minecraftforge.fluids.FluidRegistry.getFluid;
import exnihilo.registries.HeatRegistry;
public class TConstruct {
	public static void Initialize()
	{
		if(ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			addNetherOre();
		}
		addSmeltery();
		if(ModData.ALLOW_TCONSTRUCT_HEAT_REGISTRY)
		{
			addHeatRegistry();
		}
	}
	public static void addNetherOre()
	{
		
		OreRegistry.createNetherOre("cobalt",new Color("2376dd"), 100, GameRegistry.findItem("TConstruct", "materials:3"));
		OreRegistry.createNetherOre("ardite",new Color("f48a00"), 100, GameRegistry.findItem("TConstruct", "materials:4"));
		
	}
	public static void addSmeltery()
	{
		if(ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "cobalt_dust"), 0, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "ardite_dust"), 0, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));		

			Smeltery.addMelting(GameRegistry.findBlock("exastris", "cobalt_sand"), 0, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "ardite_sand"), 0, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));	
			
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "nether_cobalt_gravel"), 0, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "nether_ardite_gravel"), 0, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));	

		}
		
	}
	public static void addHeatRegistry()
	{
		
		HeatRegistry.register(GameRegistry.findBlock("TConstruct","decoration.stonetorch"), 0.1F);
			

	}
}
