package ExAstris.Proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import ExAstris.ExAstrisBlock;
import ExAstris.Block.Model.ModelBarrelThaumium;
import ExAstris.Block.Render.RenderBarrelThaumium;
import ExAstris.Block.Render.Item.ItemRenderBarrelThaumium;
import ExAstris.Block.TileEntity.TileEntityBarrelThaumium;

public class ProxyClient extends Proxy {
	public ProxyClient()
	{
		Proxy.setInstance((Proxy)this);
	}
	@Override
	public void initializeRenderers() {
		ModelBarrelThaumium barrel = new ModelBarrelThaumium();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrelThaumium.class, new RenderBarrelThaumium(barrel));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisBlock.BarrelThaumium), new ItemRenderBarrelThaumium(barrel));
		
	}
}
