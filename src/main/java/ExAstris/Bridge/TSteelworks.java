package ExAstris.Bridge;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.fluids.FluidStack;
import ExAstris.Data.ModData;
import ExAstris.Data.MoltenData;
import tconstruct.smeltery.TinkerSmeltery;
import tsteelworks.lib.registry.AdvancedSmelting;


public class TSteelworks {
	public static void Initialize()
	{
		if(ModData.allowSteelworksMelting)
		{
			addMeltingRecipe();
		}
	}
	public static void addMeltingRecipe()
	{
		if(Loader.isModLoaded("TConstruct") && ModData.allowAddTConstructNetherOre)
		{
			AdvancedSmelting.addMelting(GameRegistry.findBlock("exastris", "CobaltOreBlock"), 2, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostHighoven), true);
			AdvancedSmelting.addMelting(GameRegistry.findBlock("exastris", "ArditeOreBlock"), 2, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostHighoven), true);
			//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "CobaltOreBlock"), 2), true, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostHighoven), 650);
			//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "ArditeOreBlock"), 2), true, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostHighoven), 650);
		}
		
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "iron_dust"),0, 600, new FluidStack(TinkerSmeltery.moltenIronFluid, MoltenData.ingotCostHighoven), true);
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "gold_dust"),0, 400, new FluidStack(TinkerSmeltery.moltenGoldFluid, MoltenData.ingotCostHighoven), true);
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "copper_dust"),0, 550, new FluidStack(TinkerSmeltery.moltenCopperFluid, MoltenData.ingotCostHighoven), true);
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "tin_dust"),0, 400, new FluidStack(TinkerSmeltery.moltenTinFluid, MoltenData.ingotCostHighoven), true);
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "silver_dust"),0, 400, new FluidStack(TinkerSmeltery.moltenSilverFluid, MoltenData.ingotCostHighoven), true);
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "lead_dust"),0, 400, new FluidStack(TinkerSmeltery.moltenLeadFluid, MoltenData.ingotCostHighoven), true);
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "nickel_dust"),0, 400, new FluidStack(TinkerSmeltery.moltenNickelFluid, MoltenData.ingotCostHighoven), true);
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "platinum_dust"),0, 400, new FluidStack(TinkerSmeltery.moltenShinyFluid, MoltenData.ingotCostHighoven), true);
		AdvancedSmelting.addMelting(GameRegistry.findBlock("exnihilo", "aluminum_dust"),0, 400, new FluidStack(TinkerSmeltery.moltenAluminumFluid, MoltenData.ingotCostHighoven), true);
		
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "iron_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenIronFluid, MoltenData.ingotCostHighoven), 600);
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "gold_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenGoldFluid, MoltenData.ingotCostHighoven), 400);
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "copper_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenCopperFluid, MoltenData.ingotCostHighoven), 550);
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "tin_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenTinFluid, MoltenData.ingotCostHighoven), 400);
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "silver_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenSilverFluid, MoltenData.ingotCostHighoven), 400);
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "lead_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenLeadFluid, MoltenData.ingotCostHighoven), 400);
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "nickel_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenNickelFluid, MoltenData.ingotCostHighoven), 400);
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "platinum_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenShinyFluid, MoltenData.ingotCostHighoven), 400);
		//ISmeltingRegistry.INSTANCE.addMeltable(new ItemStack(GameRegistry.findBlock("exastris", "aluminum_dust"), 0), true, new FluidStack(TinkerSmeltery.moltenAluminumFluid, MoltenData.ingotCostHighoven), 400);
		
	}
}
