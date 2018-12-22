package net.neferett.lobby.Commands;

import net.neferett.lobby.Database.SQL;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandHide implements CommandExecutor{
	
	 public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
			if (cmd.getName().equalsIgnoreCase("hide")) {
				
				Player p = (Player) sender;
				
				boolean show = false;
				
				for(Player pl : Bukkit.getOnlinePlayers()){
					if(p.canSee(pl)){
						if(!pl.hasPermission("game.modo") || pl.hasPermission("game.admin") || pl.isOp()){
							
							p.hidePlayer(pl);
							PotionEffect blind = PotionEffectType.BLINDNESS.createEffect(50, 100);
					        p.addPotionEffect(blind, true);
							
							}else{
								p.showPlayer(pl);
							}
						
					}
					else{
						PotionEffect blind = PotionEffectType.BLINDNESS.createEffect(50, 100);
				        p.addPotionEffect(blind, true);
						p.showPlayer(pl);
						show = true;
						
					}
					
				}

				if(show){
	            	if(SQL.getLang(p) == 0){
						p.sendMessage("§aLes joueurs sont maintenant affichés !");
	            	}else if(SQL.getLang(p) == 1){
						p.sendMessage("§aPlayers are no longer hidden !");
	            	}else if(SQL.getLang(p) == 2){
	            		p.sendMessage("§aLos jugadores ya no se ocultan !");
	            	}
				}
				else{
	            	if(SQL.getLang(p) == 0){
						p.sendMessage("§aLes joueurs sont maintenant affichés !");
	            	}else if(SQL.getLang(p) == 1){
						p.sendMessage("§aPlayers are now hidden !");
	            	}else if(SQL.getLang(p) == 2){
	            		p.sendMessage("§aLos jugadores están ahora ocultos !");
	            	}				}
				
			}
			
				return true;

		}
}
