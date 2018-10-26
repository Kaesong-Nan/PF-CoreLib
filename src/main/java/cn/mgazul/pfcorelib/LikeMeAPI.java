package cn.mgazul.pfcorelib;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import cn.mgazul.pfcorelib.configuration.PlayerdataAPI;

public class LikeMeAPI {

	public void setLikeMe(UUID uuid, UUID uuid1) {
		 YamlConfiguration Config = PlayerdataAPI.createYaml(uuid); 
		 YamlConfiguration Config1 = PlayerdataAPI.createYaml(uuid1); 	
		 Player p =Bukkit.getPlayer(uuid);
		 Player p1 =Bukkit.getPlayer(uuid1);
		 List<String> list = (List<String>)Config.getStringList(p1.getName());
	        final List<String> list1 = (List<String>)Config.getStringList(p.getName());
	        for (final String look : list1) {
	            if (look.equals(p1.getName())) {
	            	 p.sendMessage("§7§l[§a点赞§7§l]§c不能再赞同一个玩家了");
	                return;
	            }
	        }
		 //别人
		 int numberGet = Config1.getInt(String.valueOf(p1.getName()) + ".getLike");
		 Config1.set(String.valueOf(p1.getName()) + ".getLike", numberGet + 1);
		 p1.sendMessage("§7§l[§a点赞§7§l]§c1");
		 //自己
		 int numberGive = Config.getInt(String.valueOf(p.getName()) + ".giveLike");
		 Config.set(String.valueOf(p.getName()) + ".giveLike", numberGive + 1);
		 Config.set(String.valueOf(p.getName()) + ".list", list);
		 p.sendMessage("§7§l[§a点赞§7§l]§c2");
		 
		 PlayerdataAPI.saveYaml(uuid, Config);
		 PlayerdataAPI.saveYaml(uuid1, Config1);
	}
	
	public void setmdr(UUID uuid) {
		 YamlConfiguration Config = PlayerdataAPI.createYaml(uuid); 
		 Player p =Bukkit.getPlayer(uuid);
		 if(Config.getString("player.LikeMe.message") != null) {
			 Config.set("player.LikeMe.message", true);
		 }
		 if(Config.getBoolean("player.LikeMe.message")) {
			 Config.set("player.LikeMe.message", false);
			 p.sendMessage("§7§l[§a点赞§7§l]§6 已开启防打扰模式");
		 }else {
			 Config.set("player.LikeMe.message", true);
			 p.sendMessage("§7§l[§a点赞§7§l]§6 已取消防打扰模式");
		 }
		 PlayerdataAPI.saveYaml(uuid, Config);
	}
}
