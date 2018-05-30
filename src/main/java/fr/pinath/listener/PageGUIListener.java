package fr.pinath.listener;

import fr.pinath.gui.CategoryGUI;
import fr.pinath.gui.GUI;
import fr.pinath.gui.PageGUI;
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
public class PageGUIListener extends GUIListener {

    public PageGUIListener(JavaPlugin plugin, GUI gui) {
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
                CategoryGUI categoryGUI = (CategoryGUI) ((PageGUI) gui).getGUI();
                if (clickedItem.getType().equals(Material.ARROW)) {
                    player.closeInventory();
                    categoryGUI.getPreviousGUI().showGUI();
                } else if (clickedItem.equals(categoryGUI.getCurrentPage().getPreviousItem())) {
                    player.closeInventory();
                    int number = categoryGUI.getCurrentPage().getNumber();
                    categoryGUI.getPages().get(number - 1).showPage();
                } else if (clickedItem.equals(categoryGUI.getCurrentPage().getNextItem())) {
                    player.closeInventory();
                    int number = categoryGUI.getCurrentPage().getNumber();
                    categoryGUI.getPages().get(number + 1).showPage();
                } else if (clickedItem.getType().equals(Material.SKULL_ITEM)) {
                    player.getWorld().dropItemNaturally(player.getLocation(), e.getCurrentItem());
                    player.closeInventory();
                }
            }
        }
    }
}
