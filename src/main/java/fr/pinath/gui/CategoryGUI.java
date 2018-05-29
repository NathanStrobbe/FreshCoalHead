package fr.pinath.gui;

import fr.pinath.listener.CategoryGUIListener;
import fr.pinath.skull.Category;
import fr.pinath.skull.DataSkull;
import fr.pinath.skull.Skull;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Represents a Graphical User Interface of a Category. It contains the different heads of the category
 *
 * @author Nathan Strobbe
 */
public class CategoryGUI extends GUI {
    private Category category;

    public CategoryGUI(JavaPlugin plugin, Category category, Player player) {
        super(plugin, player);
        this.category = category;
        inventory = Bukkit.createInventory(player, 54, category.getTitle());
        initializeContent();
        plugin.getServer().getPluginManager().registerEvents(new CategoryGUIListener(plugin, inventory, player), plugin);
    }

    @Override
    protected void initializeContent() {
        List<Skull> skulls = new DataSkull(category).collectSkull();
        for (int i = 0; i < skulls.size() && i < 54; i++) {
            inventory.setItem(i, skulls.get(i));
        }
    }
}
