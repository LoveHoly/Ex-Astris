package ExAstris.Block.TileEntity;

import java.util.Random;

import ExAstris.Data.ModData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;

public class TileEntityHammerAutomatic extends TileEntity  implements IEnergyHandler, ISidedInventory{

	public EnergyStorage energy = new EnergyStorage(64000);
	private int energyPerCycle = ModData.hammerAutomaticBaseEnergy;
	private float processingInterval = 0.005f;
	private static float updateInterval = 20;
	private int speedLevel;
	protected ItemStack[] inventory;
	HammerMode mode;
	private static Random rand = new Random();

	public enum HammerMode
	{
		EMPTY, FULL
	}

	public TileEntityHammerAutomatic()
	{
		this.inventory = new ItemStack[getSizeInventory()];
		this.speedLevel=0;
		this.mode=HammerMode.EMPTY;
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection arg0) 
	{
		return true;
	}

	@Override
	public int getSizeInventory() 
	{
		return 23;
	}

	@Override
	public ItemStack getStackInSlot(int slot) 
	{
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
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) 
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) 
	{
		inventory[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}

	}

	@Override
	public String getInventoryName() 
	{
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) 
	{
		int size = getSizeInventory()-2;
		int[] slots = new int[size];
		for(int i = 0; i < size; i++)
		{
			slots[i] = i;
		}
		return slots;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
			int p_102007_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
			int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int extractEnergy(ForgeDirection arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int receiveEnergy(ForgeDirection arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public float getEffectiveSpeed()
	{
		float time = processingInterval;
		if (inventory[21] != null)
		{
			time += (((float)inventory[21].stackSize)/1024);
		}
		return time;
	}

	public int getEffectiveEnergy()
	{
		int energy = energyPerCycle;
		if (inventory[21] != null)
		{
			energy *= ((((float)inventory[21].stackSize)/1024) + processingInterval)/processingInterval;
		}
		if (inventory[22] != null)
		{
			energy += inventory[22].stackSize * ModData.sieveFortuneRFIncrease;
		}
		return energy;
	}

	public int getFortuneModifier()
	{
		if (inventory[22]== null || ModData.sieveFortuneChance==0)
		{
			return 1;
		}
		else
		{
			int multiplier=1;
			for (int i = 0; i < inventory[22].stackSize; i++)
			{
				if (rand.nextInt(101-ModData.sieveFortuneChance) == 0)
					multiplier++;
			}	
			return multiplier;
		}
	}

}
