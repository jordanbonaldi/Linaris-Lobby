package net.neferett.lobby.Listener;

import java.util.ArrayList;

import net.neferett.lobby.Database.SQL;
import net.neferett.lobby.NPC.Utils;
import net.neferett.lobby.Utils.PlayerInventory;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class InteractListener implements Listener{
	
	public void Drop(PlayerDropItemEvent e){
		if(!e.getPlayer().hasPermission("linaris.candrop")){
			e.setCancelled(true);
		}
		
	}public static InteractListener instance;
	
	public static InteractListener getInstance(){
		return instance;

	}
	@EventHandler
	public void InteractE(PlayerInteractEvent e){
		ItemStack is = e.getItem();
		Player p = e.getPlayer();
		if(is == null) return;
		if(is.getType() == Material.QUARTZ){
			if(SQL.getLang(p) == 0){
				Inventory inv = Bukkit.createInventory(p, 27, "§nChangement de langue");
				
				ArrayList<String> lore0 = new ArrayList<String>();

				ItemStack fr = new ItemStack(Material.STAINED_CLAY, 1, (short) 3);
				ItemMeta frm = fr.getItemMeta();
				frm.setDisplayName("§6§l§kM §b§lFrançais §6§l§kM");
					lore0.add("§cTu as déjà choisi");
					lore0.add("§ccette langue");
				frm.setLore(lore0);
				fr.setItemMeta(frm);
				
				ArrayList<String> lore1 = new ArrayList<String>();

				ItemStack en = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
				ItemMeta enm = en.getItemMeta();
				enm.setDisplayName("§6§l§kM §b§lEnglish §6§l§kM");
				lore1.add("§aClick here to set");
				lore1.add("§ayour language in §cEnglish §a!");
				enm.setLore(lore1);
				en.setItemMeta(enm);
				
				ArrayList<String> lore2 = new ArrayList<String>();

				ItemStack es = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
				ItemMeta esm = es.getItemMeta();
				esm.setDisplayName("§6§l§kM §b§lEspañol §6§l§kM");
					lore2.add("§aHaga clic aquí para poner");
					lore2.add("§asu lengua en §cEspañol ");
				esm.setLore(lore2);
				es.setItemMeta(esm);
				
				inv.setItem(11, fr);
				inv.setItem(13, en);
				inv.setItem(15, es);
				p.openInventory(inv);
				
			}else if(SQL.getLang(p) == 1){
				Inventory inv = Bukkit.createInventory(p, 27, "§nChange your language");
				
				ArrayList<String> lore0 = new ArrayList<String>();

				ItemStack fr = new ItemStack(Material.STAINED_CLAY, 1, (short) 3);
				ItemMeta frm = fr.getItemMeta();
				frm.setDisplayName("§6§l§kM §b§lFrançais §6§l§kM");
				lore0.add("§aClique ici pour mettre");
				lore0.add("§ata langue en §cFrançais");
				frm.setLore(lore0);
				fr.setItemMeta(frm);
				
				ArrayList<String> lore1 = new ArrayList<String>();

				ItemStack en = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
				ItemMeta enm = en.getItemMeta();
				enm.setDisplayName("§6§l§kM §b§lEnglish §6§l§kM");
					lore1.add("§cYou already selected");
					lore1.add("§cthis language !");
				enm.setLore(lore1);
				en.setItemMeta(enm);
				
				ArrayList<String> lore2 = new ArrayList<String>();

				ItemStack es = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
				ItemMeta esm = es.getItemMeta();
				esm.setDisplayName("§6§l§kM §b§lEspañol §6§l§kM");
				lore2.add("§aHaga clic aquí para poner");
				lore2.add("§asu lengua en §cEspañol ");
				esm.setLore(lore2);
				es.setItemMeta(esm);
				
				inv.setItem(11, fr);
				inv.setItem(13, en);
				inv.setItem(15, es);
				p.openInventory(inv);
			}else if(SQL.getLang(p) == 2){
				Inventory inv = Bukkit.createInventory(p, 27, "§nCambiar idioma");
				
				ArrayList<String> lore0 = new ArrayList<String>();

				ItemStack fr = new ItemStack(Material.STAINED_CLAY, 1, (short) 3);
				ItemMeta frm = fr.getItemMeta();
				frm.setDisplayName("§6§l§kM §b§lFrançais §6§l§kM");
				lore0.add("§aClique ici pour mettre");
				lore0.add("§ata langue en §cFrançais");
				frm.setLore(lore0);
				fr.setItemMeta(frm);
				
				ArrayList<String> lore1 = new ArrayList<String>();

				ItemStack en = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
				ItemMeta enm = en.getItemMeta();
				enm.setDisplayName("§6§l§kM §b§lEnglish §6§l§kM");
				lore1.add("§aClick here to set");
				lore1.add("§ayour language in §cEnglish §a!");
				enm.setLore(lore1);
				en.setItemMeta(enm);
				
				ArrayList<String> lore2 = new ArrayList<String>();

				ItemStack es = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
				ItemMeta esm = es.getItemMeta();
				esm.setDisplayName("§6§l§kM §b§lEspañol §6§l§kM");
					lore2.add("§cUsted ya ha ");
					lore2.add("§cseleccionado este idioma");
				esm.setLore(lore2);
				es.setItemMeta(esm);
				
				inv.setItem(11, fr);
				inv.setItem(13, en);
				inv.setItem(15, es);
				p.openInventory(inv);

			}
		}
		if(Bukkit.getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")){
		if(is.getType() == Material.ENDER_CHEST){
			if(SQL.getLang(p) == 0){
				Inventory inv = Bukkit.createInventory(p, 54, "§nMenu principal & Jeux");
				
				ArrayList<String> lore0 = new ArrayList<String>();

				ItemStack pt = new ItemStack(Material.WOOD_SWORD);
				ItemMeta ptm = pt.getItemMeta();
				ptm.setDisplayName("§6§6§l§kM §b§lPvP Training §6§6§l§kM");
					lore0.add("§aClique pour te connecter");
					lore0.add("§bLe jeu§f:");
					lore0.add("");
					lore0.add("§f- §6Entraine toi dans une arene");
					lore0.add("§f- §6Ameliore ton stuff grace");
					lore0.add("§f- §6à tes points gagnés en tuant");
					lore0.add("§f- §6et deviens le meilleur au top Kill !");
				ptm.setLore(lore0);
				pt.setItemMeta(ptm);
				
				ArrayList<String> lore1 = new ArrayList<String>();

				ItemStack PB = new ItemStack(Material.STONE_SWORD);
				ItemMeta PBm = PB.getItemMeta();
				PBm.setDisplayName("§6§6§l§kM §b§lPvPBox §6§6§l§kM");
					lore1.add("§aClique pour te connecter");
					lore1.add("§bLe jeu§f:");
					lore1.add("");
					lore1.add("§f- §6Combat dans une arene");
					lore1.add("§f- §6Gagne de l'argent et achete-toi");
					lore1.add("§f- §6les meilleurs kits afin d'être le meilleur !");
				PBm.setLore(lore1);
				PB.setItemMeta(PBm);
				
				ArrayList<String> lore2 = new ArrayList<String>();

				ItemStack pbc = new ItemStack(Material.IRON_SWORD);
				pbc.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				ItemMeta pbcm = pbc.getItemMeta();
				pbcm.setDisplayName("§6§6§l§kM §b§lPvPBox Cheat §6§6§l§kM");
					lore2.add("§aClique pour te connecter");
					lore2.add("§bLe jeu§f:");
					lore2.add("");
					lore2.add("§f- §6Combat dans une arene");
					lore2.add("§f- §6Gagne de l'argent et achete-toi");
					lore2.add("§f- §6les meilleurs kits afin d'être le meilleur !");
				pbcm.setLore(lore2);
				pbc.setItemMeta(pbcm);
				
				ArrayList<String> lore3 = new ArrayList<String>();

				ItemStack pf = new ItemStack(Material.GOLD_SWORD);
				ItemMeta pfm = pf.getItemMeta();
				pfm.setDisplayName("§6§6§l§kM §b§lPvP Faction §6§6§l§kM");
					lore3.add("§aClique pour te connecter");
					lore3.add("§bLe jeu§f:");
					lore3.add("");
					lore3.add("§f- §6Créer ta faction puis");
					lore3.add("§f- §6Combat les autres factions");
					lore3.add("§f- §6et deviens la faction la plus populaire");
					lore3.add("§f- §6et plus forte du serveur !");
				pfm.setLore(lore3);
				pf.setItemMeta(pfm);
				
				ArrayList<String> lore4 = new ArrayList<String>();

				ItemStack pfc = new ItemStack(Material.DIAMOND_SWORD);
				pfc.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				ItemMeta pfcm = pfc.getItemMeta();
				pfcm.setDisplayName("§6§l§kM §b§lPvP Cheat §6§l§kM");
					lore4.add("§aClique pour te connecter");
					lore4.add("§bLe jeu§f:");
					lore4.add("");
					lore4.add("§f- §6Créer ta faction puis");
					lore4.add("§f- §6Combat les autres factions");
					lore4.add("§f- §6et deviens la faction la plus populaire");
					lore4.add("§f- §6et plus forte du serveur !");
				pfcm.setLore(lore4);
				pfc.setItemMeta(pfcm);
				
				
				ArrayList<String> lore5 = new ArrayList<String>();

				ItemStack isl = new ItemStack(Material.DIAMOND_PICKAXE);
				ItemMeta islm = isl.getItemMeta();
				islm.setDisplayName("§6§l§kM §b§lIsland Survival §6§l§kM");
					lore5.add("§aClique pour te connecter");
					lore5.add("§bLe jeu§f:");
					lore5.add("");
					lore5.add("§f- §6Survie seul ou a plusieurs");
					lore5.add("§f- §6sur une île dans le vide.");
					lore5.add("§f- §6En reussissant les objectifs augmente");
					lore5.add("§f- §6de level et deviens le plus haut level !");
				islm.setLore(lore5);
				isl.setItemMeta(islm);
				
				
				ArrayList<String> lore6 = new ArrayList<String>();

				ItemStack d = new ItemStack(Material.DIAMOND);
				ItemMeta dm = d.getItemMeta();
				dm.setDisplayName("§6§l§kM §b§lTheWalkingDead §6§l§kM");
					lore6.add("§aClique pour te connecter");
					lore6.add("§bLe jeu§f:");
					lore6.add("");
					lore6.add("§f- §6Survie face a des hordes");
					lore6.add("§f- §6de zombies de partout dans");
					lore6.add("§f- §6les fameux endroits de la série");
					lore6.add("§f- §6TWD, accomplie les quêtes des");
					lore6.add("§f- §6personnages de la serie");
					lore6.add("§f- §6et débloque leurs kits !");
				dm.setLore(lore6);
				d.setItemMeta(dm);
				
				
				ArrayList<String> lore7 = new ArrayList<String>();

				ItemStack G = new ItemStack(Material.MINECART);
				ItemMeta Gm = G.getItemMeta();
				Gm.setDisplayName("§6§l§kM §b§lGTA §6§l§kM");
					lore7.add("§aClique pour te connecter");
					lore7.add("§bLe jeu§f:");
					lore7.add("");
					lore7.add("§f- §6Vie ton experience GTA");
					lore7.add("§f- §6Dans un monde libre et");
					lore7.add("§f- §6sans règles a suivre !");
				Gm.setLore(lore7);
				G.setItemMeta(Gm);
				
				
				ArrayList<String> lore8 = new ArrayList<String>();

				ItemStack pr = new ItemStack(Material.IRON_FENCE);
				ItemMeta prm = pr.getItemMeta();
				prm.setDisplayName("§6§l§kM §b§lPrison §6§l§kM");
					lore8.add("§aClique pour te connecter");
					lore8.add("§bLe jeu§f:");
					lore8.add("");
					lore8.add("§f- §6Essaie de t'évader de notre");
					lore8.add("§f- §6prison en minant et devenant");
					lore8.add("§f- §6le plus respecté du serveur !");
				prm.setLore(lore8);
				pr.setItemMeta(prm);
				
				ArrayList<String> lore9 = new ArrayList<String>();

				ItemStack F = new ItemStack(Material.GRASS);
				ItemMeta Fm = F.getItemMeta();
				Fm.setDisplayName("§6§l§kM §b§lFreeBuild §6§l§kM");
					lore9.add("§aClique pour te connecter");
					lore9.add("§bLe jeu§f:");
					lore9.add("");
					lore9.add("§f- §6Une envie de construire ?");
					lore9.add("§f- §6Notre FreeBuild te le permet");
					lore9.add("§f- §6La seul limite est celle de ton imagination");
				Fm.setLore(lore9);
				F.setItemMeta(Fm);
				
				ArrayList<String> lore10 = new ArrayList<String>();

				ItemStack c = new ItemStack(Material.APPLE);
				ItemMeta cm = c.getItemMeta();
				cm.setDisplayName("§6§l§kM §b§lClash Of Clans §6§l§kM");
					lore10.add("§aClique pour te connecter");
					lore10.add("§bLe jeu§f:");
					lore10.add("");
					lore10.add("§f- §6Comme dans Clash Of Clans");
					lore10.add("§f- §6Construit protège, mine");
					lore10.add("§f- §6PvP, devient le plus haut level !");
					lore10.add("§f- §6Et soit sans pitier avec les autres !");
				cm.setLore(lore10);
				c.setItemMeta(cm);
				
				

				

				ItemStack a = new ItemStack(Material.ARROW);
				ItemMeta am = a.getItemMeta();
				am.setDisplayName("§7Revenir en arrière");
				a.setItemMeta(am);
				
				ArrayList<String> lore12 = new ArrayList<String>();

				ItemStack am1 = new ItemStack(Material.RAW_FISH, 1, (short) 3);
				ItemMeta amm = am1.getItemMeta();
				amm.setDisplayName("§6Amis§f:");
				lore12.add("§f- §bVous affiche les commandes");
				lore12.add("§f- §bd'informations des amis.");
				amm.setLore(lore12);

				am1.setItemMeta(amm);
				
				ArrayList<String> lore13 = new ArrayList<String>();

				ItemStack par1 = new ItemStack(Material.BOOK_AND_QUILL);
				ItemMeta parm = par1.getItemMeta();
				parm.setDisplayName("§6Parties§f:");
				lore13.add("§f- §bVous affiche les commandes");
				lore13.add("§f- §bd'informations des parties.");
				parm.setLore(lore13);

				par1.setItemMeta(parm);
				
				ArrayList<String> lore14 = new ArrayList<String>();

				ItemStack lang1 = new ItemStack(Material.QUARTZ);
				ItemMeta langm = lang1.getItemMeta();
				langm.setDisplayName("§6Langage§f:");
				lore14.add("§f- §bClique pour entrer");
				lore14.add("§f- §bdans le menu des langues.");
				langm.setLore(lore14);

				lang1.setItemMeta(langm);
				

				ItemStack spawn1 = new ItemStack(Material.BED);
				ItemMeta spawnm = spawn1.getItemMeta();
				spawnm.setDisplayName("§6Retour au spawn");
				spawn1.setItemMeta(spawnm);
				
				ArrayList<String> lore15 = new ArrayList<String>();
				ItemStack feather1 = new ItemStack(Material.FEATHER);
				ItemMeta featherm = feather1.getItemMeta();
				featherm.setDisplayName("§6Fly§f:");
				lore15.add("§bClique pour§f:");
				lore15.add("§f- §7Activer le fly");
				lore15.add("§f- §7Désactiver le fly");
				featherm.setLore(lore15);

				feather1.setItemMeta(featherm);
				
				ArrayList<String> lore16 = new ArrayList<String>();
				ItemStack cansee1 = new ItemStack(Material.SULPHUR);
				ItemMeta canseem = cansee1.getItemMeta();
				canseem.setDisplayName("§6Poudre de vison§f:");
				lore16.add("§bPermet de masquer§f:");
				lore16.add("§f- §7Les joueurs (hors staff)");
				lore16.add("§f- §7Les particules");
				canseem.setLore(lore16);

				cansee1.setItemMeta(canseem);
				
				ItemStack boutique1 = new ItemStack(Material.EMERALD);
				ItemMeta boutiquem = boutique1.getItemMeta();
				boutiquem.setDisplayName("§6§kMM§r §b§l§nBoutique§r §6§k§lMM");
				boutique1.setItemMeta(boutiquem);
				


				
				inv.setItem(1, pt);
				inv.setItem(2, PB);
				inv.setItem(6, isl);
				inv.setItem(7, d);
				inv.setItem(10, pbc);
				inv.setItem(11, pf);
				inv.setItem(15, G);
				inv.setItem(16, pr);
				inv.setItem(19, pfc);
				inv.setItem(24, F);
				inv.setItem(25, c);
				
				inv.setItem(37, am1);
				inv.setItem(43, spawn1);
				inv.setItem(45, a);
				inv.setItem(46, par1);
				inv.setItem(47, lang1);
				inv.setItem(51, feather1);
				inv.setItem(52, cansee1);
				inv.setItem(53, boutique1);
				
				ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
				inv.setItem(4, red);
				inv.setItem(13, red);
				inv.setItem(22, red);
				inv.setItem(31, red);
				inv.setItem(49, red);
				inv.setItem(27, red);
				inv.setItem(28, red);
				inv.setItem(29, red);
				inv.setItem(30, red);
				inv.setItem(31, red);
				inv.setItem(32, red);		
				inv.setItem(33, red);
				inv.setItem(34, red);
				inv.setItem(35, red);
				inv.setItem(39, red);
				inv.setItem(41, red);
				inv.setItem(48, red);
				inv.setItem(50, red);
				


				p.updateInventory();
				p.openInventory(inv);
			}else if(SQL.getLang(p) == 1){
				Inventory inv = Bukkit.createInventory(p, 54, "§nMain Menu & Games");
				
				ArrayList<String> lore0 = new ArrayList<String>();

				ItemStack pt = new ItemStack(Material.WOOD_SWORD);
				ItemMeta ptm = pt.getItemMeta();
				ptm.setDisplayName("§6§6§l§kM §b§lPvP Training §6§6§l§kM");
					lore0.add("§aClick to connect");
					lore0.add("§bThe Game§f:");
					lore0.add("");
					lore0.add("§f- §6Practice your skill in an arena");
					lore0.add("§f- §6Improves your stuff thanks to");
					lore0.add("§f- §6points that you win by killing");
					lore0.add("§f- §6and become the best at the TOP KILL !");
				ptm.setLore(lore0);
				pt.setItemMeta(ptm);
				
				ArrayList<String> lore1 = new ArrayList<String>();

				ItemStack PB = new ItemStack(Material.STONE_SWORD);
				ItemMeta PBm = PB.getItemMeta();
				PBm.setDisplayName("§6§6§l§kM §b§lPvPBox §6§6§l§kM");
					lore1.add("§aClick to connect");
					lore1.add("§bThe Game§f:");
					lore1.add("");
					lore1.add("§f- §6Fight in an arena");
					lore1.add("§f- §6Earn money and buy yourself");
					lore1.add("§f- §6the best kits to be the best !");
				PBm.setLore(lore1);
				PB.setItemMeta(PBm);
				
				ArrayList<String> lore2 = new ArrayList<String>();

				ItemStack pbc = new ItemStack(Material.IRON_SWORD);
				pbc.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				ItemMeta pbcm = pbc.getItemMeta();
				pbcm.setDisplayName("§6§6§l§kM §b§lPvPBox Cheat §6§6§l§kM");
					lore2.add("§aClick to connect");
					lore2.add("§bThe Game§f:");
					lore2.add("");
					lore2.add("§f- §6Fight in an arena");
					lore2.add("§f- §6Earn money and buy yourself");
					lore2.add("§f- §6the best kits to be the best !");
				pbcm.setLore(lore2);
				pbc.setItemMeta(pbcm);
				
				ArrayList<String> lore3 = new ArrayList<String>();

				ItemStack pf = new ItemStack(Material.GOLD_SWORD);
				ItemMeta pfm = pf.getItemMeta();
				pfm.setDisplayName("§6§6§l§kM §b§lPvP Faction §6§6§l§kM");
					lore3.add("§aClick to connect");
					lore3.add("§bThe Game§f:");
					lore3.add("");
					lore3.add("§f- §6Create your faction and");
					lore3.add("§f- §6fight others ones");
					lore3.add("§f- §6and become the most famous faction");
					lore3.add("§f- §6most strongest of the server !");
				pfm.setLore(lore3);
				pf.setItemMeta(pfm);
				
				ArrayList<String> lore4 = new ArrayList<String>();

				ItemStack pfc = new ItemStack(Material.DIAMOND_SWORD);
				pfc.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				ItemMeta pfcm = pfc.getItemMeta();
				pfcm.setDisplayName("§6§l§kM §b§lPvP Cheat §6§l§kM");
					lore4.add("§aClick to connect");
					lore4.add("§bThe Game§f:");
					lore4.add("");
					lore4.add("§f- §6Create your faction and");
					lore4.add("§f- §6fight others ones");
					lore4.add("§f- §6and become the most famous faction");
					lore4.add("§f- §6most strongest of the server !");
				pfcm.setLore(lore4);
				pfc.setItemMeta(pfcm);
				
				
				ArrayList<String> lore5 = new ArrayList<String>();

				ItemStack isl = new ItemStack(Material.DIAMOND_PICKAXE);
				ItemMeta islm = isl.getItemMeta();
				islm.setDisplayName("§6§l§kM §b§lIsland Survival §6§l§kM");
					lore5.add("§aClick to connect");
					lore5.add("§bThe Game§f:");
					lore5.add("");
					lore5.add("§f- §6Try to survive alone or with your friends");
					lore5.add("§f- §6on an island in the void.");
					lore5.add("§f- §6In achieving quests up your level and skill");
					lore5.add("§f- §6and became the strongest of the server!");
				islm.setLore(lore5);
				isl.setItemMeta(islm);
				
				
				ArrayList<String> lore6 = new ArrayList<String>();

				ItemStack d = new ItemStack(Material.DIAMOND);
				ItemMeta dm = d.getItemMeta();
				dm.setDisplayName("§6§l§kM §b§lTheWalkingDead §6§l§kM");
					lore6.add("§aClick to connect");
					lore6.add("§bThe Game§f:");
					lore6.add("");
					lore6.add("§f- §6Try to survive in front of");
					lore6.add("§f- §6zombies hordes everywhere");
					lore6.add("§f- §6in famous places of the serie");
					lore6.add("§f- §6TWD, achieve quests of");
					lore6.add("§f- §6serie characters and unlock");
					lore6.add("§f- §6their kits for become the best !");
				dm.setLore(lore6);
				d.setItemMeta(dm);
				
				
				ArrayList<String> lore7 = new ArrayList<String>();

				ItemStack G = new ItemStack(Material.MINECART);
				ItemMeta Gm = G.getItemMeta();
				Gm.setDisplayName("§6§l§kM §b§lGTA §6§l§kM");
					lore7.add("§aClick to connect");
					lore7.add("§bThe Game§f:");
					lore7.add("");
					lore7.add("§f- §6Live your GTA experience");
					lore7.add("§f- §6In a free world");
					lore7.add("§f- §6without rules !");
				Gm.setLore(lore7);
				G.setItemMeta(Gm);
				
				
				ArrayList<String> lore8 = new ArrayList<String>();

				ItemStack pr = new ItemStack(Material.IRON_FENCE);
				ItemMeta prm = pr.getItemMeta();
				prm.setDisplayName("§6§l§kM §b§lPrison §6§l§kM");
					lore8.add("§aClick to connect");
					lore8.add("§bThe Game§f:");
					lore8.add("");
					lore8.add("§f- §6Try to escapte of our");
					lore8.add("§f- §6jail by mining and becoming");
					lore8.add("§f- §6the most respected of the server !");
				prm.setLore(lore8);
				pr.setItemMeta(prm);
				
				ArrayList<String> lore9 = new ArrayList<String>();

				ItemStack F = new ItemStack(Material.GRASS);
				ItemMeta Fm = F.getItemMeta();
				Fm.setDisplayName("§6§l§kM §b§lFreeBuild §6§l§kM");
					lore9.add("§aClick to connect");
					lore9.add("§bThe Game§f:");
					lore9.add("");
					lore9.add("§f- §6Do you want to build ?");
					lore9.add("§f- §6You can in our FreeBuild");
					lore9.add("§f- §6and the only limit is your imagination");
				Fm.setLore(lore9);
				F.setItemMeta(Fm);
				
				ArrayList<String> lore10 = new ArrayList<String>();

				ItemStack c = new ItemStack(Material.APPLE);
				ItemMeta cm = c.getItemMeta();
				cm.setDisplayName("§6§l§kM §b§lClash Of Clans §6§l§kM");
					lore10.add("§aClick to connect");
					lore10.add("§bThe Game§f:");
					lore10.add("");
					lore10.add("§f- §6Like Clash of Clans");
					lore10.add("§f- §6Build, protect, mine");
					lore10.add("§f- §6PvP, and become the most level !");
					lore10.add("§f- §6and be ruthless with others !");
				cm.setLore(lore10);
				c.setItemMeta(cm);
				
				

				

				ItemStack a = new ItemStack(Material.ARROW);
				ItemMeta am = a.getItemMeta();
				am.setDisplayName("§7Go Back");
				a.setItemMeta(am);
				
				ArrayList<String> lore12 = new ArrayList<String>();

				ItemStack am1 = new ItemStack(Material.RAW_FISH, 1, (short) 3);
				ItemMeta amm = am1.getItemMeta();
				amm.setDisplayName("§6Friends§f:");
				lore12.add("§f- §bShows you informations");
				lore12.add("§f- §bcommands for friends.");
				amm.setLore(lore12);

				am1.setItemMeta(amm);
				
				ArrayList<String> lore13 = new ArrayList<String>();

				ItemStack par1 = new ItemStack(Material.BOOK_AND_QUILL);
				ItemMeta parm = par1.getItemMeta();
				parm.setDisplayName("§6Parties§f:");
				lore13.add("§f- §bShows you informations");
				lore13.add("§f- §bcommands for parties.");
				parm.setLore(lore13);

				par1.setItemMeta(parm);
				
				ArrayList<String> lore14 = new ArrayList<String>();

				ItemStack lang1 = new ItemStack(Material.QUARTZ);
				ItemMeta langm = lang1.getItemMeta();
				langm.setDisplayName("§6Language§f:");
				lore14.add("§f- §bClick to enter");
				lore14.add("§f- §bin the language menu.");
				langm.setLore(lore14);

				lang1.setItemMeta(langm);
				

				ItemStack spawn1 = new ItemStack(Material.BED);
				ItemMeta spawnm = spawn1.getItemMeta();
				spawnm.setDisplayName("§6Go back to spawn");
				spawn1.setItemMeta(spawnm);
				
				ArrayList<String> lore15 = new ArrayList<String>();
				ItemStack feather1 = new ItemStack(Material.FEATHER);
				ItemMeta featherm = feather1.getItemMeta();
				featherm.setDisplayName("§6Fly§f:");
				lore15.add("§bClick for§f:");
				lore15.add("§f- §7Activate the fly");
				lore15.add("§f- §7Deactivate the fly");
				featherm.setLore(lore15);

				feather1.setItemMeta(featherm);
				
				ArrayList<String> lore16 = new ArrayList<String>();
				ItemStack cansee1 = new ItemStack(Material.SULPHUR);
				ItemMeta canseem = cansee1.getItemMeta();
				canseem.setDisplayName("§6Vision powder§f:");
				lore16.add("§bHides§f:");
				lore16.add("§f- §7Players (not the staff)");
				lore16.add("§f- §7Particules");
				canseem.setLore(lore16);

				cansee1.setItemMeta(canseem);
				
				ItemStack boutique1 = new ItemStack(Material.EMERALD);
				ItemMeta boutiquem = boutique1.getItemMeta();
				boutiquem.setDisplayName("§6§kMM§r §b§l§nShop§r §6§k§lMM");
				boutique1.setItemMeta(boutiquem);
				
				inv.setItem(1, pt);
				inv.setItem(2, PB);
				inv.setItem(6, isl);
				inv.setItem(7, d);
				inv.setItem(10, pbc);
				inv.setItem(11, pf);
				inv.setItem(15, G);
				inv.setItem(16, pr);
				inv.setItem(19, pfc);
				inv.setItem(24, F);
				inv.setItem(25, c);
				
				inv.setItem(37, am1);
				inv.setItem(43, spawn1);
				inv.setItem(45, a);
				inv.setItem(46, par1);
				inv.setItem(47, lang1);
				inv.setItem(51, feather1);
				inv.setItem(52, cansee1);
				inv.setItem(53, boutique1);
				
				ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
				inv.setItem(4, red);
				inv.setItem(13, red);
				inv.setItem(22, red);
				inv.setItem(31, red);
				inv.setItem(49, red);
				inv.setItem(27, red);
				inv.setItem(28, red);
				inv.setItem(29, red);
				inv.setItem(30, red);
				inv.setItem(31, red);
				inv.setItem(32, red);		
				inv.setItem(33, red);
				inv.setItem(34, red);
				inv.setItem(35, red);
				inv.setItem(39, red);
				inv.setItem(41, red);
				inv.setItem(48, red);
				inv.setItem(50, red);


				p.updateInventory();
				p.openInventory(inv);
			}else if(SQL.getLang(p) == 2){
				Inventory inv = Bukkit.createInventory(p, 54, "§nMenú principal y Juegos");
				
				ArrayList<String> lore0 = new ArrayList<String>();

				ItemStack pt = new ItemStack(Material.WOOD_SWORD);
				ItemMeta ptm = pt.getItemMeta();
				ptm.setDisplayName("§6§6§l§kM §b§lPvP Training §6§6§l§kM");
					lore0.add("§aHaga clic para conectarse");
					lore0.add("§bEl Juego§f:");
					lore0.add("");
					lore0.add("§f- §6Practica tu habilidad en una arena");
					lore0.add("§f- §6Mejora tus cosas gracias a");
					lore0.add("§f- §6Los puntos que usted gana al matar");
					lore0.add("§f- §6y llegar a ser el mejor en el top kill !");
				ptm.setLore(lore0);
				pt.setItemMeta(ptm);
				
				ArrayList<String> lore1 = new ArrayList<String>();

				ItemStack PB = new ItemStack(Material.STONE_SWORD);
				ItemMeta PBm = PB.getItemMeta();
				PBm.setDisplayName("§6§6§l§kM §b§lPvPBox §6§6§l§kM");
					lore1.add("§aHaga clic para conectarse");
					lore1.add("§bEl Juego§f:");
					lore1.add("");
					lore1.add("§f- §6Luchar en una arena");
					lore1.add("§f- §6Gana dinero y cómprate");
					lore1.add("§f- §6los mejores kits para ser el mejor !");
				PBm.setLore(lore1);
				PB.setItemMeta(PBm);
				
				ArrayList<String> lore2 = new ArrayList<String>();

				ItemStack pbc = new ItemStack(Material.IRON_SWORD);
				pbc.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				ItemMeta pbcm = pbc.getItemMeta();
				pbcm.setDisplayName("§6§6§l§kM §b§lPvPBox Cheat §6§6§l§kM");
					lore2.add("§aHaga clic para conectarse");
					lore2.add("§bEl Juego§f:");
					lore2.add("");
					lore2.add("§f- §6Luchar en una arena");
					lore2.add("§f- §6Gana dinero y cómprate");
					lore2.add("§f- §6los mejores kits para ser el mejor !");
				pbcm.setLore(lore2);
				pbc.setItemMeta(pbcm);
				
				ArrayList<String> lore3 = new ArrayList<String>();

				ItemStack pf = new ItemStack(Material.GOLD_SWORD);
				ItemMeta pfm = pf.getItemMeta();
				pfm.setDisplayName("§6§6§l§kM §b§lPvP Faction §6§6§l§kM");
					lore3.add("§aHaga clic para conectarse");
					lore3.add("§bEl Juego§f:");
					lore3.add("");
					lore3.add("§f- §6Crea tu facción y");
					lore3.add("§f- §6luchar contra los otros");
					lore3.add("§f- §6y convertirse en la más famosa facción");
					lore3.add("§f- §6más fuerte del servidor !");
				pfm.setLore(lore3);
				pf.setItemMeta(pfm);
				
				ArrayList<String> lore4 = new ArrayList<String>();

				ItemStack pfc = new ItemStack(Material.DIAMOND_SWORD);
				pfc.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				ItemMeta pfcm = pfc.getItemMeta();
				pfcm.setDisplayName("§6§l§kM §b§lPvP Cheat §6§l§kM");
					lore4.add("§aHaga clic para conectarse");
					lore4.add("§bEl Juego§f:");
					lore4.add("");
					lore4.add("§f- §6Crea tu facción y");
					lore4.add("§f- §6luchar contra los otros");
					lore4.add("§f- §6y convertirse en la más famosa facción");
					lore4.add("§f- §6más fuerte del servidor !");
				pfcm.setLore(lore4);
				pfc.setItemMeta(pfcm);
				
				
				ArrayList<String> lore5 = new ArrayList<String>();

				ItemStack isl = new ItemStack(Material.DIAMOND_PICKAXE);
				ItemMeta islm = isl.getItemMeta();
				islm.setDisplayName("§6§l§kM §b§lIsland Survival §6§l§kM");
					lore5.add("§aHaga clic para conectarse");
					lore5.add("§bEl Juego§f:");
					lore5.add("");
					lore5.add("§f- §6Trata de sobrevivir solo o con tus amigos");
					lore5.add("§f- §6en una isla en el vacío.");
					lore5.add("§f- §6En el logro de las misiones actualizar su nivel y capacidad");
					lore5.add("§f- §6actualizar su nivel y capacidad");
					lore5.add("§f- §6y se convirtió en el más fuerte del servidor!");
				islm.setLore(lore5);
				isl.setItemMeta(islm);
				
				
				ArrayList<String> lore6 = new ArrayList<String>();

				ItemStack d = new ItemStack(Material.DIAMOND);
				ItemMeta dm = d.getItemMeta();
				dm.setDisplayName("§6§l§kM §b§lTheWalkingDead §6§l§kM");
					lore6.add("§aHaga clic para conectarse");
					lore6.add("§bEl Juego§f:");
					lore6.add("");
					lore6.add("§f- §6Trata de sobrevivir frente a");
					lore6.add("§f- §6zombis hordas en lugares famosos de la");
					lore6.add("§f- §6serie TWD, lograr misiones de carácter serie");
					lore6.add("§f- §6carácter serie y desbloquear");
					lore6.add("§f- §6sus kits para convertirse en el mejor !");
				dm.setLore(lore6);
				d.setItemMeta(dm);
				
				
				ArrayList<String> lore7 = new ArrayList<String>();

				ItemStack G = new ItemStack(Material.MINECART);
				ItemMeta Gm = G.getItemMeta();
				Gm.setDisplayName("§6§l§kM §b§lGTA §6§l§kM");
					lore7.add("§aHaga clic para conectarse");
					lore7.add("§bEl Juego§f:");
					lore7.add("");
					lore7.add("§f- §6Vive tu experiencia GTA");
					lore7.add("§f- §6En un mundo libre");
					lore7.add("§f- §6sin reglas !");
				Gm.setLore(lore7);
				G.setItemMeta(Gm);
				
				
				ArrayList<String> lore8 = new ArrayList<String>();

				ItemStack pr = new ItemStack(Material.IRON_FENCE);
				ItemMeta prm = pr.getItemMeta();
				prm.setDisplayName("§6§l§kM §b§lPrison §6§l§kM");
					lore8.add("§aHaga clic para conectarse");
					lore8.add("§bEl Juego§f:");
					lore8.add("");
					lore8.add("§f- §6Trate de escapte de nuestra");
					lore8.add("§f- §6carcel al socavar y convertirse");
					lore8.add("§f- §6el más respetado del servidor!");
				prm.setLore(lore8);
				pr.setItemMeta(prm);
				
				ArrayList<String> lore9 = new ArrayList<String>();

				ItemStack F = new ItemStack(Material.GRASS);
				ItemMeta Fm = F.getItemMeta();
				Fm.setDisplayName("§6§l§kM §b§lFreeBuild §6§l§kM");
					lore9.add("§aHaga clic para conectarse");
					lore9.add("§bEl Juego§f:");
					lore9.add("");
					lore9.add("§f- §6¿Quieres construir ?");
					lore9.add("§f- §6Usted puede en nuestra FreeBuild");
					lore9.add("§f- §6y el único límite es tu imaginación");
				Fm.setLore(lore9);
				F.setItemMeta(Fm);
				
				ArrayList<String> lore10 = new ArrayList<String>();

				ItemStack c = new ItemStack(Material.APPLE);
				ItemMeta cm = c.getItemMeta();
				cm.setDisplayName("§6§l§kM §b§lClash Of Clans §6§l§kM");
					lore10.add("§aHaga clic para conectarse");
					lore10.add("§bEl Juego§f:");
					lore10.add("");
					lore10.add("§f- §6Como Clash of Clans");
					lore10.add("§f- §6Construir, proteger, minar");
					lore10.add("§f- §6PvP, y convertirse en el mayor nivel");
					lore10.add("§f- §6y ser implacable con los otros!");
				cm.setLore(lore10);
				c.setItemMeta(cm);

				

				ItemStack a = new ItemStack(Material.ARROW);
				ItemMeta am = a.getItemMeta();
				am.setDisplayName("§7Volver");
				a.setItemMeta(am);
				
				ArrayList<String> lore12 = new ArrayList<String>();

				ItemStack am1 = new ItemStack(Material.RAW_FISH, 1, (short) 3);
				ItemMeta amm = am1.getItemMeta();
				amm.setDisplayName("§6Amigos§f:");
				lore12.add("§f- §bMuestra los comandos ");
				lore12.add("§f- §bque la información para los amigos.");
				amm.setLore(lore12);

				am1.setItemMeta(amm);
				
				ArrayList<String> lore13 = new ArrayList<String>();

				ItemStack par1 = new ItemStack(Material.BOOK_AND_QUILL);
				ItemMeta parm = par1.getItemMeta();
				parm.setDisplayName("§6Partidos§f:");
				lore13.add("§f- §bMuestra los comandos ");
				lore13.add("§f- §bque la información para los partidos.");
				parm.setLore(lore13);

				par1.setItemMeta(parm);
				
				ArrayList<String> lore14 = new ArrayList<String>();

				ItemStack lang1 = new ItemStack(Material.QUARTZ);
				ItemMeta langm = lang1.getItemMeta();
				langm.setDisplayName("§6Idioma§f:");
				lore14.add("§f- §bHaga clic para entrar");
				lore14.add("§f- §ben el menu de idioma.");
				langm.setLore(lore14);

				lang1.setItemMeta(langm);
				

				ItemStack spawn1 = new ItemStack(Material.BED);
				ItemMeta spawnm = spawn1.getItemMeta();
				spawnm.setDisplayName("§6Volver al spawn");
				spawn1.setItemMeta(spawnm);
				
				ArrayList<String> lore15 = new ArrayList<String>();
				ItemStack feather1 = new ItemStack(Material.FEATHER);
				ItemMeta featherm = feather1.getItemMeta();
				featherm.setDisplayName("§6Fly§f:");
				lore15.add("§bHaga clic para§f:");
				lore15.add("§f- §7Activar el fly");
				lore15.add("§f- §7Desactivar el fly");
				featherm.setLore(lore15);

				feather1.setItemMeta(featherm);
				
				ArrayList<String> lore16 = new ArrayList<String>();
				ItemStack cansee1 = new ItemStack(Material.SULPHUR);
				ItemMeta canseem = cansee1.getItemMeta();
				canseem.setDisplayName("§6Polvo de visión§f:");
				lore16.add("§bEsconde§f:");
				lore16.add("§f- §7Jugadores (no el staff)");
				lore16.add("§f- §7Particules");
				canseem.setLore(lore16);

				cansee1.setItemMeta(canseem);
				
				ItemStack boutique1 = new ItemStack(Material.EMERALD);
				ItemMeta boutiquem = boutique1.getItemMeta();
				boutiquem.setDisplayName("§6§kMM§r §b§l§nTienda§r §6§k§lMM");
				boutique1.setItemMeta(boutiquem);
				
				inv.setItem(1, pt);
				inv.setItem(2, PB);
				inv.setItem(6, isl);
				inv.setItem(7, d);
				inv.setItem(10, pbc);
				inv.setItem(11, pf);
				inv.setItem(15, G);
				inv.setItem(16, pr);
				inv.setItem(19, pfc);
				inv.setItem(24, F);
				inv.setItem(25, c);
				
				inv.setItem(37, am1);
				inv.setItem(43, spawn1);
				inv.setItem(45, a);
				inv.setItem(46, par1);
				inv.setItem(47, lang1);
				inv.setItem(51, feather1);
				inv.setItem(52, cansee1);
				inv.setItem(53, boutique1);

				ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
				inv.setItem(4, red);
				inv.setItem(13, red);
				inv.setItem(22, red);
				inv.setItem(31, red);
				inv.setItem(49, red);
				inv.setItem(27, red);
				inv.setItem(28, red);
				inv.setItem(29, red);
				inv.setItem(30, red);
				inv.setItem(31, red);
				inv.setItem(32, red);		
				inv.setItem(33, red);
				inv.setItem(34, red);
				inv.setItem(35, red);
				inv.setItem(39, red);
				inv.setItem(41, red);
				inv.setItem(48, red);
				inv.setItem(50, red);

				p.updateInventory();
				p.openInventory(inv);
			}
		}
		}
			if(p.getItemInHand().getType() == Material.EMERALD){
				if(SQL.getLang(p) == 0){
					p.sendMessage("§7§m-------------------§r§e§l Boutique §7§m-------------------");
					p.sendMessage("");
					p.sendMessage("§6Grades, kits, serveurs et +");
					p.sendMessage("§6sont disponible sur notre boutique§f:");
					p.sendMessage("");
					p.sendMessage("  §a\u279c §b§nhttp://linaris.fr/store");
					p.sendMessage("");
					p.sendMessage("§7§m--------------------------------------------");
				}else if(SQL.getLang(p) == 1){
					p.sendMessage("§7§m-------------------§r§e§l Shop §7§m-------------------");
					p.sendMessage("");
					p.sendMessage("§6Ranks, kits, servers and more");
					p.sendMessage("§6are disponible on our store§f:");
					p.sendMessage("");
					p.sendMessage("  §a\u279c §b§nhttp://linaris.fr/store");
					p.sendMessage("");
					p.sendMessage("§7§m--------------------------------------------");
				}else if(SQL.getLang(p) == 2){
					p.sendMessage("§7§m-------------------§r§e§l Tienda §7§m-------------------");
					p.sendMessage("");
					p.sendMessage("§6Rangos, kits, servidors y muchos");
					p.sendMessage("§6están disponibles en nuestra tienda§f:");
					p.sendMessage("");
					p.sendMessage("  §a\u279c §b§nhttp://linaris.fr/store");
					p.sendMessage("");
					p.sendMessage("§7§m--------------------------------------------");
				}
			}
			if(is.getType() == Material.DIAMOND_SWORD){
				if(SQL.getLang(p) == 0){
					ItemStack yes = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
					ItemMeta yesm = yes.getItemMeta();
					yesm.setDisplayName("§a§lAccepter et se faire téléporter");
					yes.setItemMeta(yesm);
					
					ItemStack no = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
					ItemMeta nom = no.getItemMeta();
					nom.setDisplayName("§c§lRefuser de se faire téléporter");
					no.setItemMeta(nom);
				
		            p.getInventory().clear();
					p.getInventory().setItem(2, yes);
					p.getInventory().setItem(6, no);
					e.getPlayer().updateInventory();
				}else if(SQL.getLang(p) == 1){
					ItemStack yes = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
					ItemMeta yesm = yes.getItemMeta();
					yesm.setDisplayName("§a§lAccept and being teleported");
					yes.setItemMeta(yesm);
					
					ItemStack no = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
					ItemMeta nom = no.getItemMeta();
					nom.setDisplayName("§c§lRefuse to be teleported");
					no.setItemMeta(nom);
				
		            p.getInventory().clear();
					p.getInventory().setItem(2, yes);
					p.getInventory().setItem(6, no);
					e.getPlayer().updateInventory();
				}else if(SQL.getLang(p) == 2){
					ItemStack yes = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
					ItemMeta yesm = yes.getItemMeta();
					yesm.setDisplayName("§a§lAceptar y ser teletransportado");
					yes.setItemMeta(yesm);
					
					ItemStack no = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
					ItemMeta nom = no.getItemMeta();
					nom.setDisplayName("§c§lNegarse a ser teletransportado");
					no.setItemMeta(nom);
				
		            p.getInventory().clear();
					p.getInventory().setItem(2, yes);
					p.getInventory().setItem(6, no);
					e.getPlayer().updateInventory();
				}
			}
				if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName()
						.equals("§a§lAccepter et se faire téléporter") || e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName()
						.equals("§a§lAccept and being teleported") || e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName()
						.equals("§a§lAceptar y ser teletransportado")){
					
					if(SQL.getLang(p) == 0){
						p.sendMessage("§f[§ePvP§f] §aTu es maintenant dans l'arene PvP !");
					}else if(SQL.getLang(p) == 1){
						p.sendMessage("§f[§ePvP§f] §aYour are now in the PvP Arena !");

					}else if(SQL.getLang(p) == 2){
						p.sendMessage("§f[§ePvP§f] §aAhora se encuentra en el PvP Arena !");

					}
					
		    		
					p.setAllowFlight(false);
		    		p.setFlying(false);
					
					e.getPlayer().getInventory().clear();
		    		
		    		p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD, 1));
		    		p.getInventory().setItem(1, new ItemStack(Material.IRON_HELMET, 1));
		    		p.getInventory().setItem(2, new ItemStack(Material.IRON_CHESTPLATE, 1));
		    		p.getInventory().setItem(3, new ItemStack(Material.IRON_LEGGINGS, 1));
		    		p.getInventory().setItem(4, new ItemStack(Material.IRON_BOOTS, 1));
		    		p.getInventory().setItem(6, new ItemStack(Material.GOLDEN_APPLE, 5));
		    		
		    		
					e.getPlayer().updateInventory();
					
					Location location = p.getLocation();
		            location.setX(-2134);
		            location.setY(154);
		            location.setZ(-352);
		            location.setYaw((float) -44.1);
		            location.setPitch((float) 4.2);
				p.teleport(location);
				
				PotionEffect blind = PotionEffectType.BLINDNESS.createEffect(100, 100);
		        p.addPotionEffect(blind, true);
					
				}
				if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName()
						.equals("§c§lRefuser de se faire téléporter") || e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName()
						.equals("§c§lRefuse to be teleported") || e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName()
						.equals("§c§lNegarse a ser teletransportado")){
					
					e.getPlayer().getInventory().clear();
					
					
					
		    		PlayerInventory.getInstance().PlayerInv(p);
					
		    		e.getPlayer().updateInventory();
					
				}
			
			if(is.getType() == Material.NETHER_STAR){
				Bukkit.dispatchCommand(p, "shop");
			}
		
		
			
	}
	
	public static ItemStack itemNamed(Material type, String name) {
		  ItemStack is = new ItemStack(type);
		  ItemMeta im = is.getItemMeta();
		  im.setDisplayName(name);
		  is.setItemMeta(im);
		  return is;
		 }
   
    
	@EventHandler
	public void InventoryIn(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§l§kM §b§lEnglish §6§l§kM")){
			SQL.setLang(1, p);
			PlayerInventory.getInstance().PlayerInvChangeLang(p);
			p.sendMessage("§f[§eLang§f] §aYour language is now §cEnglish");
			p.closeInventory();
		}
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§l§kM §b§lFrançais §6§l§kM")){
			SQL.setLang(0, p);
			PlayerInventory.getInstance().PlayerInvChangeLang(p);
			p.sendMessage("§f[§eLang§f] §aTa langue est maintenant le §cFrançais");


			p.closeInventory();
		}
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§l§kM §b§lEspañol §6§l§kM")){
			SQL.setLang(2, p);
			PlayerInventory.getInstance().PlayerInvChangeLang(p);
			p.sendMessage("§f[§eLang§f] §aSu lenguaje es ahora §cEspañol");

			p.closeInventory();
		}
		if(e.getInventory().getName().equalsIgnoreCase("§nMain Menu & Games") || e.getInventory().getName().equalsIgnoreCase("§n§nMenú principal y Juegos") || e.getInventory().getName().equalsIgnoreCase("§nMenu principal & Jeux")){
			switch(e.getCurrentItem().getType()){
				case WOOD_SWORD:
					Utils.sendPlayerTo(p, "PvPTraining");
					p.closeInventory();
					break;
				case STONE_SWORD:
					Utils.sendPlayerTo(p, "PvPBox");
					p.closeInventory();
					break;
				case IRON_SWORD:
					Utils.sendPlayerTo(p, "PvPBoxCheat");
					p.closeInventory();
					break;
				case GOLD_SWORD:
			Utils.sendPlayerTo(p, "PvPFaction");
			p.closeInventory();
			break;
		case DIAMOND_SWORD:
			Utils.sendPlayerTo(p, "PvPCheat");
			p.closeInventory();
			break;
		case DIAMOND_PICKAXE:
			Utils.sendPlayerTo(p, "IslandSurvival");
			p.closeInventory();
			break;
		case DIAMOND:
			Utils.sendPlayerTo(p, "TheWalkingDead");
			p.closeInventory();
			break;
		case MINECART:
			Utils.sendPlayerTo(p, "GTA");
			p.closeInventory();
			break;
		case IRON_FENCE:
			Utils.sendPlayerTo(p, "Prison");
			p.closeInventory();
			break;
		case GRASS:
			Utils.sendPlayerTo(p, "FreeBuild");
			p.closeInventory();
			break;
		case APPLE:
			Utils.sendPlayerTo(p, "ClashOfClans");
			p.closeInventory();
			break;
		case ARROW:
			p.closeInventory();
			break;
		case RAW_FISH:
			Bukkit.dispatchCommand(p, "friends");
			p.closeInventory();
			break;
		case BOOK_AND_QUILL:
			Bukkit.dispatchCommand(p, "party");
			p.closeInventory();
			break;
		case BED:
			Bukkit.dispatchCommand(p, "spawn");
			
			p.closeInventory();
			break;
		case FEATHER:
			Bukkit.dispatchCommand(p, "fly");
			p.closeInventory();
			break;
		case SULPHUR:
			Bukkit.dispatchCommand(p, "hide");
			p.closeInventory();
			break;
		case EMERALD:
			if(SQL.getLang(p) == 0){
				p.sendMessage("§7§m-------------------§r§e§l Boutique §7§m-------------------");
				p.sendMessage("");
				p.sendMessage("§6Grades, kits, serveurs et +");
				p.sendMessage("§6sont disponible sur notre boutique§f:");
				p.sendMessage("");
				p.sendMessage("  §a\u279c §b§nhttp://linaris.fr/store");
				p.sendMessage("");
				p.sendMessage("§7§m--------------------------------------------");
			}else if(SQL.getLang(p) == 1){
				p.sendMessage("§7§m-------------------§r§e§l Shop §7§m-------------------");
				p.sendMessage("");
				p.sendMessage("§6Ranks, kits, servers and more");
				p.sendMessage("§6are disponible on our store§f:");
				p.sendMessage("");
				p.sendMessage("  §a\u279c §b§nhttp://linaris.fr/store");
				p.sendMessage("");
				p.sendMessage("§7§m--------------------------------------------");
			}else if(SQL.getLang(p) == 2){
				p.sendMessage("§7§m-------------------§r§e§l Tienda §7§m-------------------");
				p.sendMessage("");
				p.sendMessage("§6Rangos, kits, servidors y muchos");
				p.sendMessage("§6están disponibles en nuestra tienda§f:");
				p.sendMessage("");
				p.sendMessage("  §a\u279c §b§nhttp://linaris.fr/store");
				p.sendMessage("");
				p.sendMessage("§7§m--------------------------------------------");
			}
			p.closeInventory();
			break;
		
		}
	}
		e.setCancelled(true);
		
	}
	
}
