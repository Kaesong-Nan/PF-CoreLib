package cn.mgazul.pfcorelib;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import cn.mgazul.pfcorelib.player.PlayerdataAPI;

public class JobAPI {
	
	  //获取职业-null返回无
	  public static String getJobs(String p) {
		  Player player = Bukkit.getServer().getPlayer(p);
		  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());   
		  String Job = Config.getString("player.playerdata.Jobs");
		    if (Config.getString("player.playerdata.Jobs") == null) {
		        return "无";
		      }		    
		  return Job;
	  } 
	  
	  //设置职业
	  public static void setJobs(String player, String job) {
		  Player p = Bukkit.getServer().getPlayer(player);
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId()); 		
		  Config.set("player.playerdata.Jobs", job);
		  PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	  }
	  
	  //重置职业
	  public static void resetJobs(String player) {
		  Player p = Bukkit.getServer().getPlayer(player);
		  YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId()); 		
		  Config.set("player.playerdata.Jobs", null);
		  PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	  }
}
