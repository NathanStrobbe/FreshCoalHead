package fr.pinath.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class GUI {
    protected JavaPlugin plugin;
    private Player player;
    Inventory inventory;

    GUI(JavaPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    protected abstract void initializeContent();

    public void showGUI() {
        player.openInventory(inventory);
    }

    ItemStack getClosingItem() {
        ItemStack barrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta meta = barrier.getItemMeta();
        meta.setDisplayName("§l§4Close");
        barrier.setItemMeta(meta);
        return barrier;
    }
}
