package ExAstris.Proxy;

public class ProxyServer extends Proxy {
	public ProxyServer()
	{
		Proxy.setInstance((Proxy)this);
	}
}
