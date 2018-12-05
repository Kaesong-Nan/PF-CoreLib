package cn.mgazul.pfcorelib;

import cn.mgazul.pfcorelib.configuration.PlayerdataAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.UUID;
 
//获取RMBAPI
public class FCoinsAPI {
	
  public static Double getFCoins(UUID uuid) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);   	  
		double money = Config.getDouble("player.playerdata.fcoins");
	    if (Config.getString("player.playerdata.fcoins") == null) {
	        return 0.0;
	      }
		return money; 
  }
  
  public static void addFCoins(UUID uuid, double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
		double money = Config.getDouble("player.playerdata.fcoins");
    
		money += amount;   
		Config.set("player.playerdata.fcoins", money);
		PlayerdataAPI.saveYaml(uuid, Config);
  }
  
  public static void removeFCoins(UUID uuid, double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
		double money = Config.getDouble("player.playerdata.fcoins");
    
		money -= amount; 
		if (getFCoins(uuid) - amount > 0) {
				Config.set("player.playerdata.fcoins", money);
			}else{	
				return;	
		}
		PlayerdataAPI.saveYaml(uuid, Config);
  }
  
  public static void setFCoins(UUID uuid, double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);   		
    
		Config.set("player.playerdata.fcoins", amount);
		PlayerdataAPI.saveYaml(uuid, Config);
  }
  
}