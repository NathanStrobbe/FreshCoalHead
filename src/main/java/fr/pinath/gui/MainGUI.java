package fr.pinath.gui;

import fr.pinath.listener.MainGUIListener;
import fr.pinath.skull.Category;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.IntStream;

/**
 * Represents the main Graphical User Interface. It contains the categories
 *
 * @author Nathan Strobbe
 */
public class MainGUI extends GUI {

    public MainGUI(JavaPlugin plugin, Player player) {
        super(plugin, player);
        inventory = Bukkit.createInventory(player, 54, "Choose a category");
        initializeContent();
        plugin.getServer().getPluginManager().registerEvents(new MainGUIListener(plugin, inventory, player), plugin);
    }

    /**
     * Initialise the content of the main GUI, including the items representing a category, a border, and a closing item
     */
    @Override
    protected void initializeContent() {
        ItemStack border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        IntStream.range(0, 9).forEach(i -> inventory.setItem(i, border));
        IntStream.range(45, 54).forEach(i -> inventory.setItem(i, border));
        IntStream.range(1, 5).forEach(i -> {
            inventory.setItem(i * 9, border);
            inventory.setItem((i + 1) * 9 - 1, border);
        });

        for (int i = 0; i < Category.values().length; i++) {
            int pos = i + 11;
            if (i >= 5 && i <= 9) {
                pos += 4;
            } else if (i > 9) {
                pos += 10;
            }
            inventory.setItem(pos, Category.values()[i].getSkull());
        }

        inventory.setItem(38, getClosingItem());
    }
}
