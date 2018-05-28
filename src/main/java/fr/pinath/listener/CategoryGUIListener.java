package fr.pinath.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class CategoryGUIListener extends GUIListener {

    public CategoryGUIListener(JavaPlugin plugin, Inventory inventory, Player player) {
        super(plugin, inventory, player);
    }

    @EventHandler
    @Override
    public void onSkullClick(InventoryClickEvent e) {
        if (e != null && e.getWhoClicked() != null
                && e.getWhoClicked().equals(player)
                && e.getClickedInventory() != null
                && e.getClickedInventory().equals(inventory)) {
            player.getWorld().dropItemNaturally(player.getLocation(), e.getCurrentItem());
            player.closeInventory();
        }
    }
}
