package cn.mgazul.pfcorelib;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import cn.mgazul.pfcorelib.player.PlayerdataAPI;

public class ConfigUtil {
	
	//保存yaml
	  public static void fileSave(FileConfiguration Config,File file){
	    try{
	      Config.save(file);
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	  }
	  
	  public static void spawn(Player player){
		    File file = new File("plugins/"+Msg.PluginName, "config.yml");
		    if (file.exists()){
		      String world = null;
		      double x = 0.0D;
		      double y = 0.0D;
		      double z = 0.0D;
		      int pitch = 0;
		      int yaw = 0;
		      
		      YamlConfiguration Config = YamlConfiguration.loadConfiguration(file);
		      
		      world = Config.getString("spawn.world");
		      x = Config.getDouble("spawn.x");
		      y = Config.getDouble("spawn.y");
		      z = Config.getDouble("spawn.z");
		      pitch = Config.getInt("spawn.pitch");
		      yaw = Config.getInt("spawn.yaw");
		      
		      player.getLocation().setX(x);
		      player.getLocation().setY(y);
		      player.getLocation().setZ(z);
		      player.getLocation().setPitch(pitch);
		      player.getLocation().setYaw(yaw);		      
		      player.teleport(new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch));
		    }else{
		    	MsgAPI.sendMsgToPlayer(player, Msg.preall + "&cSpawn没有设置,请检查.");
		    }
		  }
		  
		  
		  
		  public static void spawnSet(Player player){
		    File file = new File("plugins/"+Msg.PluginName, "config.yml");	    
		    YamlConfiguration Config = YamlConfiguration.loadConfiguration(file);
		    
		    Config.set("spawn.world", player.getLocation().getWorld().getName());
		    Config.set("spawn.x", Double.valueOf(player.getLocation().getX()));
		    Config.set("spawn.y", Double.valueOf(player.getLocation().getY()));
		    Config.set("spawn.z", Double.valueOf(player.getLocation().getZ()));
		    Config.set("spawn.pitch", Float.valueOf(player.getLocation().getPitch()));
		    Config.set("spawn.yaw", Float.valueOf(player.getLocation().getYaw()));
		    
		    ConfigUtil.fileSave(Config,file);
		    MsgAPI.sendMsgToPlayer(player, Msg.preall + "&2Spawn设置成功.");
		  }
		  
		  public static void create(Player player){		  
		    String uuid = player.getUniqueId().toString();
			File file = new File("plugins/" + Msg.PluginName + "/Players", uuid.toString() + ".yml");
		    Date d = Calendar.getInstance().getTime();
		    DateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		    String date = tm.format(d);
		    
		    Date d1 = Calendar.getInstance().getTime();
		    DateFormat tm1 = new SimpleDateFormat("HH:mm:ss");
		    String time = tm1.format(d1);		    
		    if (!file.exists()){
		    	YamlConfiguration Config = YamlConfiguration.loadConfiguration(file);
			    	Config.set("player.uuid", player.getUniqueId().toString());
			    	Config.set("player.username", player.getName());
			    	Config.set("player.ip", player.getAddress().getHostString());
			    	Config.set("player.first_join.time", date+" "+time);
			    	Config.set("player.first_join.int.Long", Long.valueOf(player.getFirstPlayed()));	    	
			    	Config.set("player.playerdata.fcoins", 0);
			    	Config.set("player.playerdata.Moneys", 0);
			    	Config.set("player.playerdata.MaxHeal", 0);
			    	Config.set("player.playerdata.heal", 0);
			    	Config.set("player.playerdata.exp", 0);
			    	Config.set("player.playerdata.level", 0);
			    	Config.set("player.playerdata.OnlineTime", 0);
			    	Config.set("player.playerdata.HomeSize", 0);
			    	Config.set("player.playerdata.HomeMaxSize", 5);
			    	Config.set("HomeWorld.isjoinhw", 0);
			    	fileSave(Config, file);
			    	try {
			    		fileSave(Config, file);
			    	MsgAPI.Debug("§6成功创建 " + player.getUniqueId().toString() + " 数据文件");
			    	} catch (Exception e) {
			    	MsgAPI.Debug("§c创建配置 " + player.getUniqueId().toString() + " 数据失败!");
			        }
		        }
		    }
		  
		  public static void teleport(Player player, Location location){
		      Double X = Double.valueOf(location.getX());
		      Double Y = Double.valueOf(location.getY());
		      Double Z = Double.valueOf(location.getZ());
		      World World = location.getWorld();
		      for (int i = 0; i <= 256.0D - Y.doubleValue(); ) {
		        location = new Location(World, X.doubleValue(), Y.doubleValue() + i, Z.doubleValue());
		        if (location.getBlock().isEmpty()) {
		          location = new Location(World, X.doubleValue(), Y.doubleValue() + i + 1.0D, Z.doubleValue());
		          if (location.getBlock().isEmpty()) {
		            if (i == 0) {
		              for (int l = 1; l <= Y.doubleValue(); ) {
		                location = new Location(World, X.doubleValue(), Y.doubleValue() - l, Z.doubleValue());
		                if (location.getBlock().isEmpty()) {
		                  l++;
		                } else {
		                  Y = Double.valueOf(Y.doubleValue() - l + 1.0D);
		                  break;
		                }
		              }
		            }
		            Y = Double.valueOf(Y.doubleValue() + i + 0.1D);
		            location = new Location(World, X.doubleValue(), Y.doubleValue(), Z.doubleValue());
		            i = 500;
		          } else {
		            i += 2;
		          }
		        } else {
		          i++;
		        }
		    }
		    player.teleport(location);
		  }

		  public static void playerJoinJail(Player player, Location location) {
		    double jailX = Main.plugin.getConfig().getDouble("jail.location.X") + 0.5D;
		    double jailY = Main.plugin.getConfig().getDouble("jail.location.Y");
		    double jailZ = Main.plugin.getConfig().getDouble("jail.location.Z") + 0.5D;
		    World jailWorld = Bukkit.getWorld(Main.plugin.getConfig().getString("jail.location.World"));
		    Location jail = new Location(jailWorld, jailX, jailY, jailZ);
		    teleport(player, jail);
		  }

		  public static void playerTeleportJail(Player player) {
			    double jailX = Main.plugin.getConfig().getDouble("jail.location.X") + 0.5D;
			    double jailY = Main.plugin.getConfig().getDouble("jail.location.Y");
			    double jailZ = Main.plugin.getConfig().getDouble("jail.location.Z") + 0.5D;
			    World jailWorld = Bukkit.getWorld(Main.plugin.getConfig().getString("jail.location.World"));
			    Location jail = new Location(jailWorld, jailX, jailY, jailZ);
		    teleport(player, jail);
		    player.sendMessage(Msg.wanted+" §7请老老实实的等待释放！");
		  }

		  public static void setplayerDeathLocation(Player player){
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
			    Config.set("DeathLoc.world", player.getLocation().getWorld().getName());
			    Config.set("DeathLoc.x", Double.valueOf(player.getLocation().getX()));
			    Config.set("DeathLoc.y", Double.valueOf(player.getLocation().getY()));
			    Config.set("DeathLoc.z", Double.valueOf(player.getLocation().getZ()));
			    Config.set("DeathLoc.pitch", Float.valueOf(player.getLocation().getPitch()));
			    Config.set("DeathLoc.yaw", Float.valueOf(player.getLocation().getYaw()));
			    PlayerdataAPI.saveYaml(player.getUniqueId(), Config);
			  }
		  
		  public static void getplayerDeathLocation(Player player) {
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
		    double playerX = Config.getDouble("DeathLoc.x");
		    double playerY = Config.getDouble("DeathLoc.y");
		    double playerZ = Config.getDouble("DeathLoc.z");
		    float pitch = Config.getInt("DeathLoc.pitch");
		    float  yaw = Config.getInt("DeathLoc.yaw");		      
		    String playerWorld = Config.getString("DeathLoc.world");
		    player.teleport(new Location(Bukkit.getWorld(playerWorld), playerX, playerY, playerZ, yaw, pitch));
		  }
		  
		  public static void setplayerHome(Player player, String name){
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
			    Config.set("Home." + String.valueOf(name) + ".world", player.getLocation().getWorld().getName());
			    Config.set("Home." + String.valueOf(name) + ".x", Double.valueOf(player.getLocation().getX()));
			    Config.set("Home." + String.valueOf(name) + ".y", Double.valueOf(player.getLocation().getY()));
			    Config.set("Home." + String.valueOf(name) + ".z", Double.valueOf(player.getLocation().getZ()));
			    Config.set("Home." + String.valueOf(name) + ".pitch", Float.valueOf(player.getLocation().getPitch()));
			    Config.set("Home." + String.valueOf(name) + ".yaw", Float.valueOf(player.getLocation().getYaw()));
			    PlayerdataAPI.saveYaml(player.getUniqueId(), Config);
			  }
		  
		  public static void getplayerHome(Player player, String name) {
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
			  	double playerX = Config.getDouble("Home." + String.valueOf(name) + ".x");
			  	double playerY = Config.getDouble("Home." + String.valueOf(name) + ".y");
			  	double playerZ = Config.getDouble("Home." + String.valueOf(name) + ".z");
			  	float pitch = Config.getInt("Home." + String.valueOf(name) + ".pitch");
			  	float  yaw = Config.getInt("Home." + String.valueOf(name) + ".yaw");		      
			  	String playerWorld = Config.getString("Home." + String.valueOf(name) + ".world");
			  player.teleport(new Location(Bukkit.getWorld(playerWorld), playerX, playerY, playerZ, yaw, pitch));
		  }
		  
		  public static int getplayerHomesize(Player player) {
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId()); 
			  	int size = Config.getInt("player.playerdata.HomeSize");
			  	return size;
		  }
		  
		  public static int getplayerHomeMaxsize(Player player) {
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId()); 
			  	int size = Config.getInt("player.playerdata.HomeMaxSize");
			  	return size;
		  }
		  
		  public static void setplayerHomesize(Player player, Double size){
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
			  Double money = Config.getDouble("player.playerdata.HomeSize");				    
				   money += size;   
		      Config.set("player.playerdata.HomeSize", money);
			  PlayerdataAPI.saveYaml(player.getUniqueId(), Config);
			  }
		  
		  public static void setplayerHomeMaxsize(Player player, Double size){
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());		    
			  Double money = Config.getDouble("player.playerdata.HomeMaxSize");				    
				   money += size;   
		      Config.set("player.playerdata.HomeMaxSize", money);
			  PlayerdataAPI.saveYaml(player.getUniqueId(), Config);
		  }
		  
		  public static void removeHomesize(Player player, Double amount) {
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());  
				Double money = Config.getDouble("player.playerdata.HomeSize");
		  
				money -= amount; 
				if (getplayerHomesize(player) - amount > 0) {
				Config.set("player.playerdata.HomeSize", money);
				}else{	
					return;	
				}
				PlayerdataAPI.saveYaml(player.getUniqueId(), Config);
		  }
		  
		  public static void removeHomeMaxsize(Player player, Double amount) {
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());  
				Double money = Config.getDouble("player.playerdata.HomeMaxSize");
		  
				money -= amount; 
				if (getplayerHomesize(player) - amount > 0) {
				Config.set("player.playerdata.HomeMaxSize", money);
				}else{	
					return;	
				}
				PlayerdataAPI.saveYaml(player.getUniqueId(), Config);
		  }


		  public static void playerSetJail(Player player) {
		    int playerX = player.getLocation().getBlockX();
		    int playerY = player.getLocation().getBlockY();
		    int playerZ = player.getLocation().getBlockZ();
		    String playerWorld = player.getWorld().getName();
		    Main.plugin.getConfig().set("jail.location.X", Integer.valueOf(playerX));
		    Main.plugin.getConfig().set("jail.location.Y", Integer.valueOf(playerY));
		    Main.plugin.getConfig().set("jail.location.Z", Integer.valueOf(playerZ));
		    Main.plugin.getConfig().set("jail.location.World", playerWorld);
		    Main.plugin.saveConfig();
		    player.sendMessage(Msg.wanted+" §7监狱设置成功");
		  }

		  public static Boolean isJailPlayer(Player player) {
			  YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
		    int playerJailPoints = Config.getInt("jail.times");
		    if (playerJailPoints > 0) {
		      return Boolean.valueOf(true);
		    }
		    return Boolean.valueOf(false);
		  }
		  
			public static String marryPrefix(Player player){
				YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
			    if (Config.getString("player.isMarried") != null) {
			      return "§c§l<3§f ";
			    }
			    return "";
			  }
			
			//前缀
			public static String PlayerPrefix(Player player){
				YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
			    if (Config.getString("player.Prefix") != null) {
			    return Config.getString("player.Prefix").replace("&", "§");
			    }
				return "";
			  }
			//后缀
			public static String PlayerSuffix(Player player){
				YamlConfiguration Config = PlayerdataAPI.createYaml(player.getUniqueId());
			    if (Config.getString("player.Suffix") != null) {
			    return Config.getString("player.Suffix").replace("&", "§");
			    }
				return "";
			  }
			
			public static void setWarp(String warpName, Location location){
			    Main.plugin.getConfig().set("warps."+warpName + ".World", location.getWorld().getName());
			    Main.plugin.getConfig().set("warps."+warpName + ".X", Double.valueOf(location.getX()));
			    Main.plugin.getConfig().set("warps."+warpName + ".Y", Double.valueOf(location.getY()));
			    Main.plugin.getConfig().set("warps."+warpName + ".Z", Double.valueOf(location.getZ()));
			    Main.plugin.getConfig().set("warps."+warpName + ".Yaw", Float.valueOf(location.getYaw()));
			    Main.plugin.getConfig().set("warps."+warpName + ".Pitch", Float.valueOf(location.getPitch()));
			    Main.plugin.saveConfig();
			  }
			
			public static void removeWarp(String warp) {
				  Main.plugin.getConfig().set("warps."+warp , null);
				  Main.plugin.saveConfig();
			  }
			
			public static Set<String> listWarps(){
				Set<String> warps = Main.plugin.getConfig().getConfigurationSection("warps").getKeys(false);
				return warps;
			  }			
			
			public static void teleportWarp(Player player, String warpName){
			    double playerX = Main.plugin.getConfig().getDouble("warps."+warpName + ".X");
			    double playerY = Main.plugin.getConfig().getDouble("warps."+warpName + ".Y");
			    double playerZ = Main.plugin.getConfig().getDouble("warps."+warpName + ".Z");
			    float pitch = (float) Main.plugin.getConfig().getDouble("warps."+warpName + ".Pitch");
			    float  yaw = (float) Main.plugin.getConfig().getDouble("warps."+warpName + ".Yaw");		      
			    String playerWorld = Main.plugin.getConfig().getString("warps."+warpName + ".World");
		    	if(playerWorld==null) {
		    		MsgAPI.sendMsgToPlayer(player, "&c该位置不存在");
		    		return;
		    	}
			    player.teleport(new Location(Bukkit.getWorld(playerWorld), playerX, playerY, playerZ, yaw, pitch));
			    	
			  }

}
