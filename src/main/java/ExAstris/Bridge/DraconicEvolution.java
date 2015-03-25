package ExAstris.Bridge;

import com.brandon3055.draconicevolution.common.lib.OreDoublingRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.blocks.ores.BlockOre;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.helpers.Color;

public class DraconicEvolution {
	
	public static void init()
	{
		addSiftingRegistry();
		addChestSmeltingDoubling();
	}
	
	public static void addSiftingRegistry()
	{
		OreRegistry.createEnderOre("draconiumDust", new Color("BF3FBF"), 25, GameRegistry.findItem("DraconicEvolution","draconiumDust"), true);
		HammerRegistry.register(GameRegistry.findBlock("exastris", "draconiumdust_dust"), 0, GameRegistry.findItem("DraconicEvolution","draconiumDust"), 0, 0.8f, 0);
		HammerRegistry.register(GameRegistry.findBlock("exastris", "draconiumdust_dust"), 0, GameRegistry.findItem("DraconicEvolution","draconiumDust"), 0, 0.1f, 0.1f);
	}
	
	public static void addChestSmeltingDoubling()
	{
		for (BlockOre b : OreRegistry.gravelTable.values())
			addDraconicDoubling(b);
		for (BlockOre b : OreRegistry.sandTable.values())
			addDraconicDoubling(b);
		for (BlockOre b : OreRegistry.dustTable.values())
			addDraconicDoubling(b);
	}
	
	public static void addDraconicDoubling(Block block)
	{
		// DISABLED FOR NOW
		/*ItemStack furnaceOutput = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block));
		if (furnaceOutput != null)
		{
			furnaceOutput = furnaceOutput.copy();
			furnaceOutput.stackSize*=2;
			OreDoublingRegistry.resultOverrides.put(block.getUnlocalizedName(), furnaceOutput); //This is naughty
		}*/
	}

}
