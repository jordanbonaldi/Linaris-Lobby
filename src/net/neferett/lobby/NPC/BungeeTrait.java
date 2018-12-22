package net.neferett.lobby.NPC;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.util.DataKey;
import net.neferett.lobby.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;

public class BungeeTrait extends Trait
{
	public boolean ok = false;
  private Hologram m_title;
  private String m_name;
  private List<ServerInfo> m_servers = new LinkedList();

  private ServerInfo m_lastServer = new ServerInfo("UNKNOW_SERVER");

  private static BungeeTrait instance;
  public static BungeeTrait getInstance(){
	  if(instance == null) new BungeeTrait();
	  return instance;
  }
  public BungeeTrait() {
    super("BungeeTrait");
  }

  public void load(DataKey key) {
    if (key.keyExists("name")) this.m_name = key.getString("name");

    if (key.keyExists("servers"))
      for (DataKey server_data : key.getRelative("servers").getSubKeys()) {
        ServerInfo info = new ServerInfo(
          server_data.getPath().substring(server_data.getPath().lastIndexOf(".") + 1));

        String ip = server_data.getString("ip");
        int port = server_data.getInt("port");
        try
        {
          info.setAddress(new InetSocketAddress(InetAddress.getByName(ip), port));
          this.m_servers.add(info);
        } catch (UnknownHostException e) {
          e.printStackTrace();
        }
        catch (NullPointerException e) {
          Bukkit.getConsoleSender().sendMessage("NullPointerException ignored (BungeeSignsPlugin:onEnable)");
        }
      }
  }

  public void save(DataKey key)
  {
    key.setString("name", this.m_name);
    for (ServerInfo info : this.m_servers) {
      key.setString("servers." + info.getName() + ".ip", info.getAddress().getHostName());
      key.setInt("servers." + info.getName() + ".port", info.getAddress().getPort());
    }
  }

  public List<ServerInfo> getServers() { return this.m_servers; }

  public void teleport(Player player) {
    if ((this.m_lastServer == null) || (!this.m_lastServer.canJoin())) update();

    if ((this.m_lastServer != null) && (this.m_lastServer.canJoin())) {
  	      player.sendMessage(Utils.colorize(new Object[] { "&a&oTransfert vers le serveur &e&o" + this.m_lastServer.getName() }));

  	      Utils.sendPlayerTo(player, this.m_lastServer.getName());
    }
    else {
        player.sendMessage(ChatColor.RED + "Aucun serveur disponible, patientez quelques secondes ...");
    }
      	   
  }

  public ServerInfo getServerInfo(String serverName) {
    for (ServerInfo server : this.m_servers) {
      if (server.getName().equalsIgnoreCase(serverName)) return server;
    }
    return null;
  }

  public void onSpawn()
  {
    if (this.m_name == null) this.m_name = getNPC().getName();

    Location loc = ((LivingEntity)getNPC().getEntity()).getEyeLocation().add(0.0D, 1.7D, 0.0D);
    if (getNPC().getEntity().getType() == EntityType.WITCH) loc.add(0.0D, 0.2D, 0.0D);
    this.m_title = HologramsAPI.createHologram(Main.getInstance(), loc);
    this.m_title.setAllowPlaceholders(true);
    Main.m_traits.add(this);

    update();
  }

  public void onDespawn()
  {
    this.m_title.delete();
    this.m_title = null;
  }

  public void update() {
    Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable()
    {
      public void run() {
        boolean search = true;
        if (BungeeTrait.this.m_lastServer != null) {
          BungeeTrait.this.m_lastServer.ping();
          if (BungeeTrait.this.m_lastServer.canJoin()) search = false;
        }

        if (search) {
          String srvName = BungeeTrait.this.m_lastServer == null ? "" : BungeeTrait.this.m_lastServer.getName();
          for (ServerInfo server : BungeeTrait.this.m_servers)
            if (!server.getName().equalsIgnoreCase(srvName)) {
              server.ping();
              if (server.canJoin())
                break;
            }
        }
      }
    });
    ServerInfo srv = null;
    for (ServerInfo server : this.m_servers) {
      if (server.canJoin()) {
        srv = server;
        break;
      }
    }

    if (!isSrvEqual(srv, this.m_lastServer)) {
      this.m_lastServer = srv;
      try {
        	this.m_title.clearLines();
            if (this.m_lastServer == null) {
                this.m_title.appendTextLine(this.m_name);
                this.m_title.appendTextLine(ChatColor.RED + "Recherche...");
              }
              else {
                this.m_title.appendTextLine(Utils.colorize(new Object[] { "&e", this.m_name, " &f- (&6Clic-Droit&f)" }));
                this.m_title.appendTextLine(Utils.colorize(new Object[] { "&b…tat du jeu&f:" }));
                this.m_title.appendTextLine("{motd: " + this.m_lastServer.getName() + "}");
                this.m_title.appendTextLine(Utils.colorize(new Object[] { "&a{online: " + this.m_lastServer.getName() + 
                  "}&r/&a{max_players: " + this.m_lastServer.getName() + "}" }));
              }
	} catch (Exception e) {

	}



    
	  }
	  
  }

  private boolean isSrvEqual(ServerInfo srv1, ServerInfo srv2) {
    if ((srv1 == null) && (srv2 == null)) return true;
    if ((srv1 == null) || (srv2 == null)) return false;

    return srv1.getName().equalsIgnoreCase(srv2.getName());
  }
  public enum UpdateState
  {
    PLAYER(true), NOPLAYER(false);

    private boolean canJoin;
    private static UpdateState currentState;

    private UpdateState(boolean arg3)
    {
      boolean bool = false;
      this.canJoin = bool;
    }

    public boolean canJoin()
    {
      return this.canJoin;
    }

    public static void setState(UpdateState paramGameState)
    {
      currentState = paramGameState;
    }

    public static boolean isState(UpdateState paramGameState)
    {
      return currentState == paramGameState;
    }

    public static UpdateState getState()
    {
      return currentState;
    }
  }
  
}