package ExAstris.Proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import ExAstris.ExAstrisBlock;
import ExAstris.Block.BlockHammerAutomatic;
import ExAstris.Block.Model.ModelBarrelThaumium;
import ExAstris.Block.Model.ModelSieveAutomatic;
import ExAstris.Block.Render.RenderBarrelThaumium;
import ExAstris.Block.Render.RenderBlockHammer;
import ExAstris.Block.Render.RenderHammerAutomatic;
import ExAstris.Block.Render.RenderSieveAutomatic;
import ExAstris.Block.Render.Item.ItemRenderBarrelThaumium;
import ExAstris.Block.Render.Item.ItemRenderSieveAutomatic;
import ExAstris.Block.TileEntity.TileEntityBarrelThaumium;
import ExAstris.Block.TileEntity.TileEntityHammerAutomatic;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import exnihilo.blocks.models.ModelSieveMesh;

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
		
		if(Loader.isModLoaded("ThermalExpansion") || Loader.isModLoaded("EnderIO")){
			ModelSieveAutomatic sieve = new ModelSieveAutomatic();
			ModelSieveMesh mesh = new ModelSieveMesh();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySieveAutomatic.class, new RenderSieveAutomatic(sieve, mesh));
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisBlock.SieveAutomatic), new ItemRenderSieveAutomatic(sieve, mesh));
			
			BlockHammerAutomatic.renderId = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new RenderBlockHammer());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHammerAutomatic.class,  new RenderHammerAutomatic());
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisBlock.HammerAutomatic), new RenderBlockHammer());
		}
	}
	
}
