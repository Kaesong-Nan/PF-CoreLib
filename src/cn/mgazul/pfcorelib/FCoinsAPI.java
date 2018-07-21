package cn.mgazul.pfcorelib;

import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

import cn.mgazul.pfcorelib.player.PlayerdataAPI;
 
//获取RMBAPI
public class FCoinsAPI {
	
  public static Double getFCoins(UUID uuid) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);   	  
		Double money = Config.getDouble("player.playerdata.fcoins");	
	    if (Config.getString("player.playerdata.fcoins") == null) {
	        return 0.0;
	      }
		return money; 
  }
  
  public static void addFCoins(UUID uuid, Double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
		Double money = Config.getDouble("player.playerdata.fcoins");
    
		money += amount;   
		Config.set("player.playerdata.fcoins", money);
		PlayerdataAPI.saveYaml(uuid, Config);
  }
  
  public static void removeFCoins(UUID uuid, Double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
		Double money = Config.getDouble("player.playerdata.fcoins");
    
		money -= amount; 
		if (getFCoins(uuid) - amount > 0) {
				Config.set("player.playerdata.fcoins", money);
			}else{	
				return;	
		}
		PlayerdataAPI.saveYaml(uuid, Config);
  }
  
  public static void setFCoins(UUID uuid, Double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);   		
    
		Config.set("player.playerdata.fcoins", amount);
		PlayerdataAPI.saveYaml(uuid, Config);
  }
  
  public static boolean has(UUID uuid, Double amount) {
    Double balance = FCoinsAPI.getFCoins(uuid);
    return balance - amount >= 0;
  }
  
}