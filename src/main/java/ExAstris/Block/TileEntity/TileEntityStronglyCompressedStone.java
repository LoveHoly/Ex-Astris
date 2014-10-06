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
		if(blockMetadata == 3)
		{
			//ExAstris.ExAstris.log.info("META3CHECKINGABLE,"+timer+","+TIMER_MAX);
			timer ++;
			if (timer > UPDATE_INTERVAL)
			{
				timer = 0;
				volume += 0.01f;
			}
			if (volume > 1.0f)
			{
				worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.bedrock, 0, 3);
			}
		}
			
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		blockMetadata = compound.getInteger("blockMetadata");
		volume = compound.getFloat("volume");
		ExAstris.ExAstris.log.info("+++ - READFROMENBT!");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("blockMetadata", blockMetadata);
		compound.setFloat("volume", volume);
		ExAstris.ExAstris.log.info("+++ - WRITETONBT!");
	}
	
	public float getVolume()
	{
		return volume;
	}
}
