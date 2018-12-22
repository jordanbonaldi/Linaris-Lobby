package net.neferett.lobby.Manager;

import java.io.File;
import java.util.HashSet;

import net.neferett.lobby.Main;

import org.bukkit.scheduler.BukkitTask;

public class FileManager
{
  private final Main instance;
  private final HashSet<File> playerDataFolders;

  public FileManager(Main plugin)
  {
    this.instance = plugin;
    this.playerDataFolders = new HashSet();
    addDataFolders();
  }

  private void addDataFolders() {
      File dataFolder = getDataFolder("world");
      if (dataFolder.exists())
        this.playerDataFolders.add(dataFolder);
    
  }

  private File getDataFolder(String worldName) {
    File worldFolder = new File(this.instance.getServer().getWorldContainer().getPath() + File.separatorChar + worldName);
    return new File(worldFolder.getPath() + File.separatorChar + "players");
  }

  private File getPlayerFile(File dataFolder, String playerName) {
    return new File(dataFolder.getPath() + File.separatorChar + playerName + ".dat");
  }

  void removePlayerFile(String playerName) {
    for (File file : this.playerDataFolders) {
      File playerFile = getPlayerFile(file, playerName);
      playerFile.delete();
    }
  }

  public void removePlayerAsyncDelayed(final String playerName) {
    BukkitTask bukkitTask = this.instance.getServer().getScheduler().runTaskLaterAsynchronously(this.instance, new Runnable()
    {
      public void run() {
        FileManager.this.removePlayerFile(playerName);
      }
    }
    , 60L);
  }
}