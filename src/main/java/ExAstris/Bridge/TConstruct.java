package ExAstris.Bridge;

import ExAstris.ExAstrisBlock;
import ExAstris.ExAstrisItem;
import ExAstris.Data.ModData;
import ExAstris.Data.MoltenData;
import ExAstris.Modifier.ModCrooked;
import ExAstris.Modifier.ModHammered;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.registries.HeatRegistry;
import exnihilo.registries.SieveRegistry;

public class TConstruct {
	public static void Initialize()
	{
		addSmeltery();
		if(ModData.allowTConstructHeat)
		{
			addHeatRegistry();
		}
		if(ModData.allowTConstructModifiers)
		{
			addModifiers();
		}
		addHammerRegistry();
		addSieveRegistry();
	}
	public static void addSieveRegistry()
	{
		if(Loader.isModLoaded("TConstruct") && ModData.allowAddTConstructNetherOre)
		{
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.cobaltOreItem, 0, 128);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisItem.arditeOreItem, 0, 128);
		}
	}
	public static void addHammerRegistry()
	{
		if(Loader.isModLoaded("TConstruct") && ModData.allowAddTConstructNetherOre)
		{
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.cobaltOreBlock, ExAstrisItem.cobaltOreItem );		
			RegistryFactory.HammerOreRegistryFactory(ExAstrisBlock.arditeOreBlock, ExAstrisItem.arditeOreItem );	
		}
		
	}
	public static void addSmeltery()
	{
		if(ModData.allowAddTConstructNetherOre)
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
		ModifyBuilder.registerModifier(new ModCrooked(new ItemStack[] { new ItemStack(GameRegistry.findItem("exnihilo", "crook_bone"), 1, 0) }, 60));
		TConstructClientRegistry.addEffectRenderMapping(60, "exastris", "crook", true);
		
		ModifyBuilder.registerModifier(new ModHammered(new ItemStack[] { new ItemStack(GameRegistry.findItem("exnihilo", "hammer_diamond"), 1, 0) }, 61));
		TConstructClientRegistry.addEffectRenderMapping(61, "exastris", "hammer", true);
		
		TConstructRegistry.registerActiveToolMod(new TConstructModifier());
	}
}
