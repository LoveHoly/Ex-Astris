package ExAstris.Block.ItemBlock;

import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEndCake extends ItemBlock {
	public ItemBlockEndCake(Block block) {
		super(block);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ModData.ID + "." + BlockData.ENDCAKE_UNLOCALIZED_NAME;
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
