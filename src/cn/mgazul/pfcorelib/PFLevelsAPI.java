package cn.mgazul.pfcorelib;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import cn.mgazul.pfcorelib.player.PlayerdataAPI;

public class PFLevelsAPI {

	  public static Double getPFLevels(String player) {
		  Player p = Bukkit.getPlayer(player);
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());   
		  Double money = Config.getDouble("player.playerdata.PFLevels");
		    if (Config.getString("player.playerdata.PFLevels") == null) {
		        return 0.0D;
		      }
		    
		  return money;
	  } 
	  
	  public static Double getOffPFLevels(OfflinePlayer p) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());   
		  Double money = Config.getDouble("player.playerdata.PFLevels");
		    if (Config.getString("player.playerdata.PFLevels") == null) {
		        return 0.0D;
		      }   
		  return money;
	  } 
	  
	  public static void addPFLevels(String player, Double amount) {
		  Player p = Bukkit.getPlayer(player);
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());  
		  Double money = Config.getDouble("player.playerdata.PFLevels");
	    
		  money += amount;   
		  Config.set("player.playerdata.Moneys", money);
		  PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	  } 
	  
	  public static void addOffPFLevels(OfflinePlayer p, Double amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());  
		  Double money = Config.getDouble("player.playerdata.PFLevels");
	    
		  money += amount;   
		  Config.set("player.playerdata.PFLevels", money);
		  PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	  } 
	  
	  public static void removePFLevels(String player, Double amount) {
		  Player p = Bukkit.getPlayer(player);
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());  
			Double money = Config.getDouble("player.playerdata.PFLevels");
	  
			money -= amount; 
			if (getPFLevels(player) - amount > 0) {
			Config.set("player.playerdata.PFLevels", money);
			}else{	
				return;	
			}
			PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	}
	  
	  public static void removeOffPFLevels(OfflinePlayer p, Double amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());  
			Double money = Config.getDouble("player.playerdata.PFLevels");
	  
			money -= amount; 
			if (getOffPFLevels(p) - amount > 0) {
			Config.set("player.playerdata.PFLevels", money);
			}else{	
				return;	
			}
			PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	}
	  
	  public static void setPFLevels(String player, Double amount) {
		  Player p = Bukkit.getPlayer(player);
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId()); 		
			Config.set("player.playerdata.PFLevels", amount);
			PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	  }
	  
	  public static void setOffPFLevels(OfflinePlayer p, Double amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId()); 		
			Config.set("player.playerdata.PFLevels", amount);
			PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	  }
}
