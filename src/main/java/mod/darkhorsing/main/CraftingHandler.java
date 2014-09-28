package mod.darkhorsing.main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import mod.darkhorsing.main.DarkHorsing;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
				
		//if (item.itemID == DarkHorsing.Withered_Bone.itemID)
	//	{
		//player.addStat(DarkHorsing.Infernal_Whisperer, 1);
		//}
				
		//-=-


	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {

	}

}
