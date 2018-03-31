package fr.pinath.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class GUI {
    protected JavaPlugin plugin;
    protected Player player;
    protected Inventory inventory;

    public GUI(JavaPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    protected abstract void initializeContent();

    public void showGUI() {
        player.openInventory(inventory);
    }
}
