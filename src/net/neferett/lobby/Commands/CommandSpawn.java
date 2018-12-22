package net.neferett.lobby.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {
	
	 public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
			if (cmd.getName().equalsIgnoreCase("spawn")) {
				
				Player p = (Player) sender;
				
				Location location = p.getLocation();
				location.setX(-2186.673);
				location.setY(161);
				location.setZ(-451.508);
				location.setYaw((float) 86.2);
				location.setPitch((float) 2.2);
				p.teleport(location);
				
					}
				
			
			
				return true;

		}
}
