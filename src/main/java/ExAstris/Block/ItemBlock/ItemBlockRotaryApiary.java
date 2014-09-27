package ExAstris.Block.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;

public class ItemBlockRotaryApiary extends ItemBlock {
	public ItemBlockRotaryApiary(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.ROTARY_APIARY_UNLOCALIZED_NAME;
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
