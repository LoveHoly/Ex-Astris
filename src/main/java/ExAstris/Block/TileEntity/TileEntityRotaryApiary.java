package ExAstris.Block.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cofh.lib.util.helpers.ItemHelper;

import com.mojang.authlib.GameProfile;

import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.genetics.IIndividual;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.ISpeciesRoot;
import Reika.RotaryCraft.Base.TileEntity.TileEntityPowerReceiver;
import Reika.RotaryCraft.Registry.MachineRegistry;


public class TileEntityRotaryApiary extends TileEntityPowerReceiver  implements IBeeHousing, ISidedInventory{
	public boolean Hellish = false;
	public boolean Sealed = false;
	public boolean SelfLighted = false;
	public boolean SunlightSimulated = false;
	public ISpeciesRoot beeRoot = AlleleManager.alleleRegistry.getSpeciesRoot("rootBees");
	protected ItemStack[] inventory;
	
	private int biomeId = -1;
	private float temperature;
	private float humidity;
	
	
	public TileEntityRotaryApiary()
	{
		inventory = new ItemStack[getSizeInventory()];
	}
	//Rotary Power!!
	@Override
	protected void animateWithTick(World arg0, int arg1, int arg2, int arg3) {}

	@Override
	public MachineRegistry getMachine() {return null;}

	@Override
	public boolean hasModelTransparency() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRedstoneOverride() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateEntity(World world, int x, int y, int z, int meta) {
		super.updateTileEntity();
		this.tickcount += 1;
		getIOSidesDefault(world, x, y, z, meta);
	    getPower(false);
	    
	    if ((this.power < this.MINPOWER) || (this.omega < this.MINSPEED)) {
	    	return;
	    }
		
	}
	
	
	// BEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
	@Override
	public float getFloweringModifier(IBeeGenome arg0, float arg1) {
		// TODO Auto-generated method stub
	    return 3.0F;
	}

	@Override
	public float getGeneticDecay(IBeeGenome arg0, float arg1) {
		// TODO Auto-generated method stub
	    return 0.0F;
	}

	@Override
	public float getLifespanModifier(IBeeGenome arg0, IBeeGenome arg1,
			float arg2) {
		// TODO Auto-generated method stub
	    return 3.0F;
	}

	@Override
	public float getMutationModifier(IBeeGenome arg0, IBeeGenome arg1,
			float arg2) {
		// TODO Auto-generated method stub
	    return 0.0F;
	}

	@Override
	public float getProductionModifier(IBeeGenome arg0, float arg1) {
		// TODO Auto-generated method stub
	    return 0.25F;
	}

	@Override
	public float getTerritoryModifier(IBeeGenome arg0, float arg1) {
		// TODO Auto-generated method stub
	    return 1.0F;
	}

	@Override
	public boolean isHellish() {
		// TODO Auto-generated method stub
		return Hellish;
	}

	@Override
	public boolean isSealed() {
		// TODO Auto-generated method stub
		return Sealed;
	}

	@Override
	public boolean isSelfLighted() {
		// TODO Auto-generated method stub
		return SelfLighted;
	}

	@Override
	public boolean isSunlightSimulated() {
		// TODO Auto-generated method stub
		return SunlightSimulated;
	}

	@Override
	public boolean onEggLaid(IBee arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onPollenRetrieved(IBee arg0, IIndividual arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPostQueenDeath(IBee arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onQueenChange(ItemStack arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onQueenDeath(IBee arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wearOutEquipment(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addProduct(ItemStack product, boolean all) {
		int inventoryIndex = 0;
		for(int i = 2; i < getSizeInventory(); i++)
		{
			if(inventory[i] == null)
			{
				inventoryIndex=i;
				break;
			}else{
				if( ItemHelper.itemsEqualWithMetadata(inventory[i],product) )
				{
					inventoryIndex=i;
					break;
				}
			}
		}
		
		if(inventoryIndex != 0)
		{
			if(inventory[inventoryIndex] != null) inventory[inventoryIndex] = new ItemStack(product.getItem(),inventory[inventoryIndex].stackSize+ product.stackSize, product.getItemDamage());
			else inventory[inventoryIndex] = new ItemStack(product.getItem(), product.stackSize, product.getItemDamage());
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getBiomeId() {
		// TODO Auto-generated method stub
		return this.biomeId;
	}

	@Override
	public int getErrorOrdinal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EnumHumidity getHumidity() {
		// TODO Auto-generated method stub
		return EnumHumidity.getFromValue(humidity);
	}

	@Override
	public GameProfile getOwnerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnumTemperature getTemperature() {
		// TODO Auto-generated method stub
		if (EnumTemperature.isBiomeHellish(biomeId))
			return EnumTemperature.HELLISH;
		return EnumTemperature.getFromValue(temperature);
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return worldObj;
	}

	@Override
	public int getXCoord() {
		// TODO Auto-generated method stub
		return xCoord;
	}

	@Override
	public int getYCoord() {
		// TODO Auto-generated method stub
		return yCoord;
	}

	@Override
	public int getZCoord() {
		// TODO Auto-generated method stub
		return zCoord;
	}

	@Override
	public void setErrorState(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canBreed() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getDrone() {
		// TODO Auto-generated method stub
		return inventory[1];
	}

	@Override
	public ItemStack getQueen() {
		// TODO Auto-generated method stub
		return inventory[0];
	}

	@Override
	public void setDrone(ItemStack item) {
		inventory[1] = item;
		
	}

	@Override
	public void setQueen(ItemStack item) {
		inventory[0] = item;
		
	}

	
	
	
	//IVVVVVVVVVVVVVVVVVVVVVVVVVVVEN
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 11;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		// TODO Auto-generated method stub
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(inventory[slot] != null)
		{
			if(inventory[slot].stackSize <= amount)
			{
				ItemStack itemstack = inventory[slot];
				inventory[slot] = null;
				//onFactoryInventoryChanged();
				return itemstack;
			}
			ItemStack itemstack1 = inventory[slot].splitStack(amount);
			if(inventory[slot].stackSize == 0)
			{
				inventory[slot] = null;
			}
			return itemstack1;
		}
		else
		{
			//onFactoryInventoryChanged();
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		// TODO Auto-generated method stub
		inventory[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit())
		{
				stack.stackSize = getInventoryStackLimit();
		}
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		if (slot == 0)
		{
			return beeRoot.isMember(item,EnumBeeType.QUEEN.ordinal()) || beeRoot.isMember(item,EnumBeeType.PRINCESS.ordinal());
		}
		else if(slot == 1)
		{
			return beeRoot.isMember(item,EnumBeeType.DRONE.ordinal());
		}
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		int size = getSizeInventory();
		int[] slots = new int[size];
		for(int i = 0; i < size; i++)
		{
			slots[i] = i;
		}
		return slots;
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side) {
		if (slot == 0)
		{
			return beeRoot.isMember(item,EnumBeeType.QUEEN.ordinal()) || beeRoot.isMember(item,EnumBeeType.PRINCESS.ordinal());
		}
		else if(slot == 1)
		{
			return beeRoot.isMember(item,EnumBeeType.DRONE.ordinal());
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) {
		if (slot >= 2) return true;
		return false;
	}

}
