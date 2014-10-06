package ExAstris.Block.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;

public class ItemBlockQStronglyCompressedStone extends  ItemBlock{
	public ItemBlockQStronglyCompressedStone(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + BlockData.STRONGLY_COMPRESSED_STONE_UNLOCALIZED_NAME + "3";
	}
	
	@Override
	public int getMetadata (int meta)
    {
        return meta;
    }
}
