package ExAstris.Proxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;

public class Proxy {

	protected static Proxy proxyInstance = null;

	public static void setInstance(Proxy newProxy)
	{
		proxyInstance = newProxy;
	}

	public static Proxy getProxy()
	{
		if (proxyInstance == null)
		{
			proxyInstance = new Proxy();
		}
		
		return proxyInstance;
	}
	
	public void initializeSounds(){}
	public void initializeRenderers(){}
	public World getWorld()
	{
		return null;
	}
	
	 public static boolean runningOnServer()
	  {
	    boolean server = false;
	    
	    try
	    {
	      server = serverCheck();
	    }
	    catch (NoSuchMethodError e)
	    {
	      server = false;
	    }
	    
	    return server;
	  }
	  
	  @SideOnly(Side.SERVER)
	  public static boolean serverCheck()
	  {
	    return true;
	  }
}

