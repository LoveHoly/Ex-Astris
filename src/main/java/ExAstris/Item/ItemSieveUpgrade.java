package ExAstris.Item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSieveUpgrade extends Item {
	
	public ItemSieveUpgrade()
	{
		super();
		this.setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.SIEVE_UPGRADE_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.SIEVE_UPGRADE_NAME + "." + item.getItemDamage();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List subItems)
	{
		for (int i = 0; i < 2; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}

}
