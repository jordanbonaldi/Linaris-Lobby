package net.neferett.lobby.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import be.maximvdw.placeholderapi.PlaceholderAPI;

public class ChatListener implements Listener{


    

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if(player.getName().equals("Neferett")){
		event.setFormat("[§eLvl §b"+PlaceholderAPI.replacePlaceholders(player, "{mysql_level}") +"§f] §f[§cFondateur§f] §b" + player.getName()+"§f: §c"+ event.getMessage());
		}else if(player.hasPermission("game.megavip")) {
			event.setFormat("[§eLvl §b"+PlaceholderAPI.replacePlaceholders(player, "{mysql_level}") +"§f] §f[§aMegaVip§f] §a" + player.getName()+"§f: "+ event.getMessage());
		}else if(player.hasPermission("game.vip")){
			event.setFormat("[§eLvl §b"+PlaceholderAPI.replacePlaceholders(player, "{mysql_level}") +"§f] §f[§eVip§f] §e" + player.getName()+"§f: "+ event.getMessage());
			
		}else if(player.hasPermission("game.modo")){
			event.setFormat("[§eLvl §b"+PlaceholderAPI.replacePlaceholders(player, "{mysql_level}") +"§f] §f[§6Modo§f] §6" + player.getName()+"§f: §c"+ event.getMessage());
			
		}else if(player.hasPermission("game.admin")){
			event.setFormat("[§eLvl §b"+PlaceholderAPI.replacePlaceholders(player, "{mysql_level}") +"§f] §f[§cAdmin§f] §c" + player.getName()+"§f: §c"+ event.getMessage());
		}
			else if(player.hasPermission("game.vipelite")) {
				event.setFormat("[§eLvl §b"+PlaceholderAPI.replacePlaceholders(player, "{mysql_level}") +"§f] §f[§bVipElite§f] §b" + player.getName()+"§f: " + event.getMessage());
			
		}else{
			event.setFormat("[§eLvl §b"+PlaceholderAPI.replacePlaceholders(player, "{mysql_level}") +"§f] [§eHub§f] §7" + player.getName()+"§f: "+ event.getMessage());
			
			
		}
	}

}
