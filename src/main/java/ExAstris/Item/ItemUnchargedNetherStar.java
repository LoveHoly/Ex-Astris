package ExAstris.Item;

import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@SuppressWarnings("unused")
public class ItemUnchargedNetherStar extends Item{
	public ItemUnchargedNetherStar() {
		super();
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.UNCHARGED_NETHERSTAR_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.UNCHARGED_NETHERSTAR_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":ItemUnchargedNetherStar");
	}
}
