package cn.mgazul.pfcorelib.nms;

import org.bukkit.entity.Player;

import net.minecraft.server.v1_13_R1.ChatMessageType;
import net.minecraft.server.v1_13_R1.IChatBaseComponent;
import net.minecraft.server.v1_13_R1.PacketPlayOutChat;
import net.minecraft.server.v1_13_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_13_R1.PlayerConnection;
import org.bukkit.craftbukkit.v1_13_R1.entity.CraftPlayer;

public class TitleAPI {
  //屏幕下方
  public static void sendPlayerAbar(Player p, String text) {
    IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\"}");
    PacketPlayOutChat ppoc = new PacketPlayOutChat(icbc, ChatMessageType.GAME_INFO);
    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(ppoc);
  }
  //屏幕中间
  public static void sendPlayerTitle(Player player, int fadeIn, int stay, int fadeOut, String title) {
    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut);
    connection.sendPacket(packetPlayOutTimes);
    IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
    PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
    connection.sendPacket(packetPlayOutTitle);
  }
  //屏幕中间二排
  public static void sendPlayerSubTitle(Player player, int fadeIn, int stay, int fadeOut, String subTitle) {
    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut);
    connection.sendPacket(packetPlayOutTimes);
    IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subTitle + "\"}");
    PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
    connection.sendPacket(packetPlayOutSubTitle);
    IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"\"}");
    PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
    connection.sendPacket(packetPlayOutTitle);
  }
  // 双排显示
  public static void sendFullTitle(Player player, int fadeIn, int stay, int fadeOut, String title, String subtitle) {
    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut);
    connection.sendPacket(packetPlayOutTimes);
    IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
    PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
    connection.sendPacket(packetPlayOutSubTitle);
    IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
    PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
    connection.sendPacket(packetPlayOutTitle);
  }
}
