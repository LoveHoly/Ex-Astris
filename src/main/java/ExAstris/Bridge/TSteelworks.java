package ExAstris.Bridge;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import ExAstris.ExAstrisBlock;
import ExAstris.Data.ModData;
import ExAstris.Data.MoltenData;
import tconstruct.smeltery.TinkerSmeltery;
import toops.tsteelworks.api.PluginFactory;
import toops.tsteelworks.api.highoven.ISmeltingRegistry;


public class TSteelworks {

	private static ISmeltingRegistry Instance;
	public static void Initialize()
	{
		Instance = (ISmeltingRegistry) PluginFactory.getInstance(ISmeltingRegistry.class);
		if(ModData.allowSteelworksMelting)
		{
			addMeltingRecipe();
		}
	}
	public static void addMeltingRecipe()
	{
		if(Loader.isModLoaded("TConstruct") && ModData.allowAddTConstructNetherOre)
		{
			Instance.addMeltable(new ItemStack(ExAstrisBlock.cobaltOreBlock, 1, 2), true, new FluidStack(TinkerSmeltery.moltenCobaltFluid, MoltenData.ingotCostHighoven), 650);
			Instance.addMeltable(new ItemStack(ExAstrisBlock.arditeOreBlock, 1, 2), true, new FluidStack(TinkerSmeltery.moltenArditeFluid, MoltenData.ingotCostHighoven), 650);
		}

		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "iron_dust"), 0), new FluidStack(TinkerSmeltery.moltenIronFluid, MoltenData.ingotCostHighoven), 600);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "gold_dust"), 0), new FluidStack(TinkerSmeltery.moltenGoldFluid, MoltenData.ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "copper_dust"), 0), new FluidStack(TinkerSmeltery.moltenCopperFluid, MoltenData.ingotCostHighoven), 550);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "tin_dust"), 0), new FluidStack(TinkerSmeltery.moltenTinFluid, MoltenData.ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "silver_dust"), 0), new FluidStack(TinkerSmeltery.moltenSilverFluid, MoltenData.ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "lead_dust"), 0), new FluidStack(TinkerSmeltery.moltenLeadFluid, MoltenData.ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "nickel_dust"), 0), new FluidStack(TinkerSmeltery.moltenNickelFluid, MoltenData.ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "platinum_dust"), 0), new FluidStack(TinkerSmeltery.moltenShinyFluid, MoltenData.ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "aluminum_dust"), 0), new FluidStack(TinkerSmeltery.moltenAluminumFluid, MoltenData.ingotCostHighoven), 400);

	}

	public static void addMeltableOre(ItemStack stack, FluidStack output, int temperature)
	{
		if (stack != null && output != null && stack.getItem() != null && output.getFluid() != null) //More null checks than you can poke a stick at
		{
			Instance.addMeltable(stack, true, output, temperature);
		}
	}
}
