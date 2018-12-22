package net.neferett.lobby.Listener;

import java.net.InetAddress;

import net.neferett.lobby.Utils.PlayerInventory;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoinEvent implements Listener{


    
    private static PlayerJoinEvent instance;
    public static PlayerJoinEvent getInstance(){
    	return instance;
    }
	private Location loc;
	
	
	

	

	@EventHandler
	public void OPJ(org.bukkit.event.player.PlayerJoinEvent e){
		Player p = e.getPlayer();

		p.setGameMode(GameMode.ADVENTURE);

		if(Bukkit.getOnlinePlayers().length == 1){
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "citizens reload");
		}


		
		
	      p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 180000000, 2));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 1));
	      p.setAllowFlight(true);
	      p.setFlying(true);
	      e.setJoinMessage(null);
		

		
		
		Loc(p);
		

	}
	

	@EventHandler
	public void ORE(PlayerRespawnEvent e){
		final Player p = e.getPlayer();
		



	      p.setAllowFlight(true);
	      p.setFlying(true);
	      
	      PlayerInventory.getInstance().PlayerInvChangeLang(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(net.neferett.lobby.Main.getInstance(), new Runnable() {
				@Override
				public void run() {
				      p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 180000000, 2));
				      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000000, 1));
				      Loc(p);
				      PlayerInventory.getInstance().PlayerInvChangeLang(p);

						}
					}, 5L);

	}
	
	@EventHandler
	public void OP(PlayerLoginEvent e){
		InetAddress addr = e.getAddress();
		if(!addr.getHostAddress().startsWith("151.80.109.185")){
		  e.setKickMessage("Vous ne passez pas par l'ip Linaris.fr !");
		  e.setResult(PlayerLoginEvent.Result.KICK_WHITELIST);
		}

	}
	


	
	@EventHandler
	public void OD(PlayerDeathEvent e){
		e.setDeathMessage(null);
	}
	
	public void Loc(Player p){
		Location location = p.getLocation();
        location.setX(-2186.673);
        location.setY(161);
        location.setZ(-451.508);
        location.setYaw((float) 86.2);
        location.setPitch((float) 2.2);
        p.teleport(location);
		PlayerInventory.getInstance().PlayerInv(p);

	}
   

}
