package ExAstris.Block;

import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockRotaryApiary extends Block {
	public static IIcon topIcon;
	public static IIcon bottomIcon;
	public static IIcon sideIcon1;
	public static IIcon sideIcon2;
	
	public BlockRotaryApiary() {
		
		super(Material.iron);
		setHardness(0.8f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + BlockData.ROTARY_APIARY_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		topIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":RotaryApiary1");
		bottomIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":RotaryApiary0");
		sideIcon1 = register.registerIcon(ModData.TEXTURE_LOCATION + ":RotaryApiary2");
		sideIcon2 = register.registerIcon(ModData.TEXTURE_LOCATION + ":RotaryApiary3");
		blockIcon = sideIcon1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
    {
		switch(side)
		{
		case 0:
			return bottomIcon;
		case 1:
			return topIcon;
		case 2:
			return sideIcon1;
		}
		return sideIcon2;
    }
}
