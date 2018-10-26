package cn.mgazul.pfcorelib;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import org.bukkit.entity.Player;

public class BCConnecter
{
  private Player player;
  private String serverId;
  
  public BCConnecter(Player player, String serverId)
  {
    this.player = player;
    this.serverId = serverId;
  }
  
  public boolean start()
  {
    return conect(this.serverId, this.player);
  }
  
  private boolean conect(String serverId, Player player)
  {
    try
    {
      ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
      DataOutputStream out = new DataOutputStream(byteArray);
      
      out.writeUTF("Connect");
      out.writeUTF(serverId);
      
      player.sendPluginMessage(Main.plugin, "BungeeCord", byteArray.toByteArray());
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      return false;
    }
    return true;
  }
}
