package cn.mgazul.pfcorelib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import cn.mgazul.pfcorelib.player.PlayerdataAPI;

public class Main extends JavaPlugin {
	
	public static Main plugin;   
	public VaultHandler vaultHandler;

  public void onEnable() {
	  
	plugin = this; 
	long currentTim = System.currentTimeMillis();
    getConfig().options().copyDefaults(true);
    saveConfig();
    saveDefaultConfig();
    reloadConfig();
    PlayerdataAPI.setFolderPath(getDataFolder(),"/Players");
    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	(this.vaultHandler = new VaultHandler(this)).hook();
    Bukkit.getConsoleSender().sendMessage(Msg.prefix + " §a铜钱系统已关联Vault.");
    if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
    	PFPapiHook.hook();
    	Bukkit.getConsoleSender().sendMessage(Msg.prefix + " §a变量系统已关联PlaceholderAPI.");
    }   
    Bukkit.getConsoleSender().sendMessage(Msg.prefix + " " + "§a该插件已成功激活!§e(§b耗时: "+(System.currentTimeMillis() - currentTim)+"§e ms) §7[v" + getDescription().getVersion() + "]");             
    
  } 

  public void onDisable() {
	  PFPapiHook.unhook();
  }
}
