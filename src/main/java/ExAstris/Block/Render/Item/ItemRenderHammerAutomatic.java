package ExAstris.Block.Render.Item;

import org.lwjgl.opengl.GL11;



import exnihilo.blocks.models.ModelSieveMesh;
//import exnihilo.blocks.models.ModelSieveMesh;
import ExAstris.Block.BlockSieveAutomatic;
import ExAstris.Block.Model.ModelSieveAutomatic;
import ExAstris.Data.ModData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ItemRenderHammerAutomatic  implements IItemRenderer {
	private IModelCustom model;
	private IModelCustom arm;

	public ItemRenderHammerAutomatic()
	{
		model = AdvancedModelLoader.loadModel(new ResourceLocation(ModData.TEXTURE_LOCATION, "models/hammer_base.obj"));
		arm = AdvancedModelLoader.loadModel(new ResourceLocation(ModData.TEXTURE_LOCATION, "models/hammer_arm.obj"));
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type)
		{
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		case FIRST_PERSON_MAP:
			return false;
		case INVENTORY:
			break;
		}
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (type)
		{
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		case FIRST_PERSON_MAP:
			return false;
		case INVENTORY:
			break;
		}

		switch (helper)
		{
		case BLOCK_3D:
			break;
		case ENTITY_BOBBING:
			break;
		case ENTITY_ROTATION:
			break;
		case EQUIPPED_BLOCK:
			break;
		case INVENTORY_BLOCK:
			break;
		default:
			break;

		}
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		//Minecraft.getMinecraft().renderEngine.func_110577_a(casinoTexture);
		GL11.glTranslated(0, -0.5, 0);
		model.renderAll();
		arm.renderAll();
		GL11.glPopMatrix();
	}

	


}
