package cn.mgazul.pfcorelib;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import cn.mgazul.pfcorelib.player.PlayerdataAPI;

/*
 * 铜钱
 */
public class MoneyAPI {
	
  public static Double getMoneys(String player) {
	  Player p = Bukkit.getPlayer(player);
	  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());   
	  Double money = Config.getDouble("player.playerdata.Moneys");
	    if (Config.getString("player.playerdata.Moneys") == null) {
	        return 0.0D;
	      }
	    
	  return money;
  } 
  
  public static Double getOffMoneys(OfflinePlayer p) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());   
	  Double money = Config.getDouble("player.playerdata.Moneys");
	    if (Config.getString("player.playerdata.Moneys") == null) {
	        return 0.0D;
	      }   
	  return money;
  } 
  
  public static void addMoneys(String player, Double amount) {
	  Player p = Bukkit.getPlayer(player);
	  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());  
	  Double money = Config.getDouble("player.playerdata.Moneys");
    
	  money += amount;   
	  Config.set("player.playerdata.Moneys", money);
	  PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
  } 
  
  public static void addOffMoneys(OfflinePlayer p, Double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());  
	  Double money = Config.getDouble("player.playerdata.Moneys");
    
	  money += amount;   
	  Config.set("player.playerdata.Moneys", money);
	  PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
  } 
  
  public static void removeMoneys(String player, Double amount) {
	  Player p = Bukkit.getPlayer(player);
	  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());  
		Double money = Config.getDouble("player.playerdata.Moneys");
  
		money -= amount; 
		if (getMoneys(player) - amount > 0) {
		Config.set("player.playerdata.Moneys", money);
		}else{	
			return;	
		}
		PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
}
  
  public static void removeOffMoneys(OfflinePlayer p, Double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());  
		Double money = Config.getDouble("player.playerdata.Moneys");
  
		money -= amount; 
		if (getOffMoneys(p) - amount > 0) {
		Config.set("player.playerdata.Moneys", money);
		}else{	
			return;	
		}
		PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
}
  
  public static void setMoneys(String player, Double amount) {
	  Player p = Bukkit.getPlayer(player);
	  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId()); 		
		Config.set("player.playerdata.Moneys", amount);
		PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
  }
  
  public static void setOffMoneys(OfflinePlayer p, Double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId()); 		
		Config.set("player.playerdata.Moneys", amount);
		PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
  }
  
  public static boolean has(String player, Double amount) {
	    Double balance = getMoneys(player);
	    return balance - amount >= 0;
	  }
}
