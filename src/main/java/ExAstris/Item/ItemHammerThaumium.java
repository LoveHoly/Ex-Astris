package ExAstris.Item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import ExAstris.Data.ItemData;
import ExAstris.Data.ModData;
import exnihilo.items.hammers.ItemHammerBase;
import cpw.mods.fml.common.Optional.Interface;
import thaumcraft.api.IRepairable;

@Interface(iface="thaumcraft.api.IRepairable", modid="Thaumcraft")
public class ItemHammerThaumium extends ItemHammerBase implements IRepairable{

	public ItemHammerThaumium() {
		super(ToolMaterial.EMERALD);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ModData.ID + "." + ItemData.HAMMER_THAUMIUM_UNLOCALIZED_NAME;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ModData.ID + "." + ItemData.HAMMER_THAUMIUM_UNLOCALIZED_NAME;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":HammerThaumium");
	}
	
	public EnumRarity getRarity()
	{
		return EnumRarity.uncommon;
	}
}