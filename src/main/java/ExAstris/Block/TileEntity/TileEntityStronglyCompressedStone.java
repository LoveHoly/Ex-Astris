package ExAstris.Block.TileEntity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityStronglyCompressedStone extends TileEntity {
	public int META;
	private int timer = 0;
	private static int TIMER_MAX = 6000;
	public TileEntityStronglyCompressedStone(int meta) {
		super();
		META = meta;
	}
	@Override
	public void updateEntity()
	{
		//ExAstris.ExAstris.log.info("META:"+META);
		if(!worldObj.isRemote && META == 3)
		{
			//ExAstris.ExAstris.log.info("META3CHECKINGABLE,"+timer+","+TIMER_MAX);
			timer ++;
			//worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			if (timer > TIMER_MAX)
			{
				worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.bedrock, 0, 3);
			}
		}
			
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		timer = compound.getInteger("timer");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("timer", timer);
	}
		
	public int getMeta()
	{
		return META;
	}
	
	public int getTimer()
	{
		return timer;
	}
}
