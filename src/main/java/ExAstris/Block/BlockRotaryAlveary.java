package ExAstris.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ExAstris.Block.TileEntity.TileEntityRotaryAlveary;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRotaryAlveary  extends BlockContainer{
	public static IIcon topIcon;
	public static IIcon sideIcon;
	public BlockRotaryAlveary() {
		super(Material.iron);
		setHardness(4.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		
		GameRegistry.registerTileEntity(TileEntityRotaryAlveary.class,this.getUnlocalizedName());
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + BlockData.ROTARY_ALVEARY_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		topIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":RotaryAlvearyBottom");
		sideIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":RotaryAlvearyPlain");
		blockIcon = sideIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
    {
		if (side == 0 || side == 1)
		{
			return topIcon;
		}
		return sideIcon;
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityRotaryAlveary(p_149915_2_);
	}
}
