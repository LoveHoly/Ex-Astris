package ExAstris.Bridge;

import java.lang.reflect.Method;

import skyboy.core.fluid.LiquidRegistry;
import tconstruct.smeltery.TinkerSmeltery;
import thermalfoundation.block.TFBlocks;
import thermalfoundation.fluid.TFFluids;
import thermalfoundation.item.TFItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.compatibility.MineFactoryReloaded;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ThermalExpansion {
	public static void Initialize()
	{
		if (Loader.isModLoaded("Forestry") && Loader.isModLoaded("exnihilo"))
		{
			addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(Blocks.leaves,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,1),null,0,false);
			addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(Blocks.grass,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,2),null,0,false);
			addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(Blocks.sand,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,3),null,0,false);
			addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(Blocks.vine,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,4),null,0,false);
			addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(Items.ender_pearl,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,5),null,0,false);
			addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(Blocks.ice,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,6),null,0,false);
			addSmelterRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(Blocks.mycelium,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,7),null,0,false);
		}
		if (Loader.isModLoaded("ExtraBees") && Loader.isModLoaded("exnihilo"))
		{
			addTransposerRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,0),new FluidStack(FluidRegistry.WATER, 8000),false);
			addTransposerRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,1),new FluidStack(TinkerSmeltery.moltenStoneFluid, 8000),false);
			addTransposerRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,2),new FluidStack(TFFluids.fluidRedstone, 8000),false);
			addTransposerRecipe(10000, new ItemStack(GameRegistry.findBlock("exnihilo", "bee_trap_treated")),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,3),new FluidStack(LiquidRegistry.getLiquid("milk"), 8000),false);
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addSmelterRecipe(int Energy, ItemStack PrimaryInput, ItemStack SecondaryInput, ItemStack PrimaryOutput,ItemStack SecondaryOutput, int SecondaryChance,boolean Overwrite)
	{
		Class smelter = null;
		Method addRecipe = null;
		
		Object[] parameters ={(Object)Energy, (Object)PrimaryInput, (Object)SecondaryInput, (Object)PrimaryOutput,(Object)SecondaryOutput,(Object)SecondaryChance, (Object)Overwrite};
		try {
			smelter = Class.forName("thermalexpansion.util.crafting.SmelterManager");

			if (smelter != null)
			{	
				addRecipe = smelter.getDeclaredMethod("addRecipe", int.class, ItemStack.class, ItemStack.class, ItemStack.class,ItemStack.class,int.class, boolean.class);
				addRecipe.setAccessible(true);
			}

			if (addRecipe != null)
			{
				addRecipe.invoke(null, parameters);
			}
		}
		catch (Exception ex){System.out.println("Ex Astris: Failed to add Smelter recipes, " + ex.getMessage());}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addTransposerRecipe(int Energy, ItemStack InputItem, ItemStack Output, FluidStack InputFluid, boolean Overwrite)
	{
		Class transposer = null;
		Method addRecipe = null;
		
		Object[] parameters ={(Object)Energy, (Object)InputItem, (Object)Output, (Object)InputFluid, (Object)Overwrite};
		try {
			transposer = Class.forName("thermalexpansion.util.crafting.TransposerManager");

			if (transposer != null)
			{	
				addRecipe = transposer.getDeclaredMethod("addTEFillRecipe", int.class, ItemStack.class, ItemStack.class, FluidStack.class, boolean.class);
				addRecipe.setAccessible(true);
			}

			if (addRecipe != null)
			{
				addRecipe.invoke(null, parameters);
			}
		}
		catch (Exception ex){System.out.println("Ex Astris: Failed to add Transposer recipes, " + ex.getMessage());}
	}
}
