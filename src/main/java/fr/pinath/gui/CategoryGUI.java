package fr.pinath.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CategoryGUI extends GUI {

    public CategoryGUI(Category category, Player player) {
        this.player = player;
        inventory = Bukkit.createInventory(player, 18, category.getTitle());
    }

}
