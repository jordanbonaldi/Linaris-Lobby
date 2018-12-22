package net.neferett.lobby.Listener;

import net.neferett.lobby.Manager.FileManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener
{
  private final FileManager fileManager;

  public PlayerQuitEvent(FileManager fileManager)
  {
    this.fileManager = fileManager;
  }

  @EventHandler
  public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent e) {
	  Player p = e.getPlayer();
    fileManager.removePlayerAsyncDelayed(e.getPlayer().getName());
    e.setQuitMessage(null);

  }
}