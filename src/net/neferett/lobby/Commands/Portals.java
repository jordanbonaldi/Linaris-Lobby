package net.neferett.lobby.Commands;

import net.neferett.lobby.Manager.PortalCreationManager;
import net.neferett.lobby.Manager.PortalsManager;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Portals
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player)) sender.sendMessage(ChatColor.DARK_RED + "Vous devez être un joueur !");
    if (!sender.isOp()) sender.sendMessage(ChatColor.DARK_RED + "Vous devez être op !");

    Player player = (Player)sender;

    if (args.length >= 2) {
      if (args[0].equalsIgnoreCase("create")) {
        String dest = args[1];
        PortalCreationManager.getInstance().addCreator(player, dest);
        return true;
      }
    }
    else {
      Location lp = player.getLocation();
      player.sendMessage("Location : X = " + lp.getBlockX() + " ; Y = " + lp.getBlockY() + " ; Z = " + lp.getBlockZ());
      player.sendMessage("");

      for (PortalsManager.Portal portal : PortalsManager.getInstance().getPortals()) {
        Location l1 = portal.getLoc1();
        Location l2 = portal.getLoc2();

        player.sendMessage("---------------- " + portal.getDest() + " ----------------");
        player.sendMessage("L1 : X = " + l1.getBlockX() + " ; Y = " + l1.getBlockY() + " ; Z = " + l1.getBlockZ());
        player.sendMessage("L2 : X = " + l2.getBlockX() + " ; Y = " + l2.getBlockY() + " ; Z = " + l2.getBlockZ());
        player.sendMessage("------------------------------------------------");
        player.sendMessage("");
      }
      return true;
    }

    return false;
  }
}