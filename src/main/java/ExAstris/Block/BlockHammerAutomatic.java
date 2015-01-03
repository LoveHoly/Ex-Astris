package ExAstris.Block;

import ExAstris.Block.TileEntity.TileEntityHammerAutomatic;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHammerAutomatic extends BlockContainer {
	
	public BlockHammerAutomatic()
	{
		super(Material.iron);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		setHardness(2.0f);

		setBlockName(ModData.ID + "." + BlockData.HAMMER_AUTOMATIC_KEY);
		GameRegistry.registerTileEntity(TileEntityHammerAutomatic.class, ModData.ID + "." + BlockData.HAMMER_AUTOMATIC_KEY);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) 
	{
		return new TileEntityHammerAutomatic();
	}
	
	@Override
	public boolean hasTileEntity()
	{
		return true;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		player.openGui(ExAstris.ExAstris.instance, 1, world, x, y, z);
		return true;
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + BlockData.HAMMER_AUTOMATIC_UNLOCALIZED_NAME;
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

}
