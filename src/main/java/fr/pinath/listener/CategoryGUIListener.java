package fr.pinath.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class CategoryGUIListener extends GUIListener {

    public CategoryGUIListener(JavaPlugin plugin, Inventory inventory, Player player) {
        super(plugin, inventory, player);
    }

    @Override
    public void onSkullClick(InventoryClickEvent e) {

    }
}
