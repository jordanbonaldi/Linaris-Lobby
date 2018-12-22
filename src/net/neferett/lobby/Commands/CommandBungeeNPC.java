package net.neferett.lobby.Commands;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import net.citizensnpcs.Citizens;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.neferett.lobby.Main;
import net.neferett.lobby.NPC.BungeeTrait;
import net.neferett.lobby.NPC.ServerInfo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class CommandBungeeNPC
  implements CommandExecutor, PluginMessageListener
{
  public CommandBungeeNPC()
  {
    Bukkit.getMessenger().registerIncomingPluginChannel(Main.getInstance(), "BungeeCord", this);
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player)) return false;

    if ((cmd.getName().equals("bungeenpc")) && (args.length > 0)) {
      NPC npc = ((Citizens)CitizensAPI.getPlugin()).getNPCSelector().getSelected(sender);
      if (npc == null) {
        sender.sendMessage(ChatColor.RED + "Vous devez sélétionner un npc");
        return true;
      }
      if (!npc.hasTrait(BungeeTrait.class)) npc.addTrait(BungeeTrait.class);

      BungeeTrait trait = (BungeeTrait)npc.getTrait(BungeeTrait.class);
      trait.getServers().clear();

      for (int i = 0; i < args.length; i++) {
        trait.getServers().add(new ServerInfo(args[i]));
        requestServerToBungee((Player)sender, args[i]);
      }

      sender.sendMessage(ChatColor.GREEN + "NPC affecté !");
    }
    return false;
  }

  public void onPluginMessageReceived(String channel, Player player, byte[] message)
  {
    if (!channel.equals("BungeeCord")) return;
    ByteArrayDataInput in = ByteStreams.newDataInput(message);
    String subchannel = in.readUTF();
    if (subchannel.equals("ServerIP")) {
      String serverName = in.readUTF();
      String ip = in.readUTF();
      short port = in.readShort();

      for (BungeeTrait trait : Main.m_traits) {
        ServerInfo serverInfo = trait.getServerInfo(serverName);
        if (serverInfo != null)
          try
          {
            serverInfo.setAddress(new InetSocketAddress(InetAddress.getByName(ip), port));
          } catch (UnknownHostException e) {
            e.printStackTrace();
          }
      }
    }
  }

  private boolean requestServerToBungee(Player sender, String server) {
    ByteArrayDataOutput out = ByteStreams.newDataOutput();
    out.writeUTF("ServerIP");
    out.writeUTF(server);
    sender.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    return true;
  }
}