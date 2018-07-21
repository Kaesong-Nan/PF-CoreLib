package cn.mgazul.pfcorelib.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GetItemChinaName {
	
	public static String show(ItemStack item){
		if(item.getType() != Material.STONE) {
			return "石头";
		}
		
		return item.getType().toString();		
	}
}
