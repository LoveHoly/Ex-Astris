package ExAstris.Item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import ExAstris.Proxy.Proxy;
import ExAstris.Util.CrookUtils;
import redstonearsenal.item.RAItems;
import redstonearsenal.item.tool.ItemToolRF;

public class ItemCrookRF extends ItemToolRF {
	
	public static IIcon itemIcon;
	public static IIcon empoweredIcon;
	
	
	public ItemCrookRF()
	{
		super(RAItems.TOOL_MATERIAL_FLUX);
		this.energyPerUseCharged=ModData.crookEnergyUsagePowered;
		this.energyPerUse=ModData.crookEnergyUsageUnpowered;
		this.setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		this.setUnlocalizedName(ItemData.CROOK_RF_UNLOCALIZED_NAME);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.CROOK_RF_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.CROOK_RF_UNLOCALIZED_NAME;
	}
	
	@Override
	public boolean func_150897_b(Block block)
	{
		return block.isLeaves(Proxy.getProxy().getWorld(), 0, 0, 0);
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		if (getEnergyStored(item) < getEnergyPerUse(item))
				return false;
		
		boolean valid = CrookUtils.doCrooking(item, X, Y, Z, player);
		
		if (valid)
		{
			useEnergy(item, false);
		}
		return false;
	}
	
	@Override
	public float getDigSpeed(ItemStack item, Block block, int meta)
	{
		if (isEmpowered(item))
			return efficiencyOnProperMaterial * 3.0f;
		else if (getEnergyStored(item) >= getEnergyPerUse(item))
			return efficiencyOnProperMaterial * 1.0f;
		
		return 0.5f;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":CrookRF");
	    this.empoweredIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":CrookRF_Active");
	}
	
	@Override
	public IIcon getIcon(ItemStack paramItemStack, int paramInt)
	{
		return getEnergyStored(paramItemStack) <= 0 ? this.itemIcon : isEmpowered(paramItemStack) ? this.empoweredIcon : this.itemIcon;
	}
	
	public EnumRarity getRarity()
	{
		return EnumRarity.uncommon;
	}

}
