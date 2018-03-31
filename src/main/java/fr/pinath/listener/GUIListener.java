package fr.pinath.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIListener implements Listener {
    private Inventory inventory;
    private Player player;
    private ItemStack[] content;

    public GUIListener(Inventory inventory, Player player) {
        this.inventory = inventory;
        this.player = player;
    }

    @EventHandler
    public void onOpenGUI(InventoryOpenEvent e) {
        if (e.getPlayer().equals(player) && e.getInventory().equals(inventory)) {
            content = player.getInventory().getContents();
            player.getInventory().clear();
        }
    }

    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
        if (e.getWhoClicked().equals(player) && e.getClickedInventory().equals(inventory)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onCloseGUI(InventoryCloseEvent e) {
        if (e.getPlayer().equals(player) && e.getInventory().equals(inventory)) {
            player.getInventory().setContents(content);
            content = null;
        }
    }
}
