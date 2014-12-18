package ExAstris.Bridge;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import ExAstris.ExAstrisBlock;
import ExAstris.Data.ModData;
import ExAstris.Data.MoltenData;
//import tconstruct.smeltery.TinkerSmeltery;
//import tsteelworks.lib.registry.AdvancedSmelting;


public class TSteelworks {
	public static void Initialize()
	{
		if(ModData.ALLOW_TSTEELWORKS_MELTING)
		{
			addMeltingRecipe();
		}
	}
	public static void addMeltingRecipe()
	{
	/*	if(Loader.isModLoaded("TConstruct") && ModData.ALLOW_ADD_TCONSTRUCT_NETHERORE)
		{
			AdvancedSmelting.addMelting(GameRegistry.findBlock("exastris", "CobaltOreBlock"),2,650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostHighoven));
			AdvancedSmelting.addMelting(GameRegistry.findBlock("exastris", "ArditeOreBlock"),2,650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostHighoven));
		}
		
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "iron_dust"),0,600, new FluidStack(TinkerSmeltery.moltenIronFluid, MoltenData.ingotCostHighoven));
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "gold_dust"),0,400, new FluidStack(TinkerSmeltery.moltenGoldFluid, MoltenData.ingotCostHighoven));
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "copper_dust"),0,550, new FluidStack(TinkerSmeltery.moltenCopperFluid, MoltenData.ingotCostHighoven));
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "tin_dust"),0,400, new FluidStack(TinkerSmeltery.moltenTinFluid, MoltenData.ingotCostHighoven));
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "silver_dust"),0,400, new FluidStack(TinkerSmeltery.moltenSilverFluid, MoltenData.ingotCostHighoven));
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "lead_dust"),0,400, new FluidStack(TinkerSmeltery.moltenLeadFluid, MoltenData.ingotCostHighoven));
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "nickel_dust"),0,400, new FluidStack(TinkerSmeltery.moltenNickelFluid, MoltenData.ingotCostHighoven));
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "platinum_dust"),0,400, new FluidStack(TinkerSmeltery.moltenShinyFluid, MoltenData.ingotCostHighoven));
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "aluminum_dust"),0,400, new FluidStack(TinkerSmeltery.moltenAluminumFluid, MoltenData.ingotCostHighoven));
		*/
	}
}
