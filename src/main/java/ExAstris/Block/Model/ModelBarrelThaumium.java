package ExAstris.Block.Model;

import ExAstris.ExAstrisBlock;
import ExAstris.Data.ModData;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import exnihilo.ENBlocks;

public class ModelBarrelThaumium extends ModelBase
{
  //fields
	//public static final ResourceLocation oak = new ResourceLocation("skyblock", "textures/blocks/ModelBarrelOak.png");
	private static final ResourceLocation texture = new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/blocks/ModelBarrelThaumium.png");
	
    public ModelRenderer bottom;
    public ModelRenderer side1;
    public ModelRenderer side2;
    public ModelRenderer side3;
    public ModelRenderer side4;
    
    
    public ResourceLocation getBarrelTexture(Block block, int meta)
    {
    	return texture;
    }
    
  public ModelBarrelThaumium()
  {
      textureWidth = 128;
      textureHeight = 128;
    
      bottom = new ModelRenderer(this, 0, 0);
      bottom.addBox(-7F, 0F, -7F, 14, 1, 14);
      bottom.setRotationPoint(0F, 23F, 0F);
      bottom.setTextureSize(128, 128);
      bottom.mirror = true;
      setRotation(bottom, 0F, 0F, 0F);
      
      side1 = new ModelRenderer(this, 0, 16);
      side1.addBox(-8F, -8F, 0F, 16, 16, 1);
      side1.setRotationPoint(0F, 16F, 7F);
      side1.setTextureSize(128, 128);
      side1.mirror = true;
      setRotation(side1, 0F, 0F, 0F);
      
      side2 = new ModelRenderer(this, 0, 34);
      side2.addBox(-8F, -8F, 0F, 16, 16, 1);
      side2.setRotationPoint(0F, 16F, -8F);
      side2.setTextureSize(128, 128);
      side2.mirror = true;
      setRotation(side2, 0F, 0F, 0F);
      
      side3 = new ModelRenderer(this, 35, 16);
      side3.addBox(0F, -8F, -7F, 1, 16, 14);
      side3.setRotationPoint(-8F, 16F, 0F);
      side3.setTextureSize(128, 128);
      side3.mirror = true;
      setRotation(side3, 0F, 0F, 0F);
      
      side4 = new ModelRenderer(this, 66, 16);
      side4.addBox(0F, -8F, -7F, 1, 16, 14);
      side4.setRotationPoint(7F, 16F, 0F);
      side4.setTextureSize(128, 128);
      side4.mirror = true;
      setRotation(side4, 0F, 0F, 0F);
      

  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	  setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  bottom.render(f5);
	  side1.render(f5);
	  side2.render(f5);
	  side3.render(f5);
	  side4.render(f5);
  }
  
  public void simpleRender(float scale)
  {
	  bottom.render(scale);
	  side1.render(scale);
	  side2.render(scale);
	  side3.render(scale);
	  side4.render(scale);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
