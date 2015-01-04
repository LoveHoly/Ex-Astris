package ExAstris.Block.Render;

import org.lwjgl.opengl.GL11;

import ExAstris.Block.TileEntity.TileEntityHammerAutomatic;
import ExAstris.Data.ModData;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderHammerAutomatic extends TileEntitySpecialRenderer {

	private IModelCustom model;
	private IModelCustom arm;
	
	public RenderHammerAutomatic()
	{
		model = AdvancedModelLoader.loadModel(new ResourceLocation(ModData.TEXTURE_LOCATION, "models/hammer_base.obj"));
		arm = AdvancedModelLoader.loadModel(new ResourceLocation(ModData.TEXTURE_LOCATION, "models/hammer_arm.obj"));
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslated(x+0.5, y, z+0.5);
        //Minecraft.getMinecraft().renderEngine.func_110577_a(casinoTexture);
        model.renderAll();
        
        TileEntityHammerAutomatic hammer = (TileEntityHammerAutomatic) tileentity;
        
        GL11.glTranslated(x+0.5, y-0.5+hammer.getVolume(), z+0.5);
        arm.renderAll();
        
        GL11.glPopMatrix();
		
		
	}

}
