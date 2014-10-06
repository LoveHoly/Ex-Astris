package ExAstris.GUI;

import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import ExAstris.Slot.SlotClosed;
import ExAstris.Slot.SlotSieveAutomatic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSieveAutomatic extends Container {
	public TileEntitySieveAutomatic sieve;
	public ContainerSieveAutomatic(InventoryPlayer invPlayer,
			TileEntitySieveAutomatic entity) {
		sieve = entity;
		this.addSlotToContainer(new SlotSieveAutomatic(sieve, 0, 7, 35));
		
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
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		// TODO Auto-generated method stub
		return sieve.isUseableByPlayer(par1EntityPlayer);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		return null;
	}

}
