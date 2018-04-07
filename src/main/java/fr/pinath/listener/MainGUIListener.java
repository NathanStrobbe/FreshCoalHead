package fr.pinath.listener;

import fr.pinath.gui.CategoryGUI;
import fr.pinath.skull.Category;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MainGUIListener extends GUIListener {

    public MainGUIListener(JavaPlugin plugin, Inventory inventory, Player player) {
        super(plugin, inventory, player);
    }

    @EventHandler
    @Override
    public void onSkullClick(InventoryClickEvent e) {
        if (e.getWhoClicked().equals(player)
                && e.getInventory().equals(inventory)) {
            ItemStack clickedItem = e.getCurrentItem();
            if (clickedItem != null
                    && clickedItem.getItemMeta() != null
                    && clickedItem.getItemMeta().getDisplayName() != null
                    && getSkullNames().contains(clickedItem.getItemMeta().getDisplayName())) {
                Category category = getCategory(clickedItem);
                if (category != null) {
                    new CategoryGUI(plugin, category, player).showGUI();
                }
            }
        }
    }

    private Category getCategory(ItemStack currentItem) {
        for (Category category : Category.values()) {
            if (category.getTitle().equals(currentItem.getItemMeta().getDisplayName())) {
                return category;
            }
        }
        return null;
    }
}
