package cn.mgazul.pfcorelib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import net.milkbowl.vault.economy.Economy;

public class VaultHandler{
	
    private MgEco economy;
    private Main plugin;
    
    public VaultHandler(final Main plugin) {
        this.economy = null;
        this.plugin = plugin;
    }
    
    public void hook() {
        try {
            if (this.economy == null) {
                this.economy = new MgEco();
            }
            final ServicesManager sm = Bukkit.getServicesManager();
            sm.register(Economy.class, this.economy, this.plugin, ServicePriority.Highest);
        }
        catch (Exception e) {
  
        }
    }
    
    public void unhook() {
        final ServicesManager sm = Bukkit.getServicesManager();
        if (this.economy != null) {
            sm.unregister((Class<?>)Economy.class, (Object)this.economy);
            this.economy = null;
        }
    }
}
