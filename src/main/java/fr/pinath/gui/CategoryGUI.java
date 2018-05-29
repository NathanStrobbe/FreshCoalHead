package fr.pinath.gui;

import fr.pinath.listener.CategoryGUIListener;
import fr.pinath.skull.Category;
import fr.pinath.skull.DataSkull;
import fr.pinath.skull.Skull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Represents a Graphical User Interface of a Category. It contains the different heads of the category
 *
 * @author Nathan Strobbe
 */
public class CategoryGUI extends GUI {
    private Category category;
    private GUI previousGUI;

    public CategoryGUI(JavaPlugin plugin, Category category, Player player, GUI previousGUI) {
        super(plugin, player);
        this.category = category;
        this.previousGUI = previousGUI;
        inventory = Bukkit.createInventory(player, 54, category.getTitle());
        initializeContent();
        plugin.getServer().getPluginManager().registerEvents(new CategoryGUIListener(plugin, this), plugin);
    }

    @Override
    protected void initializeContent() {
        List<Skull> skulls = new DataSkull(category).collectSkull();
        for (int i = 0; i < skulls.size() && i < 45; i++) {
            inventory.setItem(i, skulls.get(i));
        }
        // inventory.setItem(47, previous);
        inventory.setItem(49, getBackItem());
        // inventory.setItem(51, next);
    }

    private ItemStack getBackItem() {
        ItemStack barrier = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = barrier.getItemMeta();
        meta.setDisplayName("§l§6Back");
        barrier.setItemMeta(meta);
        return barrier;
    }

    public GUI getPreviousGUI() {
        return previousGUI;
    }
}
