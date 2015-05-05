package ExAstris.GUI;

import ExAstris.Block.TileEntity.TileEntityHammerAutomatic;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID == 0){

			TileEntitySieveAutomatic sieve = (TileEntitySieveAutomatic)world.getTileEntity(x, y, z);
			return new ContainerSieveAutomatic(player.inventory, sieve);

		}
		if (ID == 1) 
		{
			TileEntityHammerAutomatic hammer = (TileEntityHammerAutomatic) world.getTileEntity(x,y,z);
			return new ContainerHammerAutomatic(player.inventory, hammer);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID == 0){

			TileEntitySieveAutomatic sieve = (TileEntitySieveAutomatic)world.getTileEntity(x, y, z);
			return new GUISieveAutomatic(player.inventory, sieve);

		}
		if (ID == 1)
		{
			TileEntityHammerAutomatic hammer = (TileEntityHammerAutomatic) world.getTileEntity(x,y,z);
			return new GUIHammerAutomatic(player.inventory, hammer);
		}
		return null;
	}

}
