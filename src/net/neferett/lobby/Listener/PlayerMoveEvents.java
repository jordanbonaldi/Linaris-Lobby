package net.neferett.lobby.Listener;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

import net.minecraft.util.org.apache.commons.io.output.ByteArrayOutputStream;
import net.neferett.lobby.Main;
import net.neferett.lobby.Manager.PortalsManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveEvents implements Listener{
	  private HashMap<String, PortalsManager.Portal> m_playersPortal = new HashMap();

	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent event) {
	    Player player = event.getPlayer();
	    PortalsManager.Portal portal = PortalsManager.getInstance().getPortal(player.getLocation());

	    if (portal != null) {
	      if ((this.m_playersPortal.containsKey(player.getName())) && (((PortalsManager.Portal)this.m_playersPortal.get(player.getName())).equals(portal))) {
	        return;
	      }

	      this.m_playersPortal.put(player.getName(), portal);
	      try
	      {
	        ByteArrayOutputStream b = new ByteArrayOutputStream();
	        DataOutputStream out = new DataOutputStream(b);

	        out.writeUTF("Connect");
	        out.writeUTF(portal.getDest());

	        player.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray()); } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	    else if (this.m_playersPortal.containsKey(player.getName())) { this.m_playersPortal.remove(player.getName()); }

	  }

}
