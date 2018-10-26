package cn.mgazul.pfcorelib.server;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Server {

    public static Collection<? extends Player> getOnlinePlayers() {
        return Bukkit.getOnlinePlayers();
    }
    
    public static OfflinePlayer[] getOfflinePlayers() {
        return Bukkit.getOfflinePlayers();
    }
    
    public static void broadcast(final String str) {
        getOnlinePlayers().forEach(player -> player.sendMessage(str));
    }
    
    public static World getWorld(final String name) {
        return Bukkit.getWorld(name);
    }
    
    public static List<World> getWorlds() {
        return (List<World>)Bukkit.getWorlds();
    }
    
    public static Player getPlayer(final String id) {
        return Bukkit.getPlayer(id);
    }
    
    @SuppressWarnings("deprecation")
	public static OfflinePlayer getOfflinePlayer(final String id) {
        return Bukkit.getOfflinePlayer(id);
    }
    
    public static Player getPlayer(final UUID uuid) {
        return Bukkit.getPlayer(uuid);
    }
    
    public static OfflinePlayer getOfflinePlayer(final UUID uuid) {
        return Bukkit.getOfflinePlayer(uuid);
    }
    
    public static void dispatchCommand(final CommandSender sender, final String command) {
        Bukkit.dispatchCommand(sender, command);
    }
    
    public static void dispatchConsoleCommand(final String command) {
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command);
    }
    
    public static PluginManager getPluginManager() {
        return Bukkit.getPluginManager();
    }
}
