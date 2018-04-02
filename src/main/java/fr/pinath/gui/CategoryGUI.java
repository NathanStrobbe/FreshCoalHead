package fr.pinath.gui;

import fr.pinath.skull.Category;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CategoryGUI extends GUI {

    public CategoryGUI(JavaPlugin plugin, Category category, Player player) {
        super(plugin, player);
        inventory = Bukkit.createInventory(player, 18, category.getTitle());
    }

    @Override
    protected void initializeContent() {

    }
}
