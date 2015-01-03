package ExAstris.Block;

import ExAstris.Block.TileEntity.TileEntityHammerAutomatic;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
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

}
