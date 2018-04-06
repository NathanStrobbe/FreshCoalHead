package fr.pinath.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MainGUIListener extends GUIListener {

    public MainGUIListener(Inventory inventory, Player player) {
        super(inventory, player);
    }

    @Override
    public void onSkullClick(InventoryClickEvent e) {

    }
}
