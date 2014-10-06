package ExAstris.Slot;

import exnihilo.registries.SieveRegistry;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSieveAutomatic  extends Slot{

	public SlotSieveAutomatic(IInventory p_i1824_1_, int p_i1824_2_,
			int p_i1824_3_, int p_i1824_4_) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isItemValid(ItemStack itemstack) {
//		if(itemstac)
		if(SieveRegistry.Contains(Block.getBlockFromItem(itemstack.getItem()),itemstack.getItemDamage()))
		{
			return true;
		}
		return false;
	}

}
