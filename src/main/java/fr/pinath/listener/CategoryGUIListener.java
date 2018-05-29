package fr.pinath.listener;

import fr.pinath.gui.CategoryGUI;
import fr.pinath.gui.GUI;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Listener of {@link CategoryGUI}
 *
 * @author Nathan Strobbe
 */
public class CategoryGUIListener extends GUIListener {

    public CategoryGUIListener(JavaPlugin plugin, GUI gui) {
        super(plugin, gui);
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
            ItemStack clickedItem = e.getCurrentItem();
            if (clickedItem != null) {
                if (clickedItem.getType().equals(Material.ARROW)) {
                    player.closeInventory();
                    ((CategoryGUI) this.gui).getPreviousGUI().showGUI();
                } else {
                    player.getWorld().dropItemNaturally(player.getLocation(), e.getCurrentItem());
                    player.closeInventory();
                }
            }
        }
    }
}
