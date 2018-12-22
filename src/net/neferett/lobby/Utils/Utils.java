package net.neferett.lobby.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

public class Utils
{
  public static Location getLocation(ConfigurationSection section)
  {
    try
    {
      return new Location(Bukkit.getWorld(section.getString("world")), 
        section.getDouble("x"), section.getDouble("y"), section.getDouble("z"));
    } catch (Exception e) {
    }
    return null;
  }

  public static void setLocation(ConfigurationSection section, Location loc) {
    try {
      section.set("world", loc.getWorld().getName());
      section.set("x", Double.valueOf(loc.getX()));
      section.set("y", Double.valueOf(loc.getY()));
      section.set("z", Double.valueOf(loc.getZ()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}