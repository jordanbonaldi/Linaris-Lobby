package net.neferett.lobby.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldListener implements Listener{
	
	@EventHandler
	public void Rain(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void OB(BlockBreakEvent e){
		if(!e.getPlayer().isOp())
		e.setCancelled(true);
	}

	
	@EventHandler
	public void OP(BlockPlaceEvent e){
		if(!e.getPlayer().isOp())
		e.setCancelled(true);
	}
	
	
	@EventHandler
	public void Food(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}

	@EventHandler
	public void Death(PlayerDeathEvent e){
		e.getDrops().clear();
	}
}
