package cn.mgazul.pfcorelib.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import cn.mgazul.pfcorelib.Msg;

public class ItemAPI {

	public static boolean checkPex(Player player, String pex){
	    if (!player.hasPermission(pex)){
	      player.sendMessage(Msg.Nocmd);
	      return false;
	    }
	    return true;
	  }
	  
	public static boolean checkItemInMainHand(Player player){
	    ItemStack item = player.getInventory().getItemInMainHand();
	    if ((item != null) && (item.getType() != Material.AIR)) {
	      return true;
	    }
	    player.sendMessage(Msg.error+"主手没有任何东西!");
	    return false;
	  }
	
	public static boolean checkItemInOffHand(Player player){
	    ItemStack item = player.getInventory().getItemInOffHand();
	    if ((item != null) && (item.getType() != Material.AIR)) {
	      return true;
	    }
	    player.sendMessage(Msg.error+"副手没有任何东西!");
	    return false;
	  }
	  
	public static boolean checkPotionInHand(Player player){
	    ItemStack item = player.getInventory().getItemInMainHand();
	    if ((item != null) && ((item.getType() == Material.POTION) || (item.getType() == Material.SPLASH_POTION) || (item.getType() == Material.LINGERING_POTION))) {
	      return true;
	    }
	    player.sendMessage("Get a POTION in your hand!");
	    return false;
	  }
	  
	public static boolean checkBookInHand(Player player){
	    ItemStack item = player.getInventory().getItemInMainHand();
	    if ((item != null) && (item.getType() == Material.WRITTEN_BOOK)) {
	      return true;
	    }
	    player.sendMessage("Get a WRITEN_BOOK in your hand!");
	    return false;
	  }
	  
	//public static boolean checkSkullInHand(Player player){
	  //  ItemStack item = player.getInventory().getItemInMainHand();
	//    if ((item != null) && (item.getType() == Material.SKULL_ITEM) && (item.getDurability() == 3)) {
	  //    return true;
	  //  }
	  //  player.sendMessage("Get a SKULL in your hand!");
	  //  return false;
	 // }
	
}
