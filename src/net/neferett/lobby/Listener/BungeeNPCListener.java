package net.neferett.lobby.Listener;

import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.neferett.lobby.NPC.BungeeTrait;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BungeeNPCListener
  implements Listener
{
  @EventHandler
  public void onNPCLeftClick(NPCLeftClickEvent event)
  {
    onNPCClick(event);
  }

  @EventHandler
  public void onNPCRightClick(NPCRightClickEvent event) {
    onNPCClick(event);
  }

  public void onNPCClick(NPCClickEvent event) {
    if (!event.getNPC().hasTrait(BungeeTrait.class)) return;

    BungeeTrait trait = (BungeeTrait)event.getNPC().getTrait(BungeeTrait.class);
    trait.teleport(event.getClicker());
  }
}