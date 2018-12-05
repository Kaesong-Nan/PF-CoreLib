package cn.mgazul.pfcorelib;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PFPapiHook extends PlaceholderHook{

	private static final String hook_name = "pf";
    public MoneyAPI moneyAPI;
    public FCoinsAPI fCoinsAPI;

	@Override
	public String onPlaceholderRequest(Player p, String i) {
    	if(p == null){
    	 	return null;
    	}
        if (i.equalsIgnoreCase("coins")) {
        	Double coins = FCoinsAPI.getFCoins(p.getUniqueId());
            return String.valueOf(Formater.formatValue1(coins));
        }
        if (i.equalsIgnoreCase("money")) {
        	Double money = MoneyAPI.getMoneys(p.getUniqueId());
            return String.valueOf(Formater.formatValue1(money));
        }
        if (i.equalsIgnoreCase("exp")) {
            return String.valueOf(p.getExpToLevel());
        }
        if (i.equalsIgnoreCase("health")) {
            return Formater.formatValue2(p.getHealth());
        }
        if (i.equalsIgnoreCase("name")) {
            return p.getName();
        }
        if (i.equalsIgnoreCase("food")) {
            return String.valueOf(p.getFoodLevel());
        }
        if (i.equalsIgnoreCase("ping")) {
            return String.valueOf(((CraftPlayer) p).getHandle().ping);
        }
        if (i.equalsIgnoreCase("maxhealth")) {
  	  		AttributeInstance MaxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
  	  		Double getMaxhealth = MaxHealth.getBaseValue();
            return Formater.formatValue2(getMaxhealth);
        }
        if (i.equalsIgnoreCase("pflevels")) {
            return String.valueOf(p.getLevel());
        }

		return null;
	}

	public static void hook() {
		PlaceholderAPI.registerPlaceholderHook(hook_name, new PFPapiHook());
	}

	public static void unhook() {
		PlaceholderAPI.unregisterPlaceholderHook(hook_name);
	}
	
    public static String replacepapi(OfflinePlayer player, String x) {
        return PlaceholderAPI.setPlaceholders(player, x.replace("&", "§"));
    }
}
