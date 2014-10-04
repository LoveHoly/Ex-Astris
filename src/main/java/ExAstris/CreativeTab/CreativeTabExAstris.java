package ExAstris.CreativeTab;

import exnihilo.ENItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabExAstris extends CreativeTabs{

	public CreativeTabExAstris(int id) {
		super(id, "ExAstrisTab");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return ENItems.Crook;
	}

}
