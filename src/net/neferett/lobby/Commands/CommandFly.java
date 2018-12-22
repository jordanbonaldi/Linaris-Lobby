package net.neferett.lobby.Commands;

import net.neferett.lobby.Database.SQL;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {
	
	 public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		    if ((sender instanceof Player)) {
		      if (cmd.getName().equalsIgnoreCase("fly")) {
		        Player player = (Player)sender;
		        if (args.length == 0) {
		            if (!player.getAllowFlight()) {
		            	if(SQL.getLang(player) == 0){
				              player.sendMessage(ChatColor.GOLD + "Tu peux maitenant voler :) !");
		            	}else if(SQL.getLang(player) == 1){
				              player.sendMessage(ChatColor.GOLD + "You can now fly :) !");
		            	}else if(SQL.getLang(player) == 2){
				              player.sendMessage(ChatColor.GOLD + "Ahora puede volar :) !");
		            	}
		              player.setAllowFlight(true);
		            } else {
		            	if(SQL.getLang(player) == 0){
				              player.sendMessage(ChatColor.GOLD + "Tu peux maitenant voler !");

		            	}else if(SQL.getLang(player) == 1){
				              player.sendMessage(ChatColor.GOLD + "You can no longer fly !");

		            	}else if(SQL.getLang(player) == 2){
				              player.sendMessage(ChatColor.GOLD + "Ya no se puede volar !");

		            	}
		              player.setAllowFlight(false);
		            }
		        }
		          
		        }
		      }
			return false;
	
	

	 }

}
