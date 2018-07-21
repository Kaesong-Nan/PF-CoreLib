package cn.mgazul.pfcorelib.player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerdataAPI {
	
	  private static File playerdata;
	  
	  public static void setFolderPath(String path){
	    playerdata = new File(path);
	    if (!playerdata.exists()) {
	      playerdata.mkdirs();
	    }
	  }
	  
	  public static void setFolderPath(File dataFolder, String folderName){
	    playerdata = new File(dataFolder + File.separator + folderName);
	    if (!playerdata.exists()) {
	      playerdata.mkdirs();
	    }
	  }
	  //检查玩家是否有文件
	  public static boolean hasYaml(UUID uuid){
	    return getYaml(uuid) != null;
	  }
	  //正在获取 - 如果它们没有文件，则返回null。
	  public static YamlConfiguration getYaml(UUID uuid){
	    File file = new File(playerdata, uuid.toString() + ".yml");
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	    
	    return !file.exists() ? null : config;
	  }
	  //创建
	  public static YamlConfiguration createYaml(UUID uuid){
	    File file = new File(playerdata, uuid.toString() + ".yml");
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	    saveYaml(uuid, config);
	    
	    return config;
	  }
	  //保存
	  public static boolean saveYaml(UUID uuid, YamlConfiguration config){
	    File file = new File(playerdata, uuid.toString() + ".yml");
	    try
	    {
	      config.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	  }
}
