package net.neferett.lobby.NPC;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.bukkit.ChatColor;

import net.neferett.lobby.ping.MinecraftPing;
import net.neferett.lobby.ping.MinecraftPingOptions;
import net.neferett.lobby.ping.MinecraftPingReply;

public class ServerInfo
{
  private boolean online;
  private String name;
  private String description;
  private int onlinePlayers;
  private int maxPlayers;
  private InetSocketAddress address;

  public ServerInfo(String name)
  {
    this.name = name;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.name).append(" = ").append(this.address.getHostString()).append(":").append(this.address.getPort());
    return sb.toString();
  }
  public String getName() {
    return this.name; } 
  public String getDescription() { return this.description; } 
  public int getOnlinePlayers() { return this.onlinePlayers; } 
  public int getMaxPlayers() { return this.maxPlayers; }

  public void setAddress(InetSocketAddress address) {
    this.address = address;
  }
  public InetSocketAddress getAddress() {
    return this.address;
  }
  public boolean canJoin() {
    return (this.online) && (this.address != null) && (this.description != null) && 
      (getOnlinePlayers() < getMaxPlayers()) && 
      (!this.description.startsWith(ChatColor.RED.toString())) && 
      (!this.description.startsWith(ChatColor.YELLOW.toString())) && 
      (!this.description.startsWith(ChatColor.DARK_RED.toString()));
  }

  public void ping() {
    if (this.address == null) return;

    MinecraftPing ping = new MinecraftPing();
    try {
      MinecraftPingReply reply = ping.getPing(new MinecraftPingOptions()
        .setHostname(this.address.getHostName())
        .setPort(this.address.getPort()));

      this.online = true;
      this.description = reply.getDescription();
      this.onlinePlayers = reply.getPlayers().getOnline();
      this.maxPlayers = reply.getPlayers().getMax();
    } catch (IOException e) {
      this.online = false;
      this.description = "A Minecraft Server";
      this.onlinePlayers = -1;
      this.maxPlayers = 20;
    }
  }
}