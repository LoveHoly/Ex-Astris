package ExAstris.Item;

import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemNugget extends Item {

	public ItemNugget()
	{
		super();
		
	}
	
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.NUGGET_KEY;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.NUGGET_KEY;
	}
	
	
	
	@Override
	public void registerIcons(IIconRegister register)
	{
			this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION+":NuggetElectricalSteel");
	}
	
}
