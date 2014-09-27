package ExAstris.Block.ItemBlock;

import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStronglyCompressedStone extends  ItemBlock{
	public ItemBlockStronglyCompressedStone(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + BlockData.STRONGLY_COMPRESSED_STONE_UNLOCALIZED_NAME + item.getItemDamage();
	}
	
	@Override
	public int getMetadata (int meta)
    {
        return meta;
    }
}
