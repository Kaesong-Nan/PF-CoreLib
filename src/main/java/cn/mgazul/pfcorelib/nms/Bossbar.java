package cn.mgazul.pfcorelib.nms;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class Bossbar {

	/**个人可见
	 *  color > 设置血条颜色  BarColor.
	 *  style > 血条样式
	 *  flag  >  3种属性
	 */
    public void createBossBar(Player p, String message, BarColor color, BarStyle style, BarFlag flag) {
        BossBar bar = Bukkit.createBossBar(message.replaceAll("&", "§"), color, style, new BarFlag[] { flag });
        bar.addPlayer(p);
    }
    
    //所有人可见
    public void createBossBarForAll(String message, BarColor color, BarStyle style, BarFlag flag) {
        BossBar bar = Bukkit.createBossBar(message.replaceAll("&", "§"), color, style, new BarFlag[] { flag });
        for (Player all : Bukkit.getOnlinePlayers()) {
            bar.addPlayer(all);
        }
    }
}
