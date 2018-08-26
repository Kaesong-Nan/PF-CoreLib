package cn.mgazul.pfcorelib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import cn.mgazul.pfcorelib.player.PlayerdataAPI;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	public static Main plugin;  
	private Economy vault;

  public void onEnable() {
	  
	plugin = this; 
	long currentTim = System.currentTimeMillis();
    getConfig().options().copyDefaults(true);
    saveConfig();
    saveDefaultConfig();
    reloadConfig();
    PlayerdataAPI.setFolderPath(getDataFolder(),"/Players");
    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
    	PFPapiHook.hook();
    	Bukkit.getConsoleSender().sendMessage(Msg.prefix + " §a变量系统已关联PlaceholderAPI.");
    }   
    setupVault();
    Bukkit.getConsoleSender().sendMessage(Msg.prefix + " " + "§a该插件已成功激活!§e(§b耗时: "+(System.currentTimeMillis() - currentTim)+"§e ms) §7[v" + getDescription().getVersion() + "]");             
    
  } 

  public void onDisable() {
	  PFPapiHook.unhook();
  }
  
  public void setupVault(){
	    this.vault = new VaultHandler();
	    getServer().getServicesManager().register(Economy.class, this.vault, this, ServicePriority.Highest);
	    Bukkit.getConsoleSender().sendMessage("§7[§6PF-CoreLib§7] §a铜钱系统已关联Vault.");
	  }
}
