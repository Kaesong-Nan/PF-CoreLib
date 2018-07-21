package cn.mgazul.pfcorelib.world;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

import cn.mgazul.pfcorelib.ConfigUtil;
import cn.mgazul.pfcorelib.MsgAPI;

public class WorldWrapper {

	//加载世界
	public static boolean load(String name, Player player) {  
	    File fileNew = new File(name);
	    if (fileNew.exists()){
	    	MsgAPI.sendMsgToPlayer(player, "&e加载世界中...");
	    	World world = Bukkit.getServer().createWorld(new WorldCreator(name));
	    	MsgAPI.sendMsgToPlayer(player, "&e加载世界: " + world.getName());
	    	return true;
	    	}
	    MsgAPI.sendMsgToPlayer(player, "&c"+fileNew.getName() + " 不存在");
	    return false;
	  }
	 //卸载世界
	public static void unload(String worldname) {  
	      if (Bukkit.getServer().getWorld(worldname) == null){
	        return;
	      }
	      if (Bukkit.getServer().getWorld(worldname).getPlayers().size() > 0){
	  		World w = Bukkit.getWorld(worldname);
	  		for (Player a : w.getPlayers()) {
	  			ConfigUtil.spawn(a);
	  			a.setGameMode(GameMode.SURVIVAL);
	  		} 
	      }    
	      Bukkit.unloadWorld(worldname, true);
	  }
	 
	public World CreateWorld(String WorldName, Player player, String worldtype, String generatestructures){
	    MsgAPI.sendMsgToPlayer(player, "&e创建世界...");
	    if (WorldName == null) {
	      WorldName = "PF_world";
	    }
	    WorldType type;
	    if (worldtype == "0"){
	      type = WorldType.AMPLIFIED;
	    }else{
	      if (worldtype == "1"){
	        type = WorldType.FLAT;
	      }else{
	        if (worldtype == "2"){
	          type = WorldType.LARGE_BIOMES;
	        }else{
	          if (worldtype == "3") {
	            type = WorldType.NORMAL;
	          } else {
	            type = WorldType.NORMAL;
	          }
	        }
	      }
	    }
	    boolean generateStructures;
	    if (generatestructures == "0"){
	      generateStructures = true;
	    }else{
	      if (generatestructures == "1") {
	        generateStructures = false;
	      } else {
	        generateStructures = true;
	      }
	    }
	    WorldCreator c = new WorldCreator(WorldName);
	    c.generateStructures(generateStructures);
	    World newWorld = c.createWorld();
	    player.getPlayer().teleport(newWorld.getSpawnLocation());
	    MsgAPI.sendMsgToPlayer(player,  "&2You are now in: " + WorldName + " With the world type of: " + type.getName() + " Which has been newly created!");
	    return newWorld;
	  }
	
	  public static List<String> getWorldInfo(World world){
		    List<String> lines = new ArrayList<String>();    
		    lines.add("§9世界名字: §7" + world.getName());
		    lines.add("§9UID: §7" + world.getUID());
		    lines.add("§9类型: §7" + world.getWorldType().getName());
		    lines.add("§9种子: §7" + world.getSeed());
		    lines.add("§9难度: §7" + world.getDifficulty().name());
		    lines.add("§9最大高度: §7" + world.getMaxHeight() + " blocks");
		    lines.add("§9加载区块: §7" + world.getLoadedChunks().length);
		    lines.add("§9实体总数: §7" + world.getLivingEntities().size());
		    lines.add("§9玩家数: §7" + world.getPlayers().size());
		    
		    return lines;
		  }
}
