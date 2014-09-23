package ExAstris.Bridge;

import ExAstris.Data.ModData;
import ExAstris.Data.MoltenData;
import ExAstris.Modifier.ModCrooked;
import ExAstris.Modifier.ModHammered;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.Smeltery;
import tconstruct.library.crafting.ToolBuilder;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.HeatRegistry;

public class TConstruct {
	public static void Initialize()
	{
	/*	if(ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			addNetherOre();
		}*/
		addSmeltery();
		if(ModData.ALLOW_TCONSTRUCT_HEAT_REGISTRY)
		{
			addHeatRegistry();
		}
		if(ModData.ALLOW_TCONSTRUCT_MODIFIERS)
		{
			addModifiers();
		}
	}
	/*public static void addNetherOre()
	{
		OreRegistry.createNetherOre("cobalt", new Color("2376dd"), 100, TConstructRegistry.getItem("ingotCobalt"), false);
		OreRegistry.createNetherOre("ardite",new Color("f48a00"), 100, TConstructRegistry.getItem("ingotArdite"), false);
		
	}*/
	public static void addSmeltery()
	{
		if(ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "CobaltOreBlock"), 0, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "ArditeOreBlock"), 0, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));		

			Smeltery.addMelting(GameRegistry.findBlock("exastris", "CobaltOreBlock"), 1, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "ArditeOreBlock"), 1, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));	
			
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "CobaltOreBlock"), 2, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostSmeltery));
			Smeltery.addMelting(GameRegistry.findBlock("exastris", "ArditeOreBlock"), 2, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostSmeltery));	

		}
		
	}
	public static void addHeatRegistry()
	{
		
		HeatRegistry.register(GameRegistry.findBlock("TConstruct","decoration.stonetorch"), 0.1F);
			

	}
	static void addModifiers()
	{
		ToolBuilder.instance.registerToolMod(new ModCrooked(new ItemStack[] { new ItemStack(GameRegistry.findItem("exnihilo", "crook_bone"), 1, 0) }, 60));
		TConstructClientRegistry.addEffectRenderMapping(60, "exastris", "crook", true);
		
		ToolBuilder.instance.registerToolMod(new ModHammered(new ItemStack[] { new ItemStack(GameRegistry.findItem("exnihilo", "hammer_diamond"), 1, 0) }, 61));
		TConstructClientRegistry.addEffectRenderMapping(61, "exastris", "hammer", true);
		
		TConstructRegistry.registerActiveToolMod(new TConstructModifier());
	}
}
