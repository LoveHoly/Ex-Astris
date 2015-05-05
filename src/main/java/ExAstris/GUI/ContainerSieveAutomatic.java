package ExAstris.GUI;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import ExAstris.Slot.SlotClosed;
import ExAstris.Slot.SlotSieveAutomatic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSieveAutomatic extends Container 
{
	public TileEntitySieveAutomatic sieve;
	private int lastEnergy;
	
	public ContainerSieveAutomatic(InventoryPlayer invPlayer,
			TileEntitySieveAutomatic entity) 
	{
		sieve = entity;
		this.addSlotToContainer(new SlotSieveAutomatic(sieve, 0, 8, 35));

		int i;

		for (i = 0; i<4;++i)
		{
			for (int j = 0; j < 5; ++j)
			{
				this.addSlotToContainer(new SlotClosed(sieve, 1+(i*5)+j, 57+(j*18), 8+(i*18)));
			}
		}
		
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
	

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
		
		this.addSlotToContainer(new SlotSieveAutomatic(sieve, 21, 8, 62));
		this.addSlotToContainer(new SlotSieveAutomatic(sieve, 22, 33, 62));
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return sieve.isUseableByPlayer(par1EntityPlayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNum)
	{
		ItemStack stack = null;
		Slot slot = this.getSlot(slotNum);
		if (slot != null & slot.getHasStack())
		{
			ItemStack stackInSlot = slot.getStack();
			stack = stackInSlot.copy();
			if (slotNum <= 20 || slotNum == 57 || slotNum == 58) //In the sieve!
			{
				if (!this.mergeItemStack(stackInSlot, 21, 57, true))
					return null;
			}
			else if (this.sieve.canInsertItem(0, stackInSlot, 0))
			{
				if (!this.mergeItemStack(stackInSlot, 0, 1, false))
					return null;
			}
			else if (this.sieve.canInsertItem(21, stackInSlot, 0))
			{
				if (!this.mergeItemStack(stackInSlot, 57, 58, false))
					return null;
			}
			
			else if (this.sieve.canInsertItem(22, stackInSlot, 0))
			{
				if (!this.mergeItemStack(stackInSlot, 58, 59, false))
					return null;
			}

			
			if (stackInSlot.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slot.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++)
		{
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			if (this.lastEnergy != sieve.getEnergyStored(null))
			{
				icrafting.sendProgressBarUpdate(this, 0, sieve.getEnergyStored(null));
			}
		}
		this.lastEnergy = sieve.getEnergyStored(null);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int par1, int par2)
	{
		sieve.setEnergyStored(par2);
	}

}
