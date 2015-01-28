package ExAstris.Util;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import exnihilo.registries.HammerRegistry;

public class HammerUtils {
	
	private static HashMap<ItemInfo, Boolean> registryCache = new HashMap<ItemInfo, Boolean>();
	
	public static boolean registered(ItemStack item)
	{
		Boolean allowed = registryCache.get(new ItemInfo(item));
		if (allowed == null) 
		{
			if (HammerRegistry.registered(Block.getBlockFromItem(item.getItem()), item.getItemDamage())) 
			{
				registryCache.put(new ItemInfo(item), true);
				return true;
			} 
			else 
			{
				registryCache.put(new ItemInfo(item), false);
			}
		} 
		else if (allowed) 
		{
			return true;
		}
		return false;
	}
	
	public static boolean registered(Block block)
	{
		return registered(new ItemStack(block, 1, 0));
	}
}
