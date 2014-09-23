package ExAstris.Block.ItemBlock;

import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends  ItemBlock
{

	public ItemBlockOre(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID+".block." + this.getUnlocalizedName() + ModData.oreType[item.getItemDamage()];
	}
	
	@Override
	public int getMetadata (int meta)
    {
        return meta;
    }
}