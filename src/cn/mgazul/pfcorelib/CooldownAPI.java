package cn.mgazul.pfcorelib;

import java.util.HashMap;

public class CooldownAPI
{
  private String player;
  private long cooldown;
  private String key;
  
  public CooldownAPI(String player, long cooldown, String key)
  {
    this.player = player;
    this.cooldown = cooldown;
    this.key = key;
  }
  
  public String getPlayer()
  {
    return this.player;
  }
  
  public long getCooldown()
  {
    return this.cooldown;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public static void setCooldown(String player, long cooldown, String title)
  {
    cooldowns.put(String.valueOf(player) + title, new CooldownAPI(player, System.currentTimeMillis() + cooldown, title));
  }
  
  public static boolean hasCooldown(String player, String title)
  {
    return (cooldowns.get(String.valueOf(player) + title) != null) && (((CooldownAPI)cooldowns.get(String.valueOf(player) + title)).getCooldown() > System.currentTimeMillis());
  }
  
  public static long getCooldown(String player, String title)
  {
    return (((CooldownAPI)cooldowns.get(String.valueOf(player) + title)).getCooldown() - System.currentTimeMillis()) / 1000L;
  }
  
  public static HashMap<String, CooldownAPI> cooldowns = new HashMap<String, CooldownAPI>();
}
