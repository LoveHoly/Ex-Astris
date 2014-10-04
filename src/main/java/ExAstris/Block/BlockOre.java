package ExAstris.Block;

import java.util.List;

import ExAstris.Data.ModData;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOre  extends BlockSand{

	@SideOnly(Side.CLIENT)
	private IIcon[] icon;
	public String Name;
	public BlockOre(String name) {
		super();
		setHardness(0.4F);
		setStepSound(soundTypeSand);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		Name = name;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icon = new IIcon[3];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon(ModData.ID+":" + ModData.oreType[i] + "/Block" + Name + ModData.oreType[i]);
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
	
	
	@Override
	public String getUnlocalizedName()
	{
		return Name;
	}
}
