package net.neferett.lobby;

import java.util.LinkedList;
import java.util.List;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.trait.TraitInfo;
import net.neferett.lobby.Commands.CommandBungeeNPC;
import net.neferett.lobby.Commands.CommandFly;
import net.neferett.lobby.Commands.CommandHide;
import net.neferett.lobby.Commands.CommandSpawn;
import net.neferett.lobby.Commands.Portals;
import net.neferett.lobby.Database.SQL;
import net.neferett.lobby.Listener.BungeeNPCListener;
import net.neferett.lobby.Listener.ChatListener;
import net.neferett.lobby.Listener.InteractListener;
import net.neferett.lobby.Listener.PlayerJoinEvent;
import net.neferett.lobby.Listener.PlayerMoveEvents;
import net.neferett.lobby.Listener.WorldListener;
import net.neferett.lobby.Manager.FileManager;
import net.neferett.lobby.NPC.BungeeTrait;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	private Location loc;
	
	  public static List<BungeeTrait> m_traits = new LinkedList();
	  private static Main instance;
	
	  public static Main getInstance()
	  {
	    return instance;
	  }
	  private FileManager fileManager;

	public void onEnable(){
		SQL.connect();
	    instance = this;

	    saveDefaultConfig();

	    if ((getServer().getPluginManager().getPlugin("Citizens") == null) || 
	      (!getServer().getPluginManager().getPlugin("Citizens").isEnabled())) {
	      System.out.println("Citizens 2.0 not found or not enabled");
	      getServer().getPluginManager().disablePlugin(this);
	      return;
	    }

	    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

	    CitizensAPI.getTraitFactory().registerTrait(TraitInfo.create(BungeeTrait.class).withName("BungeeTrait"));

	    getCommand("bungeenpc").setExecutor(new CommandBungeeNPC());
	    getCommand("fly").setExecutor(new CommandFly());
	    getCommand("hide").setExecutor(new CommandHide());
	    getCommand("spawn").setExecutor(new CommandSpawn());

	    getServer().getPluginManager().registerEvents(new BungeeNPCListener(), this);
	    getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
	    getServer().getPluginManager().registerEvents(new WorldListener(), this);
	    getServer().getPluginManager().registerEvents(new PlayerMoveEvents(), this);
	    getServer().getPluginManager().registerEvents(new InteractListener(), this);
	    getServer().getPluginManager().registerEvents(new ChatListener(), this);
	    getCommand("portails").setExecutor(new Portals());
	    getServer().getPluginManager().registerEvents(new net.neferett.lobby.Listener.PlayerQuitEvent(new FileManager(this)), this);
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable()
		    {
		      public void run() {
		        for (BungeeTrait trait : Main.m_traits){
		          trait.update();
		        }
		      }
		    }
		    , 60L, 60L);

	}
	

	
	
}
