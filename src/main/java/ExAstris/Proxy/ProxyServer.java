package ExAstris.Proxy;

import net.minecraft.world.World;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ProxyServer extends Proxy {
	public ProxyServer()
	{
		Proxy.setInstance((Proxy)this);
	}
	
	
}
