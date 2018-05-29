package fr.pinath.listener;

import fr.pinath.gui.CategoryGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Listener of {@link CategoryGUI}
 *
 * @author Nathan Strobbe
 */
public class CategoryGUIListener extends GUIListener {

    public CategoryGUIListener(JavaPlugin plugin, Inventory inventory, Player player) {
        super(plugin, inventory, player);
    }

    /**
     * Gives the skull clicked by the player
     *
     * @param e event
     */
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
