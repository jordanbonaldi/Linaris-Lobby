package net.neferett.lobby.Manager;

import java.util.LinkedList;
import java.util.List;

import net.neferett.lobby.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PortalCreationManager
  implements Listener
{
  private List<PortalCreator> m_portalCreators = new LinkedList();
  private static PortalCreationManager instance;

  public static PortalCreationManager getInstance()
  {
    if (instance == null) instance = new PortalCreationManager();
    return instance;
  }

  private PortalCreationManager() {
    Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
  }

  public void addCreator(Player player, String dest) {
    this.m_portalCreators.add(new PortalCreator(player, dest));
  }

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event)
  {
    for (int i = 0; i < this.m_portalCreators.size(); i++) {
      ((PortalCreator)this.m_portalCreators.get(i)).onBlockPlace(event);
      if (((PortalCreator)this.m_portalCreators.get(i)).isFinish()) {
        this.m_portalCreators.remove(i);
        i--;
      }
    }
  }

  public static enum CreationEtapes
  {
    POS1(ChatColor.DARK_GREEN + "Poser le block à la position 1"), 
    POS2(ChatColor.DARK_GREEN + "Poser le block à la position 2"), 
    END(ChatColor.DARK_GREEN + "Portail crée");

    private String m_msg;

    private CreationEtapes(String msg) { this.m_msg = msg; }

    public String getMessage() {
      return this.m_msg;
    }
  }

  public class PortalCreator
  {
    private Player m_player;
    private String m_dest;
    private PortalCreationManager.CreationEtapes m_etape;
    private Location m_loc1;
    private Location m_loc2;

    private PortalCreator(Player player, String dest)
    {
      this.m_player = player;
      this.m_dest = dest;

      this.m_player.setItemInHand(new ItemStack(Material.STONE));
      this.m_player.updateInventory();
      setEtape(PortalCreationManager.CreationEtapes.POS1);
    }

    public void onBlockPlace(BlockPlaceEvent event)
    {
      if (!this.m_player.getName().equals(event.getPlayer().getName())) return;
      if (this.m_etape == PortalCreationManager.CreationEtapes.POS1) {
        this.m_loc1 = event.getBlock().getLocation();
        this.m_player.setItemInHand(new ItemStack(Material.STONE));
        this.m_player.updateInventory();
        setEtape(PortalCreationManager.CreationEtapes.POS2);
      }
      else if (this.m_etape == PortalCreationManager.CreationEtapes.POS2) {
        this.m_loc2 = event.getBlock().getLocation();
        setEtape(PortalCreationManager.CreationEtapes.END);
      }
    }

    public boolean isFinish() {
      return this.m_etape == PortalCreationManager.CreationEtapes.END;
    }

    private void setEtape(PortalCreationManager.CreationEtapes etape) {
      this.m_etape = etape;
      if (this.m_etape == PortalCreationManager.CreationEtapes.END) {
        PortalsManager.getInstance().createPortal(this.m_loc1, this.m_loc2, this.m_dest);
      }
      this.m_player.sendMessage(this.m_etape.getMessage());
    }
  }
}