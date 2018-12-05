package cn.mgazul.pfcorelib.rpg;

import cn.mgazul.pfcorelib.configuration.PlayerdataAPI;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ExpAPI {
	
	//每级升级所需经验=floor(((等级-1)^3+60)/5*((等级-1)*2+60,50)	
	  public static int level1 = 40;
	  public static int level2 = 110;
	  public static int level3 = 237;
	  public static int level4 = 450;
	  public static int level5 = 779;
	  public static int level6 = 1252;
	  public static int level7 = 1898;
	  public static int level8 = 2745;
	  public static int level9 = 3822;
	  public static int level10 = 5159;
	  public static int level11 = 6784;
	  public static int level12 = 8726;
	  public static int level13 = 11013;
	  public static int level14 = 13674;
	  public static int level15 = 16739;
	  public static int level16 = 20236;
	  public static int level17 = 24194;
	  public static int level18 = 28641;
	  public static int level19 = 33606;
	  public static int level20 = 39119;
	  public static int level21 = 45208;
	  public static int level22 = 51902;
	  public static int level23 = 55229;
	  public static int level24 = 67218;
	  public static int level25 = 75899;
	  public static int level26 = 85300;
	  public static int level27 = 95450;
	  public static int level28 = 106377;
	  public static int level29 = 118110;
	  public static int level30 = 130679;
	  public static int level31 = 144112;
	  public static int level32 = 158438;
	  public static int level33 = 173685;
	  public static int level34 = 189882;
	  public static int level35 = 207059;
	  public static int level36 = 225244;
	  public static int level37 = 244466;
	  public static int level38 = 264753;
	  public static int level39 = 286134;
	  public static int level40 = 308639;
	  public static int levels1 = 40;
	  public static int levels2 = 150;
	  public static int levels3 = 387;
	  public static int levels4 = 837;
	  public static int levels5 = 1616;
	  public static int levels6 = 2868;
	  public static int levels7 = 4766;
	  public static int levels8 = 7511;
	  public static int levels9 = 11333;
	  public static int levels10 = 16492;
	  public static int levels11 = 23276;
	  public static int levels12 = 32002;
	  public static int levels13 = 43015;
	  public static int levels14 = 56689;
	  public static int levels15 = 73428;
	  public static int levels16 = 93664;
	  public static int levels17 = 117858;
	  public static int levels18 = 146449;
	  public static int levels19 = 180105;
	  public static int levels20 = 219224;
	  public static int levels21 = 264432;
	  public static int levels22 = 316334;
	  public static int levels23 = 375563;
	  public static int levels24 = 442781;
	  public static int levels25 = 518680;
	  public static int levels26 = 603980;
	  public static int levels27 = 699430;
	  public static int levels28 = 805807;
	  public static int levels29 = 923917;
	  public static int levels30 = 1054596;
	  public static int levels31 = 1198708;
	  public static int levels32 = 1357146;
	  public static int levels33 = 1530831;
	  public static int levels34 = 1720713;
	  public static int levels35 = 1927772;
	  public static int levels36 = 2153016;
	  public static int levels37 = 2397482;
	  public static int levels38 = 2662235;
	  public static int levels39 = 2948369;
	  public static int levels40 = 3257008;
	  
	  public static int getExp(Player p)
	  {
	    YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());
	    int money = Config.getInt("player.playerdata.exp");
	    if (Config.getString("player.playerdata.exp") == null) {
	      return 0;
	    }
	    return money;
	  }
	  
	  public static void addExp(Player p, int amount)
	  {
	    YamlConfiguration Config = PlayerdataAPI.createYaml(p.getUniqueId());
	    int money = Config.getInt("player.playerdata.exp");
	    int money1 = money + amount;
	    if (money + amount < levels1)
	    {
	      p.setLevel(0);
	      p.setExp((money + amount) / level1);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels1) && (money + amount < levels2))
	    {
	      p.setLevel(1);
	      p.setExp((money + amount - levels1) / level1);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels2) && (money + amount < levels3))
	    {
	      p.setLevel(2);
	      p.setExp((money + amount - levels2) / level2);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels3) && (money + amount < levels4))
	    {
	      p.setLevel(3);
	      p.setExp((money + amount - levels3) / level3);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels4) && (money + amount < levels5))
	    {
	      p.setLevel(4);
	      p.setExp((money + amount - levels4) / level4);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels5) && (money + amount < levels6))
	    {
	      p.setLevel(5);
	      p.setExp((money + amount - levels5) / level5);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels6) && (money + amount < levels7))
	    {
	      p.setLevel(6);
	      p.setExp((money + amount - levels6) / level6);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels7) && (money + amount < levels8))
	    {
	      p.setLevel(7);
	      p.setExp((money + amount - levels7) / level7);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels8) && (money + amount < levels9))
	    {
	      p.setLevel(8);
	      p.setExp((money + amount - levels8) / level8);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels9) && (money + amount < levels10))
	    {
	      p.setLevel(9);
	      p.setExp((money + amount - levels9) / level9);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels10) && (money + amount < levels11))
	    {
	      p.setLevel(10);
	      p.setExp((money + amount - levels10) / level10);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels11) && (money + amount < levels12))
	    {
	      p.setLevel(11);
	      p.setExp((money + amount - levels11) / level11);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels12) && (money + amount < levels13))
	    {
	      p.setLevel(12);
	      p.setExp((money + amount - levels12) / level12);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels13) && (money + amount < levels14))
	    {
	      p.setLevel(13);
	      p.setExp((money + amount - levels13) / level13);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels14) && (money + amount < levels15))
	    {
	      p.setLevel(14);
	      p.setExp((money + amount - levels14) / level14);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels15) && (money + amount < levels16))
	    {
	      p.setLevel(15);
	      p.setExp((money + amount - levels15) / level15);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels16) && (money + amount < levels17))
	    {
	      p.setLevel(16);
	      p.setExp((money + amount - levels16) / level16);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels17) && (money + amount < levels18))
	    {
	      p.setLevel(17);
	      p.setExp((money + amount - levels17) / level17);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels18) && (money + amount < levels19))
	    {
	      p.setLevel(18);
	      p.setExp((money + amount - levels18) / level18);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels19) && (money + amount < levels20))
	    {
	      p.setLevel(19);
	      p.setExp((money + amount - levels19) / level19);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels20) && (money + amount < levels21))
	    {
	      p.setLevel(20);
	      p.setExp((money + amount - levels20) / level20);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels21) && (money + amount < levels22))
	    {
	      p.setLevel(21);
	      p.setExp((money + amount - levels21) / level21);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels22) && (money + amount < levels23))
	    {
	      p.setLevel(22);
	      p.setExp((money + amount - levels22) / level22);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels23) && (money + amount < levels24))
	    {
	      p.setLevel(23);
	      p.setExp((money + amount - levels23) / level23);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels24) && (money + amount < levels25))
	    {
	      p.setLevel(24);
	      p.setExp((money + amount - levels24) / level24);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels25) && (money + amount < levels26))
	    {
	      p.setLevel(25);
	      p.setExp((money + amount - levels25) / level25);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels26) && (money + amount < levels27))
	    {
	      p.setLevel(26);
	      p.setExp((money + amount - levels26) / level26);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels27) && (money + amount < levels28))
	    {
	      p.setLevel(27);
	      p.setExp((money + amount - levels27) / level27);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels28) && (money + amount < levels29))
	    {
	      p.setLevel(28);
	      p.setExp((money + amount - levels28) / level28);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels29) && (money + amount < levels30))
	    {
	      p.setLevel(29);
	      p.setExp((money + amount - levels29) / level29);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels30) && (money + amount < levels31))
	    {
	      p.setLevel(30);
	      p.setExp((money + amount - levels30) / level30);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels31) && (money + amount < levels32))
	    {
	      p.setLevel(31);
	      p.setExp((money + amount - levels31) / level31);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels32) && (money + amount < levels33))
	    {
	      p.setLevel(32);
	      p.setExp((money + amount - levels32) / level32);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels33) && (money + amount < levels34))
	    {
	      p.setLevel(33);
	      p.setExp((money + amount - levels33) / level33);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels34) && (money + amount < levels35))
	    {
	      p.setLevel(34);
	      p.setExp((money + amount - levels34) / level34);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels35) && (money + amount < levels36))
	    {
	      p.setLevel(35);
	      p.setExp((money + amount - levels35) / level35);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels36) && (money + amount < levels37))
	    {
	      p.setLevel(36);
	      p.setExp((money + amount - levels36) / level36);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels37) && (money + amount < levels38))
	    {
	      p.setLevel(37);
	      p.setExp((money + amount - levels37) / level37);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels38) && (money + amount < levels39))
	    {
	      p.setLevel(38);
	      p.setExp((money + amount - levels38) / level38);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels39) && (money + amount < levels40))
	    {
	      p.setLevel(39);
	      p.setExp((money + amount - levels39) / level39);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if ((money + amount >= levels40) && (p.getLevel() < 40))
	    {
	      p.setLevel(40);
	      p.setExp((money + amount - levels40) / level40);
	      Config.set("player.playerdata.exp", Integer.valueOf(money1));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	    if (p.getLevel() == 40)
	    {
	      p.setExp(0.0F);
	      Config.set("player.playerdata.exp", Integer.valueOf(money));
	      PlayerdataAPI.saveYaml(p.getUniqueId(), Config);
	    }
	  }
	 
	  
	  public static void setExp(UUID uuid, int amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  		
	    
			Config.set("player.playerdata.exp", amount);
			PlayerdataAPI.saveYaml(uuid, Config);
	  }
	  
	  public static int getlevel(UUID uuid) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
			int money = Config.getInt("player.playerdata.level");		
			if(Config.getString("player.playerdata.level") == null) {
				return 0;
			}
			return money;
	  }
	  
	  public static void addlevel(UUID uuid, int amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);   
			int money = Config.getInt("player.playerdata.level");
	    
			money += amount;   
			Config.set("player.playerdata.level", money);
			PlayerdataAPI.saveYaml(uuid, Config);
	  }
	  
	  
	  public static void setlevel(UUID uuid, int amount) {
		  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  		
	    
			Config.set("player.playerdata.level", amount);
			PlayerdataAPI.saveYaml(uuid, Config);
	  }	 	  	 
}
