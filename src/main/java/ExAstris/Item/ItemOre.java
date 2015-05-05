package ExAstris.Item;

import java.util.List;

import ExAstris.Data.ModData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemOre extends Item
{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icon;
	public String Name;
	//private String name = this.getUnlocalizedName().substring(5);
	
	public ItemOre(String name) {
		super();
		setHasSubtypes(true);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		Name = name;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
			return ModData.ID+".item." + this.getUnlocalizedName() + ModData.oreType[item.getItemDamage()];
	}
	
	@Override
	public int getMetadata (int meta)
    {
        return meta;
    }
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		icon = new IIcon[3];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon(ModData.ID+":" + ModData.oreType[i] + "/Item" + this.getUnlocalizedName() + ModData.oreType[i]);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int meta)
	{
		return icon[meta];
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List subItems)
	{
		for (int i = 0; i < 3; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return Name;
	}
}