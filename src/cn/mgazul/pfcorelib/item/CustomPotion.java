package cn.mgazul.pfcorelib.item;

import org.bukkit.Material;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

public class CustomPotion extends CustomItem {

	@SuppressWarnings("deprecation")
	public CustomPotion(String name, int durability, String[] lore, PotionEffect effect) {
		super(Material.POTION, name, durability , lore);
		PotionMeta meta = (PotionMeta) getItemMeta();
		meta.setMainEffect(effect.getType());
		meta.addCustomEffect(effect, true);
		setItemMeta(meta);
	}
	
	public CustomPotion(String name, PotionType type, PotionEffect effect, String... lore) {
		super(Material.POTION, name, 0, lore);
		PotionMeta meta = (PotionMeta) getItemMeta();
		meta.setBasePotionData(new PotionData(type));
		meta.addCustomEffect(effect, true);
		setItemMeta(meta);
	}

}
