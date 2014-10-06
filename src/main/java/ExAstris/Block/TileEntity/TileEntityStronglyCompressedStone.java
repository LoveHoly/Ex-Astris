package ExAstris.Block.TileEntity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityStronglyCompressedStone extends TileEntity {
	private int timer;
	private float volume;
	private static final int UPDATE_INTERVAL = 20;
	
	public TileEntityStronglyCompressedStone() {
		super();
	}
	@Override
	public void updateEntity()
	{
			//ExAstris.ExAstris.log.info("META3CHECKINGABLE,"+timer+","+TIMER_MAX);
		timer ++;
		if (timer > UPDATE_INTERVAL)
		{
			timer = 0;
			volume += 0.01f;
			ExAstris.ExAstris.log.info("+++ - UpdateV!"+this.volume);
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		if (volume > 1.0f)
		{
			worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.bedrock, 0, 3);
			
		}
			
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.volume = compound.getFloat("volume");
		//ExAstris.ExAstris.log.info("+++ - READFROMENBT!"+volume);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setFloat("volume", this.volume);
		//ExAstris.ExAstris.log.info("+++ - WRITETONBT!"+volume);
	}
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.func_148857_g();
		this.readFromNBT(tag);
	}
	public float getVolume()
	{
		ExAstris.ExAstris.log.info("+++ - getVolume!"+this.volume);
		return this.volume;
	}
}
