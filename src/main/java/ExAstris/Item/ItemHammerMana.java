package ExAstris.Item;

import exnihilo.items.hammers.ItemHammerBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemHammerMana extends ItemHammerBase implements IManaUsingItem {

	public static final int MANA_PER_DAMAGE = 60;
	
	public ItemHammerMana()
	{
		super(ToolMaterial.EMERALD);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
		this.setUnlocalizedName("manaHammer");
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		if (ManaItemHandler.requestManaExactForTool(item, player, 250, false))
		{
			boolean broken = super.onBlockStartBreak(item, X, Y, Z, player);
			if (broken)
				ManaItemHandler.requestManaExactForTool(item, player, MANA_PER_DAMAGE*2, true);
			
			return broken;
		}
		return false;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean par5) 
	{
		if(!world.isRemote && player instanceof EntityPlayer && stack.getItemDamage() > 0 && ManaItemHandler.requestManaExactForTool(stack, (EntityPlayer) player, MANA_PER_DAMAGE * 2, true))
			stack.setItemDamage(stack.getItemDamage() - 1);
	}
	
	@Override
	public boolean usesMana(ItemStack arg0) 
	{
		return true;
	}

}
