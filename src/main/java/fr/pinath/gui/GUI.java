package fr.pinath.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public abstract class GUI {
    protected Inventory inventory;
    protected Player player;

    public void showGUI() {
        player.openInventory(inventory);
    }
}
