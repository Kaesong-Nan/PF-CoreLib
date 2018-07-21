package cn.mgazul.pfcorelib;

import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

import cn.mgazul.pfcorelib.player.PlayerdataAPI;

public class BankAPI {

	  public static Double getBanks(UUID uuid) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);   
			Double money = Config.getDouble("player.playerdata.bank");		
			return money;
	  }
	  
	  public static void addBanks(UUID uuid, Double amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
			Double money = Config.getDouble("player.playerdata.bank");
	    
			money += amount;   
			Config.set("player.playerdata.bank", money);
			PlayerdataAPI.saveYaml(uuid, Config);
	  }
	  
	  public static void removeBanks(UUID uuid, Double amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
			Double money = Config.getDouble("player.playerdata.bank");
	    
			money -= amount; 
			if (getBanks(uuid) - amount > 0) {
					Config.set("player.playerdata.bank", money);
				}else{	
					return;	
			}
			PlayerdataAPI.saveYaml(uuid, Config);
	  }
	  
	  public static void setBanks(UUID uuid, Double amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);   		
	    
			Config.set("player.playerdata.bank", amount);
			PlayerdataAPI.saveYaml(uuid, Config);
	  }
	  
	  public static boolean WithdBank(UUID uuid, Double amount) {
	    Double balance = BankAPI.getBanks(uuid);
	    return balance - amount >= 0;
	  }
}
