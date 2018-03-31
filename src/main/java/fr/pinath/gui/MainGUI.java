package fr.pinath.gui;

import fr.pinath.listener.GUIListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.IntStream;

public class MainGUI extends GUI {

    public MainGUI(JavaPlugin plugin, Player player) {
        super(plugin, player);
        inventory = Bukkit.createInventory(player, 54, "Choose a category");
        initializeContent();
        plugin.getServer().getPluginManager().registerEvents(new GUIListener(inventory, player), plugin);
    }

    @Override
    protected void initializeContent() {
        ItemStack border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        IntStream.range(0, 9).forEach(i -> inventory.setItem(i, border));
        IntStream.range(45, 54).forEach(i -> inventory.setItem(i, border));
        IntStream.range(1, 5).forEach(i -> {
            inventory.setItem(i * 9, border);
            inventory.setItem((i + 1) * 9 - 1, border);
        });
    }
}
