package cn.mgazul.pfcorelib;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import cn.mgazul.pfcorelib.configuration.ConfigUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class OnlineTimeAPI {
	/*
	 * 在线时间
	 */	
	public static String getFormatTime(UUID uuid)
	  {
	    long sec = getOTime(uuid);
	    int minutes = (int)(sec / 60L);
	    int hours = minutes / 60;
	    int days = hours / 24;
	    
	    Date date = new Date(sec * 1000L);
	    DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    df.setTimeZone(TimeZone.getTimeZone("UTC"));
	    
	    String format = "§c" + days + ":" + df.format(date);
	    format = format.replace(":", "§7:§c");
	    
	    return format;
	  }
	
	  public static int getOTime(UUID uuid) {
		  File file = new File("plugins/"+Msg.PluginName+"/Players", uuid.toString()+".yml");		 
		  FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);   
		  int money = cfg.getInt("player.playerdata.OnlineTime");
		  return money;
	  } 
	  
	  public static void addOTime(UUID uuid, double amount) {
		  File file = new File("plugins/"+Msg.PluginName+"/Players", uuid.toString()+".yml");		
		  FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);    
		  int money = cfg.getInt("player.playerdata.OnlineTime");
	    
		  money += amount;   
		  cfg.set("player.playerdata.OnlineTime", money);
		  cn.mgazul.pfcorelib.configuration.ConfigUtil.fileSave(cfg,file);
	  }
	  
	  public static void setOTime(UUID uuid, double amount) {
		  File file = new File("plugins/"+Msg.PluginName+"/Players", uuid.toString()+".yml");		    
			FileConfiguration Config = YamlConfiguration.loadConfiguration(file);   		
	  
			Config.set("player.playerdata.OnlineTime", amount);
			ConfigUtil.fileSave(Config,file);
	  }
}
