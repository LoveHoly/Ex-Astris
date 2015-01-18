package ExAstris.Item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.items.ItemStone;
import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemChiselStones extends ItemStone {
	
	public IIcon[] icons = new IIcon[2];
	
	public ItemChiselStones()
	{
		super();
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.CHISEL_STONE_KEY+"." + item.getItemDamage();
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.CHISEL_STONE_KEY;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List subItems)
	{
		for (int i = 0; i < 2; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
			icons[0] = register.registerIcon(ModData.TEXTURE_LOCATION+":StoneMarble");
			icons[1] = register.registerIcon(ModData.TEXTURE_LOCATION+":StoneLimestone");

	}
	
	@Override
	public IIcon getIconFromDamage(int meta)
	{
		return icons[meta];
	}

}
