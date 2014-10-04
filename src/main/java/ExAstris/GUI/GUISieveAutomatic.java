package ExAstris.GUI;

import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import ExAstris.Data.ModData;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GUISieveAutomatic extends GuiContainer{
	public static final ResourceLocation texture = new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/gui/macerator.png");
	public TileEntitySieveAutomatic sieve;
	
	
	public GUISieveAutomatic(InventoryPlayer invPlayer, TileEntitySieveAutomatic entity) {
		super(new ContainerSieveAutomatic(invPlayer, entity));
		// TODO Auto-generated constructor stub
		sieve = entity;
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}

}
