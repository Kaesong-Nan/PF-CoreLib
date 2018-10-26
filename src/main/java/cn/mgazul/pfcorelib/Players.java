package cn.mgazul.pfcorelib;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class Players {
	
		//临时使用op权限执行指令
	  public static void Command(Player player, String command){
	    if (player.isOp()){
	      player.performCommand(command);
	      return;
	    }
	    player.setOp(true);
	    player.performCommand(command);
	    player.setOp(false);
	  }
	  
	  //获取玩家所在世界名
	  public static String getWorldName(Player p){
	    return p.getLocation().getWorld().getName();
	  }
	  
	  public static void sendDelayedMessage(Player p, String s, int time){
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask()
	    {
	      public void run()
	      {
	        p.sendMessage(s);
	      }
	    }, time);
	  }
	  
	  public static void checkPotionEffects(Player player) {
			for (PotionEffect e : player.getActivePotionEffects()) {
				if (e.getDuration() >= 12000) {
					player.removePotionEffect(e.getType());
				}
			}
		}
		
	  public static void removePotionEffects(Player player) {
			for (PotionEffect e : player.getActivePotionEffects()) {
				if (e.getDuration() >= 12000) {
					player.removePotionEffect(e.getType());
				}
			}
		}
}
