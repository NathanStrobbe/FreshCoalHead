package fr.pinath.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public abstract class GUIListener implements Listener {
    protected Inventory inventory;
    protected Player player;
    private ItemStack[] content;

    GUIListener(Inventory inventory, Player player) {
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
        if (e.getWhoClicked().equals(player)
                && e.getClickedInventory() != null
                && e.getClickedInventory().equals(inventory)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public abstract void onSkullClick(InventoryClickEvent e);

    @EventHandler
    public void onCloseGUI(InventoryCloseEvent e) {
        if (e.getPlayer().equals(player) && e.getInventory().equals(inventory)) {
            player.getInventory().setContents(content);
        }
    }
}
