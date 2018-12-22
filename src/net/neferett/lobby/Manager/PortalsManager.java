package net.neferett.lobby.Manager;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import net.neferett.lobby.Main;
import net.neferett.lobby.Utils.Utils;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PortalsManager
{
  private List<Portal> m_portals = new LinkedList();

  private static PortalsManager instance = null;

  public static PortalsManager getInstance() { if (instance == null) instance = new PortalsManager();
    return instance; }

  private PortalsManager()
  {
    File dirs = new File("plugins/" + Main.getInstance().getName() + "/portals");
    dirs.mkdirs();

    File[] listFile = dirs.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".yml");
      }
    });
    List deletes = new LinkedList();

    for (File file : listFile) {
      FileConfiguration config = YamlConfiguration.loadConfiguration(file);

      Location loc1 = Utils.getLocation(config.getConfigurationSection("loc1"));
      Location loc2 = Utils.getLocation(config.getConfigurationSection("loc2"));

      if (!loc1.getWorld().equals(loc2.getWorld())) {
        deletes.add(file);
      }
      else
      {
        this.m_portals.add(new PortalsManager.Portal(loc1, loc2, config.getString("dest")));
      }
    }
    for (int i = 0; i < deletes.size(); i++) {
      File file = (File)deletes.get(i);
      deletes.remove(i);
      file.delete();
      i--;
    }
  }

  public void createPortal(Location loc1, Location loc2, String dest) {
    File file = new File("plugins/" + Main.getInstance().getName() + "/portals/" + UUID.randomUUID().toString() + ".yml");
    try {
      file.createNewFile();

      FileConfiguration config = YamlConfiguration.loadConfiguration(file);
      Utils.setLocation(config.createSection("loc1"), loc1);
      Utils.setLocation(config.createSection("loc2"), loc2);
      config.set("dest", dest);
      config.save(file);

      this.m_portals.add(new PortalsManager.Portal(loc1, loc2, dest)); } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Portal getPortal(Location loc) {
    for (Portal portal : this.m_portals) {
      if (portal.isInPortal(loc)) return portal;
    }
    return null;
  }
  public List<Portal> getPortals() {
    return this.m_portals;
  }
  public class Portal { private Location m_loc1;
    private Location m_loc2;
    private String m_dest;

    private Portal(Location loc1, Location loc2, String dest) { this.m_loc1 = new Location(loc1.getWorld(), 
        loc1.getBlockX() <= loc2.getBlockX() ? loc1.getBlockX() : loc2.getBlockX(), 
        loc1.getBlockY() <= loc2.getBlockY() ? loc1.getBlockY() : loc2.getBlockY(), 
        loc1.getBlockZ() <= loc2.getBlockZ() ? loc1.getBlockZ() : loc2.getBlockZ());

      this.m_loc2 = new Location(loc2.getWorld(), 
        loc1.getBlockX() >= loc2.getBlockX() ? loc1.getBlockX() : loc2.getBlockX(), 
        loc1.getBlockY() >= loc2.getBlockY() ? loc1.getBlockY() : loc2.getBlockY(), 
        loc1.getBlockZ() >= loc2.getBlockZ() ? loc1.getBlockZ() : loc2.getBlockZ());

      this.m_dest = dest; }

    public boolean isInPortal(Location loc)
    {
      if (!loc.getWorld().equals(this.m_loc1.getWorld())) return false;

      return (loc.getBlockX() >= this.m_loc1.getBlockX()) && (loc.getBlockX() <= this.m_loc2.getBlockX()) && 
        (loc.getBlockY() >= this.m_loc1.getBlockY()) && (loc.getBlockY() <= this.m_loc2.getBlockY()) && 
        (loc.getBlockZ() >= this.m_loc1.getBlockZ()) && (
        loc.getBlockZ() <= this.m_loc2.getBlockZ());
    }
    public Location getLoc1() {
      return this.m_loc1; } 
    public Location getLoc2() { return this.m_loc2; } 
    public String getDest() { return this.m_dest; }

  }
}