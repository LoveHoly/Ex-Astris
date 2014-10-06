package ExAstris.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ExAstris.Block.TileEntity.TileEntityStronglyCompressedStone;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockQStronglyCompressedStone extends BlockContainer {
	private IIcon icon;
	public BlockQStronglyCompressedStone() {
		super(Material.iron);
		setHardness(50.0f);
		setHarvestLevel("pickaxe", 3);
		setResistance(6000.0f);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		
		GameRegistry.registerTileEntity(TileEntityStronglyCompressedStone.class, this.getUnlocalizedName());
		
	}
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icon =register.registerIcon(ModData.ID+":scstone3");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return icon;
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + BlockData.STRONGLY_COMPRESSED_STONE_UNLOCALIZED_NAME + "3";
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityStronglyCompressedStone();
	}
	
	@Override
	public boolean hasTileEntity()
	{
		return true;
	}
}
