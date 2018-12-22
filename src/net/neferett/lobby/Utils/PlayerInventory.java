package net.neferett.lobby.Utils;

import net.neferett.lobby.Database.SQL;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PlayerInventory {
	
	private static PlayerInventory instance;
	
	public static PlayerInventory getInstance(){
		if(instance == null) instance = new PlayerInventory();
		return instance;
	}


	public void PlayerInv(Player p){
		p.setFoodLevel(20);
		
		org.bukkit.inventory.PlayerInventory inv = p.getInventory();
		inv.clear();
		inv.setHelmet(null);
		inv.setChestplate(null);
		inv.setLeggings(null);
		inv.setBoots(null);		
		

			ItemStack Menu = new ItemStack(Material.ENDER_CHEST);
			ItemMeta menu_meta = Menu.getItemMeta();

				menu_meta.setDisplayName("§6§nMenu principal & Jeux");
			Menu.setItemMeta(menu_meta);

			ItemStack boutique = new ItemStack(Material.EMERALD);
			ItemMeta b_meta = boutique.getItemMeta();

				b_meta.setDisplayName("§a§nBoutique");


			boutique.setItemMeta(b_meta);
			
			ItemStack A = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta A_meta = A.getItemMeta();
				A_meta.setDisplayName("§b§nArene PvP");

			A.setItemMeta(A_meta);
			
			ItemStack K = new ItemStack(Material.NETHER_STAR);
			ItemMeta K_meta = K.getItemMeta();
			K_meta.setDisplayName("§6§nKits");
			K.setItemMeta(K_meta);
			
			ItemStack L = new ItemStack(Material.QUARTZ);
			ItemMeta L_meta = L.getItemMeta();
			L_meta.setDisplayName("§6§nChanger de langue");
			L.setItemMeta(L_meta);
			
			inv.setItem(0, Menu);
			inv.setItem(1, boutique);
			inv.setItem(4, A);
			inv.setItem(6, L);
			inv.setItem(8, K);
			p.updateInventory();
		
			
			
		
		
	}
	
	public void PlayerInvChangeLang(Player p){
		p.setFoodLevel(20);
		
		org.bukkit.inventory.PlayerInventory inv = p.getInventory();
		inv.clear();
		inv.setHelmet(null);
		inv.setChestplate(null);
		inv.setLeggings(null);
		inv.setBoots(null);		
		
		if(SQL.getLang(p) == 0){
			ItemStack Menu = new ItemStack(Material.ENDER_CHEST);
			ItemMeta menu_meta = Menu.getItemMeta();

				menu_meta.setDisplayName("§6§nMenu principal & Jeux");
			Menu.setItemMeta(menu_meta);

			ItemStack boutique = new ItemStack(Material.EMERALD);
			ItemMeta b_meta = boutique.getItemMeta();

				b_meta.setDisplayName("§a§nBoutique");


			boutique.setItemMeta(b_meta);
			
			ItemStack A = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta A_meta = A.getItemMeta();
				A_meta.setDisplayName("§b§nArene PvP");

			A.setItemMeta(A_meta);
			
			ItemStack K = new ItemStack(Material.NETHER_STAR);
			ItemMeta K_meta = K.getItemMeta();
			K_meta.setDisplayName("§6§nKits");
			K.setItemMeta(K_meta);
			
			ItemStack L = new ItemStack(Material.QUARTZ);
			ItemMeta L_meta = L.getItemMeta();
			L_meta.setDisplayName("§6§nChanger de langue");
			L.setItemMeta(L_meta);
			
			inv.setItem(0, Menu);
			inv.setItem(1, boutique);
			inv.setItem(4, A);
			inv.setItem(6, L);
			inv.setItem(8, K);
			p.updateInventory();
		}else if(SQL.getLang(p) == 1){
			ItemStack Menu = new ItemStack(Material.ENDER_CHEST);
			ItemMeta menu_meta = Menu.getItemMeta();

				menu_meta.setDisplayName("§6§nMain Menu & Games");
			Menu.setItemMeta(menu_meta);

			ItemStack boutique = new ItemStack(Material.EMERALD);
			ItemMeta b_meta = boutique.getItemMeta();

				b_meta.setDisplayName("§a§nShop");


			boutique.setItemMeta(b_meta);
			
			ItemStack A = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta A_meta = A.getItemMeta();
				A_meta.setDisplayName("§b§nPvP Arena");

			A.setItemMeta(A_meta);
			
			ItemStack K = new ItemStack(Material.NETHER_STAR);
			ItemMeta K_meta = K.getItemMeta();
			K_meta.setDisplayName("§6§nKits");
			K.setItemMeta(K_meta);
			
			ItemStack L = new ItemStack(Material.QUARTZ);
			ItemMeta L_meta = L.getItemMeta();
			L_meta.setDisplayName("§6§nChange your language");
			L.setItemMeta(L_meta);
			
			inv.setItem(0, Menu);
			inv.setItem(1, boutique);
			inv.setItem(4, A);
			inv.setItem(6, L);
			inv.setItem(8, K);
			p.updateInventory();
		}else if(SQL.getLang(p) == 2){
			ItemStack Menu = new ItemStack(Material.ENDER_CHEST);
			ItemMeta menu_meta = Menu.getItemMeta();

				menu_meta.setDisplayName("§6§nMenú Principal & juegos");
			Menu.setItemMeta(menu_meta);

			ItemStack boutique = new ItemStack(Material.EMERALD);
			ItemMeta b_meta = boutique.getItemMeta();

				b_meta.setDisplayName("§a§nTienda");


			boutique.setItemMeta(b_meta);
			
			ItemStack A = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta A_meta = A.getItemMeta();
				A_meta.setDisplayName("§b§nArena PvP");

			A.setItemMeta(A_meta);
			
			ItemStack K = new ItemStack(Material.NETHER_STAR);
			ItemMeta K_meta = K.getItemMeta();
			K_meta.setDisplayName("§6§nKits");
			K.setItemMeta(K_meta);
			
			ItemStack L = new ItemStack(Material.QUARTZ);
			ItemMeta L_meta = L.getItemMeta();
			L_meta.setDisplayName("§6§nCambiar idioma");
			L.setItemMeta(L_meta);
			
			inv.setItem(0, Menu);
			inv.setItem(1, boutique);
			inv.setItem(4, A);
			inv.setItem(6, L);
			inv.setItem(8, K);
			p.updateInventory();
	}
			
		
		
	}

}
