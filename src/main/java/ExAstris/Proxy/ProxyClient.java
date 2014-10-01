package ExAstris.Proxy;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Loader;
import exnihilo.blocks.models.ModelSieveMesh;
import ExAstris.ExAstrisBlock;
import ExAstris.Block.Model.ModelBarrelThaumium;
import ExAstris.Block.Model.ModelSieveAutomatic;
import ExAstris.Block.Render.RenderBarrelThaumium;
import ExAstris.Block.Render.RenderSieveAutomatic;
import ExAstris.Block.Render.Item.ItemRenderBarrelThaumium;
import ExAstris.Block.Render.Item.ItemRenderSieveAutomatic;
import ExAstris.Block.TileEntity.TileEntityBarrelThaumium;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;

public class ProxyClient extends Proxy {
	
	public ProxyClient()
	{
		Proxy.setInstance((Proxy)this);
	}
	
	@Override
	public void initializeRenderers() {
		if(Loader.isModLoaded("Thaumcraft")){
			ModelBarrelThaumium barrel = new ModelBarrelThaumium();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrelThaumium.class, new RenderBarrelThaumium(barrel));
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisBlock.BarrelThaumium), new ItemRenderBarrelThaumium(barrel));
		}
		if(Loader.isModLoaded("ThermalExpansion")){
			ModelSieveAutomatic sieve = new ModelSieveAutomatic();
			ModelSieveMesh mesh = new ModelSieveMesh();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySieveAutomatic.class, new RenderSieveAutomatic(sieve, mesh));
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisBlock.SieveAutomatic), new ItemRenderSieveAutomatic(sieve, mesh));
		}
		
	}
	
}
