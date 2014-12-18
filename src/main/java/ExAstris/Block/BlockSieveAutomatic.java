package ExAstris.Block;

import java.util.List;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.registries.SieveRegistry;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic.SieveMode;
import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSieveAutomatic extends BlockContainer{
	public static IIcon meshIcon;

	public BlockSieveAutomatic() {
		super(Material.iron);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		setHardness(2.0f);

		setBlockName(ModData.ID + "." + BlockData.SIEVE_AUTOMATIC_KEY);
		GameRegistry.registerTileEntity(TileEntitySieveAutomatic.class, ModData.ID + "." + BlockData.SIEVE_AUTOMATIC_KEY);
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = Blocks.iron_block.getIcon(0,0);
		meshIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":" + "IconSieveMesh");
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		subItems.add(new ItemStack(item, 1, 0));
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
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean hasTileEntity()
	{
		return true;
	}

	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySieveAutomatic();
	}


	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (player.getHeldItem()!= null)
		{
			if (player.getHeldItem().getItem() == Items.stick)
			{
				TileEntitySieveAutomatic te = (TileEntitySieveAutomatic) world.getTileEntity(x, y, z);
				te.changeSpeedLevel(0.001f);
				return true;
			}
		}
		player.openGui(ExAstris.ExAstris.instance, 0, world, x, y, z);

		return true;
	}

	private boolean isHuman(EntityPlayer player)
	{
		boolean isHuman = (player instanceof EntityPlayerMP);

		if (player.toString().contains("CoFH"))
		{
			isHuman = false;
		}

		return isHuman;
	}

	private void removeCurrentItem(EntityPlayer player)
	{
		ItemStack item = player.getCurrentEquippedItem();

		if (!player.capabilities.isCreativeMode)
		{
			item.stackSize -= 1;
			if (item.stackSize == 0)
			{
				item = null;
			}
		}

	}
}
