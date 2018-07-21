package cn.mgazul.pfcorelib;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MsgAPI {

	  //在线op
	  public static void sendOPMessage(String msg){
	    for (Player a : Bukkit.getOnlinePlayers()) {
	    	if(a==null) return;
	      if (a.isOp()) {
	        a.sendMessage(msg.replace("&", "§"));
	      }
	    }
	  }
	  //在线玩家拥有指定权限
	  public static void sendPerMessage(String Permission, String msg){
	    for (Player a : Bukkit.getOnlinePlayers()) {
	    	if(a==null) return;
	      if (a.hasPermission(Permission)) {
	        a.sendMessage(msg.replace("&", "§"));
	      }
	    }
	  }	  
	  //后台日志bukkit
	  public static void Debug(String msg){	  
		  Bukkit.getConsoleSender().sendMessage(msg.replace("&", "§"));
	  }
	  //后台日志java
	  public static void logToConsole(String msg){
	      System.out.println(msg.replace("&", "§"));
	  }
	  //公告-后台、玩家可见
	  public static void broadcast(String msg){
	      Bukkit.getServer().broadcastMessage(msg.replace("&", "§"));
	  }
	  //所有在线玩家可见信息-聊天框
	  public static void sendOlMessage(String msg){
		    for (Player a : Bukkit.getOnlinePlayers()) {
		    	if(a==null) return;
		        a.sendMessage(msg.replace("&", "§"));
		      }
	  }
	  //发送给玩家
	  public static void sendMsgToPlayer(Player p, String msg){
	    p.sendMessage(msg.replace("&", "§"));
	  }
	  
	  //普通彩色文本信息
	  public static String colormsg(String msg){	  
	    return msg.replace("&", "§");
	  }
}
