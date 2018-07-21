package cn.mgazul.pfcorelib.item;

import net.minecraft.server.v1_13_R1.NBTTagCompound;
import net.minecraft.server.v1_13_R1.NBTTagInt;
import net.minecraft.server.v1_13_R1.NBTTagList;
import net.minecraft.server.v1_13_R1.NBTTagString;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_13_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateItem
{
  public ItemStack createItem(Material mat, int amount, String title, List<String> lores)
  {
    ItemStack itemStack = new ItemStack(mat, amount);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(title);
    itemMeta.setLore(lores);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public ItemStack createItem(Material mat, int amount, String title)
  {
    ItemStack itemStack = new ItemStack(mat, amount);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(title);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public ItemStack createItem(){
	  ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
	  ItemMeta im = item.getItemMeta();
	  im.setDisplayName("§6[ §e§l战火 §6]");
	  item.setItemMeta(im);
	  net.minecraft.server.v1_13_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);  
	  ItemStack hasNBTItem = CraftItemStack.asBukkitCopy(nmsItem);
	  NBTTagCompound compound =  (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
	  NBTTagList modifiers = new NBTTagList();
	  NBTTagCompound damage = new NBTTagCompound();
	  
	  damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
	  damage.set("Name", new NBTTagString("Damage"));
	  damage.set("Amount", new NBTTagInt(20));
	  damage.set("Operation", new NBTTagInt(0));
	  damage.set("UUIDLeast", new NBTTagInt(20000));
	  damage.set("UUIDMost", new NBTTagInt(1000));
	  damage.set("Slot", new NBTTagString("mainhand"));
	  
	  modifiers.add(damage);
	  compound.set("AttributeModifiers", modifiers);
	  nmsItem.setTag(compound);
	  return hasNBTItem;
  }
  
  public ItemStack createItem(Material mat, String title)
  {
    ItemStack itemStack = new ItemStack(mat, 1);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(title);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public ItemStack createItem(Material mat, String title, int a)
  {
    ItemStack itemStack = new ItemStack(mat, 1, (short)(byte)a);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(title);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
}
