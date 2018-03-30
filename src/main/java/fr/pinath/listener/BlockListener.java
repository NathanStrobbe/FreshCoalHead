package fr.pinath.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;
import java.util.Set;

public class BlockListener implements Listener {
    private Set<Block> buttons = new HashSet<>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Block place = e.getBlockPlaced();
        Block placeOn = e.getBlockAgainst();
        if (place.getType().equals(Material.STONE_BUTTON)
                && placeOn.getType().equals(Material.PACKED_ICE)) {
            buttons.add(place);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (buttons.contains(e.getClickedBlock())
                && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "Hey wake up !");
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        buttons.remove(e.getBlock());
    }

}
