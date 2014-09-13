package ExAstris.Block.TileEntity;

import java.util.ArrayList;
import java.util.Iterator;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import cofh.lib.util.helpers.ItemHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.particles.ParticleSieve;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.SiftReward;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntitySieveAutomatic extends TileEntity  implements IEnergyHandler, ISidedInventory {
	public EnergyStorage storage = new EnergyStorage(64000);
	private static final int energyPerCycle = 800;
	private static final float MIN_RENDER_CAPACITY = 0.70f;
	private static final float MAX_RENDER_CAPACITY = 0.9f;
	private static final float PROCESSING_INTERVAL = 0.075f;
	private static final int UPDATE_INTERVAL = 20;
	
	protected ItemStack[] inventory;
	
	public Block content;
	public int contentMeta = 0;

	private float volume = 0;
	public SieveMode mode = SieveMode.EMPTY;

	private int timer = 0;
	private boolean update = false;
	private boolean particleMode = false;
	private int timesClicked = 0;

	public enum SieveMode
	{EMPTY(0), FILLED(1);
	private SieveMode(int v){this.value = v;}
	public int value;
	}

	public TileEntitySieveAutomatic()
	{
		mode = SieveMode.EMPTY;
		inventory = new ItemStack[getSizeInventory()];
	}

	public void addSievable(Block block, int blockMeta)
	{
		this.content = block;
		this.contentMeta = blockMeta;

		this.mode = SieveMode.FILLED;

		volume = 1.0f;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void updateEntity()
	{
		if(worldObj.isRemote && particleMode)
		{
			spawnFX(content, contentMeta);
		}

		timer++;
		if (timer >= UPDATE_INTERVAL)
		{
			timesClicked = 0;
			
			timer = 0;
			disableParticles();

			if (update)
			{
				update();
			}
		}
		
		
		
		//addd
		if(storage.getEnergyStored() > energyPerCycle)
		{
			if (mode == SieveMode.EMPTY && inventory[0] != null)
			{
				ItemStack held = inventory[0];
				if (SieveRegistry.Contains(Block.getBlockFromItem(held.getItem()), held.getItemDamage()))
				{
					addSievable(Block.getBlockFromItem(held.getItem()), held.getItemDamage());
					decrStackSize(0,1);
					storage.extractEnergy(energyPerCycle, false);
				}
			}else if(mode != SieveMode.EMPTY)
			{
				ProcessContents(false);
			}
		}
		
		//adddend
	}

	public void ProcessContents(boolean creative)
	{	
		if (creative)
		{
			volume = 0;
		}else
		{
			timesClicked++;
			if (timesClicked <= 6)
			{
				volume -= PROCESSING_INTERVAL;
				storage.extractEnergy(energyPerCycle, false);
			}
		}

		if (volume <= 0)
		{
			mode = SieveMode.EMPTY;
			//give rewards!
			if (!worldObj.isRemote)
			{
				ArrayList<SiftReward> rewards = SieveRegistry.getRewards(content, contentMeta);
				if (rewards.size() > 0)
				{
					Iterator<SiftReward> it = rewards.iterator();
					while(it.hasNext())
					{
						SiftReward reward = it.next();
						
						int size = getSizeInventory();
						int inventoryIndex = 0;
						
						if (worldObj.rand.nextInt(reward.rarity) == 0)
						{
							for(int i = 1; i < size; i++)
							{
								if(inventory[i] == null)
								{
									inventoryIndex=i;
									break;
								}else{
									if( ItemHelper.itemsEqualWithMetadata(inventory[i],new ItemStack(reward.item, 1, reward.meta)) )
									{
										inventoryIndex=i;
										break;
									}
								}
							}
							
							
							if(inventoryIndex != 0)
							{
								if(inventory[inventoryIndex] != null) inventory[inventoryIndex] = new ItemStack(reward.item, (inventory[inventoryIndex].stackSize + 1), reward.meta);
								else inventory[inventoryIndex] = new ItemStack(reward.item, 1, reward.meta);
							}
							else
							{
								
									EntityItem entityitem = new EntityItem(worldObj, (double)xCoord + 0.5D, (double)yCoord + 1.5D, (double)zCoord + 0.5D, new ItemStack(reward.item, 1, reward.meta));

									double f3 = 0.05F;
									entityitem.motionX = worldObj.rand.nextGaussian() * f3;
									entityitem.motionY = (0.2d);
									entityitem.motionZ = worldObj.rand.nextGaussian() * f3;

									worldObj.spawnEntityInWorld(entityitem);
									
									//System.out.println("Spawning: " + reward.id);
								
							}
						}
						
						
					}
				}
			}
		}
		else
		{
			particleMode = true;
		}

		update = true;
	}

	@SideOnly(Side.CLIENT)
	private void spawnFX(Block block, int blockMeta)
	{
		if (block != null)
		{
			IIcon icon = block.getIcon(0, blockMeta);

			for (int x = 0; x < 4; x++)
			{	
				ParticleSieve dust = new ParticleSieve(worldObj, 
						xCoord + 0.8d * worldObj.rand.nextFloat() + 0.15d, 
						yCoord + 0.69d, 
						zCoord + 0.8d * worldObj.rand.nextFloat() + 0.15d, 
						0.0d, 0.0d, 0.0d, icon);
				
				Minecraft.getMinecraft().effectRenderer.addEffect(dust);
			}
		}
	}
	
	public float getVolume() {
		return volume;
	}

	public float getAdjustedVolume()
	{
		float capacity = MAX_RENDER_CAPACITY - MIN_RENDER_CAPACITY;
		float adjusted = volume * capacity;		
		adjusted += MIN_RENDER_CAPACITY;
		return adjusted;
	}

	private void update()
	{
		update = false;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	private void disableParticles()
	{
		particleMode = false;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		switch (compound.getInteger("mode"))
		{
		case 0:
			mode = SieveMode.EMPTY;
			break;

		case 1:
			mode = SieveMode.FILLED;
			break;
		}
		if(!compound.getString("content").equals("")) {
			content = (Block)Block.blockRegistry.getObject(compound.getString("content"));
		}else{
			content = null;
		}
		contentMeta = compound.getInteger("contentMeta");
		volume = compound.getFloat("volume");
		particleMode = compound.getBoolean("particles");
		storage.readFromNBT(compound);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("mode", mode.value);
		//Should change later to not be dependent on DV, as Forge can now change them willy-nilly at startup
		if(content == null) {
			compound.setString("content", "");
		}else{
			compound.setString("content", Block.blockRegistry.getNameForObject(content));
		}
		compound.setInteger("contentMeta", contentMeta);
		compound.setFloat("volume", volume);
		compound.setBoolean("particles", particleMode);
		storage.writeToNBT(compound);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.func_148857_g();
		this.readFromNBT(tag);
	}
	// Thermal Expansion !!!

	/* IEnergyHandler */
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {

		return true;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

		return storage.receiveEnergy(maxReceive, simulate);
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		return storage.extractEnergy(maxExtract, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {

		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {

		return storage.getMaxEnergyStored();
	}

	//ISidedInventory!
	@Override
	public int getSizeInventory() {
		return 31;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(inventory[slot] != null)
		{
			if(inventory[slot].stackSize <= amount)
			{
				ItemStack itemstack = inventory[slot];
				inventory[slot] = null;
				//onFactoryInventoryChanged();
				return itemstack;
			}
			ItemStack itemstack1 = inventory[slot].splitStack(amount);
			if(inventory[slot].stackSize == 0)
			{
				inventory[slot] = null;
			}
			return itemstack1;
		}
		else
		{
			//onFactoryInventoryChanged();
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		// ADD FROM PIPE
		inventory[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit())
		{
				stack.stackSize = getInventoryStackLimit();
		}
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		//SieveRegistry.Contains(Block.getBlockFromItem(item.getItem()),item.getItemDamage()) && 
		if (SieveRegistry.Contains(Block.getBlockFromItem(item.getItem()),item.getItemDamage()) && slot == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		// TODO Auto-generated method stub
		int size = getSizeInventory();
		int[] slots = new int[size];
		for(int i = 0; i < size; i++)
		{
			slots[i] = i;
		}
		return slots;
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side) {
		//SieveRegistry.Contains(Block.getBlockFromItem(item.getItem()),item.getItemDamage()) &&
		if (SieveRegistry.Contains(Block.getBlockFromItem(item.getItem()),item.getItemDamage()) && slot == 0)
		{
		//ExAstris.ExAstris.log.info("IMPORTANT INFO : slot "+slot+" side "+side);
			return true;
		}
		return false;
		//return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) {
		if (slot >= 1) return true;
		return false;
	}
}
