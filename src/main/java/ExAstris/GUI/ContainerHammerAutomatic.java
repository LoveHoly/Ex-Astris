package ExAstris.GUI;

import ExAstris.Block.TileEntity.TileEntityHammerAutomatic;
import ExAstris.Slot.SlotClosed;
import ExAstris.Slot.SlotHammerAutomatic;
import ExAstris.Slot.SlotSieveAutomatic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerHammerAutomatic extends Container {

	public TileEntityHammerAutomatic hammer;
	
	public ContainerHammerAutomatic(InventoryPlayer invPlayer,
			TileEntityHammerAutomatic entity) 
	{
		hammer = entity;
		this.addSlotToContainer(new SlotHammerAutomatic(hammer, 0, 8, 35));

		int i;

		for (i = 0; i<4;++i)
		{
			for (int j = 0; j < 5; ++j)
			{
				this.addSlotToContainer(new SlotClosed(hammer, 1+(i*5)+j, 57+(j*18), 8+(i*18)));
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
		
		this.addSlotToContainer(new SlotHammerAutomatic(hammer, 21, 8, 62));
		this.addSlotToContainer(new SlotHammerAutomatic(hammer, 22, 33, 62));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return hammer.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNum)
	{
		return null;
	}

}
