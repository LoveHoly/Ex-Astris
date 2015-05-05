package ExAstris.Block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockStronglyCompressedStone  extends Block  {
	private IIcon[] icon;
	public BlockStronglyCompressedStone() {
		super(Material.iron);
		setHardness(50.0f);
		setHarvestLevel("pickaxe", 3);
		setResistance(6000.0f);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);	
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icon = new IIcon[3];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon(ModData.ID+":scstone" + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return icon[meta];
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems)
	{
		for (int i = 0; i < 3; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public int damageDropped (int meta)
	{
		return meta;
	}

}
