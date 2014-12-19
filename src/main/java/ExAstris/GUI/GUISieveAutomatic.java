package ExAstris.GUI;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic.SieveMode;
import ExAstris.Data.ModData;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GUISieveAutomatic extends GuiContainer{
	public static final ResourceLocation texture = new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/gui/sieveautomatic.png");
	public TileEntitySieveAutomatic sieve;

	public GUISieveAutomatic(InventoryPlayer invPlayer, TileEntitySieveAutomatic entity) {
		super(new ContainerSieveAutomatic(invPlayer, entity));

		sieve = entity;
		xSize = 176;
		ySize = 166;

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;

		if(sieve.mode != SieveMode.EMPTY)
		{
			i1= 15-(int)((float)sieve.getVolume()*15.0);
			this.drawTexturedModalRect(k + 32, l + 36, 176, 0, i1, 15);
		}

		i1= (int)((float)sieve.storage.getEnergyStored()/sieve.storage.getMaxEnergyStored()*60.0);
		this.drawTexturedModalRect(k + 152, l + 9+(60-i1), 176 + 15, 0, 16, i1);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		int x = (this.width - this.xSize)/2 + 152;
		int y = (this.height - this.ySize)/2;

		if (mouseX > x && mouseX < x+16 && mouseY < y+69 && mouseY > y - 51)
		{
			List<String> lines = new ArrayList<String>();
			lines.add(this.sieve.getEnergyStored(null)+ " RF");
			lines.add("Consuming "+this.sieve.getEffectiveEnergy()+ "RF/t");
			this.func_146283_a(lines, mouseX - x + 152, mouseY-y+10);
		}
	}

}
