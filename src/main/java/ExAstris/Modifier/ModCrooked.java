package ExAstris.Modifier;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;

public class ModCrooked extends ModBoolean {

	static String name = "Crooked";
	static String color = "\u00a77";
	static String tooltip = "Crooked";
	
	public ModCrooked(ItemStack[] items, int effect) {
		super(items, effect, name, color, tooltip);
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		ToolCore toolitem = (ToolCore) tool.getItem();
		if (!validType(toolitem)) return false;
		
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		if (!tags.getBoolean("Lava") && !tags.hasKey("Lapis") && !tags.hasKey("Silk Touch") && !tags.hasKey("Hammered"))
		{
		    return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key);
		}
		
		return false;
	}
	
	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		tags.setBoolean(name, true);
		
		int modifiers = tags.getInteger("Modifiers");
		modifiers -= 1;
		tags.setInteger("Modifiers", modifiers);

		int attack = tags.getInteger("Attack");
		attack = 0;
		tags.setInteger("Attack", attack);

		int miningSpeed = tags.getInteger("MiningSpeed");
		miningSpeed -= 300;
		if (miningSpeed < 0)
		    miningSpeed = 0;
		tags.setInteger("MiningSpeed", miningSpeed);

		if (tags.hasKey("MiningSpeed2"))
		{
		    int miningSpeed2 = tags.getInteger("MiningSpeed2");
		    miningSpeed2 -= 300;
		    if (miningSpeed2 < 0)
				miningSpeed2 = 0;
		    tags.setInteger("MiningSpeed2", miningSpeed2);
		}
		
		float knockback = tags.getFloat("Knockback");

        knockback *= 1.5F;

		addToolTip(tool, color + tooltip, color + key);
	}
	
	public boolean validType (ToolCore tool)
	{
		if(tool.getToolName().equals("Mattock") ||
				tool.getToolName().equals("Hatchet") ||
				tool.getToolName().equals("Broadsword") ||
				tool.getToolName().equals("Longsword") ||
				tool.getToolName().equals("Rapier") ||
				tool.getToolName().equals("Cutlass") ||
				tool.getToolName().equals("Cleaver") ||
				tool.getToolName().equals("Lumber Axe") ||
				tool.getToolName().equals("Scythe") )
		{
			return true;
		}
		
		return false;
	}

}
