package ExAstris.Block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import ExAstris.Block.TileEntity.TileEntityHammerAutomatic;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockHammerAutomatic extends BlockContainer {
	
	public static int renderId;
	
	private double minYTop = 13d/16d;
	private double maxYBot = 3d/16d;
	
    public BlockHammerAutomatic()
	{
		super(Material.iron);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		setHardness(2.0f);

		setBlockName(ModData.ID + "." + BlockData.HAMMER_AUTOMATIC_KEY);
		setBlockTextureName(ModData.ID + ":HammerBase");
		GameRegistry.registerTileEntity(TileEntityHammerAutomatic.class, ModData.ID + "." + BlockData.HAMMER_AUTOMATIC_KEY);
	}
    
    @Override
    public String getUnlocalizedName()
	{
		return ModData.ID + "." + BlockData.HAMMER_AUTOMATIC_UNLOCALIZED_NAME;
	}
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	{
		TileEntity tile = world.getTileEntity(x, y, z);

		ISidedInventory inv = (ISidedInventory) tile;
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if(inv.getStackInSlot(i) != null){
				EntityItem entityitem = new EntityItem(world, x, y, z, inv.getStackInSlot(i));
				world.spawnEntityInWorld(entityitem);
			}
		}
		super.breakBlock(world, x,  y,  z,  block,  meta);
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity colliding)
	{
	    AxisAlignedBB up = getUpperBox(x, y, z);
	    AxisAlignedBB down = getLowerBox(x, y, z);
	    
	    if (mask.intersectsWith(up))
	    {
	        list.add(up);
	    }
	    
	    if (mask.intersectsWith(down))
	    {
	        list.add(down);
	    }
	}
	   
    private AxisAlignedBB getUpperBox(int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox(x, y + minYTop, z, x + 1, y + 1, z + 1);
    }
    
	private AxisAlignedBB getLowerBox(int x, int y, int z)
	{
        return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + maxYBot, z + 1);
	}

	@Override
	public int getRenderType()
	{
		return renderId;
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
