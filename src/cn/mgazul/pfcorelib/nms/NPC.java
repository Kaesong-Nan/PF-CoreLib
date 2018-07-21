package cn.mgazul.pfcorelib.nms;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R1.CraftServer;
import org.bukkit.craftbukkit.v1_13_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_13_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_13_R1.EntityHuman;
import net.minecraft.server.v1_13_R1.EntityPlayer;
import net.minecraft.server.v1_13_R1.MinecraftServer;
import net.minecraft.server.v1_13_R1.Packet;
import net.minecraft.server.v1_13_R1.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_13_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_13_R1.PlayerConnection;
import net.minecraft.server.v1_13_R1.PlayerInteractManager;
import net.minecraft.server.v1_13_R1.World;
import net.minecraft.server.v1_13_R1.WorldServer;

public class NPC {

    public void spawnNPC(Player p, String name) {
        Location loc = p.getLocation();
        MinecraftServer nmsServer = ((CraftServer)Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld)p.getWorld()).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), name.replaceAll("&", "§"));
        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager((World)nmsWorld));
        Player npcPlayer = npc.getBukkitEntity().getPlayer();
        npcPlayer.setPlayerListName("");
        npc.setLocation(loc.getX(), loc.getY(), loc.getY(), loc.getYaw(), loc.getPitch());
        PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
        connection.sendPacket((Packet<?>)new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, new EntityPlayer[] { npc }));
        connection.sendPacket((Packet<?>)new PacketPlayOutNamedEntitySpawn((EntityHuman)npc));
    }
}
