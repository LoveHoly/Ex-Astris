package ExAstris.Bridge;

import java.text.DecimalFormat;
import java.util.List;

import ExAstris.Block.BlockBarrelThaumium;
import ExAstris.Block.BlockQStronglyCompressedStone;
import ExAstris.Block.BlockSieveAutomatic;
import ExAstris.Block.BlockStronglyCompressedStone;
import ExAstris.Block.TileEntity.TileEntityBarrelThaumium;
import ExAstris.Block.TileEntity.TileEntityBarrelThaumium.BarrelMode;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic.SieveMode;
import ExAstris.Block.TileEntity.TileEntityStronglyCompressedStone;
import net.minecraft.item.ItemStack;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;

public class Waila implements IWailaDataProvider {

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		return null;
	}

	@Override
	public List<String> getWailaHead(ItemStack stack, List<String> currentTip,
			IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currentTip;
	}
	
	@Override
	public List<String> getWailaBody(ItemStack stack, List<String> currentTip,
			IWailaDataAccessor accessor, IWailaConfigHandler config) {
		if (accessor.getBlock() instanceof BlockBarrelThaumium) {
			TileEntityBarrelThaumium teBarrel = (TileEntityBarrelThaumium) accessor
					.getTileEntity();
			currentTip.add(getBarrelDisplay(teBarrel.getMode(), teBarrel));
		} 
		else if (accessor.getBlock() instanceof BlockSieveAutomatic) {
			TileEntitySieveAutomatic teSieve = (TileEntitySieveAutomatic) accessor
					.getTileEntity();
			currentTip.add(getSieveDisplay(teSieve));
		} 
		else if (accessor.getBlock() instanceof BlockQStronglyCompressedStone) {
			TileEntityStronglyCompressedStone scStone = (TileEntityStronglyCompressedStone) accessor
					.getTileEntity();
			currentTip.add(getSCStoneDisplay(scStone));
		} 
		return currentTip;
	}
	
	@Override
	public List<String> getWailaTail(ItemStack stack, List<String> currentTip,
			IWailaDataAccessor accessor, IWailaConfigHandler config) {
		if (accessor.getBlock() instanceof BlockSieveAutomatic) {
			TileEntitySieveAutomatic teSieve = (TileEntitySieveAutomatic) accessor
				.getTileEntity();
			currentTip.add(getSieveDisplayTail(teSieve));
		} 
		return currentTip;
	}
	
	public String getBarrelDisplay(BarrelMode mode, TileEntityBarrelThaumium barrel) {
		DecimalFormat format = new DecimalFormat("##.#");
		switch (mode) {
		case EMPTY:
			return "Empty";
		case FLUID:
			if (barrel.isFull())
				return barrel.fluid.getFluid().getName();
			else
				return barrel.fluid.getFluid().getName() + " "
						+ format.format(barrel.getVolume() * 100) + "%";
		case COMPOST:
			if (barrel.isFull())
				return "Composting: "
						+ Math.round(getBarrelTimeRemaining(barrel)) + "%";
			else
				return "Collecting Material: "
						+ format.format(barrel.getVolume() * 100) + "%";
		case DIRT:
			return "Dirt";
		case CLAY:
			return "Clay";
		case MILKED:
			return "Sliming: " + Math.round(getBarrelTimeRemaining(barrel))
					+ "%";
		case SLIME:
			return "Slime";
		case SPORED:
			return "Transforming: "
					+ Math.round(getBarrelTimeRemaining(barrel)) + "%";
		case ENDER_COOKING:
		case BLAZE_COOKING:
		case PECK_COOKING:
		case BLIZZ_COOKING:
			return "Summoning: " + Math.round(getBarrelTimeRemaining(barrel))
					+ "%";
		case ENDER:
		case BLAZE:
		case PECK:
		case BLIZZ:
			return "Incoming!";
		case DARKOAK:
			return "Dark Oak Sapling";
		case BEETRAP:
			return "Scented Artifical Hive";
		case COBBLESTONE:
			return "Cobblestone";
		case ENDSTONE:
			return "End Stone";
		case NETHERRACK:
			return "Netherrack";
		case OBSIDIAN:
			return "Obsidian";
		case SOULSAND:
			return "Soul Sand";
		case OBSIDIANTOTEM:
			return "Obsidian Totem";
		case BEEINFUSED:
			return "Infused Artifical Hive";
		case BLOCK:
			return barrel.block.getLocalizedName();
		default:
			return "";
		}
	}
	
	public String getSieveDisplay(TileEntitySieveAutomatic sieve) {
		if (sieve.mode == SieveMode.EMPTY)
			return "Empty";// 
		else
			return Math.round(getSieveClicksRemaining(sieve)) + "% left";// + sieve.storage.getEnergyStored() + " / " + sieve.storage.getMaxEnergyStored() + " RF"
	}
	
	public String getSCStoneDisplay(TileEntityStronglyCompressedStone stone) {
		DecimalFormat format = new DecimalFormat("##.#");
		return "Transforming: " + format.format(stone.getVolume() * 100) + "%";
	}
	
	public String getSieveDisplayTail(TileEntitySieveAutomatic sieve) {
		return sieve.storage.getEnergyStored() + " / " + sieve.storage.getMaxEnergyStored() + " RF";
	}
	public float getBarrelTimeRemaining(TileEntityBarrelThaumium barrel) {
		return (barrel.getTimer() / (float) 1000) * 100;
	}
	
	public static void callbackRegister(IWailaRegistrar registrar) {
		Waila instance = new Waila();
		registrar.registerBodyProvider(instance, BlockBarrelThaumium.class);
		registrar.registerBodyProvider(instance, BlockSieveAutomatic.class);
		registrar.registerBodyProvider(instance, BlockQStronglyCompressedStone.class);
	}
	public float getSieveClicksRemaining(TileEntitySieveAutomatic sieve) {
		return (sieve.getVolume() / 1) * 100;
	}
	
	
	
}
