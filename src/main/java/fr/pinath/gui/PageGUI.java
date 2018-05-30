package fr.pinath.gui;

import fr.pinath.skull.Skull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Represent a page of a {@link CategoryGUI}
 *
 * @author Nathan Strobbe
 */
public class PageGUI {
    private int number;
    private List<Skull> skulls;
    private GUI gui;
    private Inventory inventory;

    PageGUI(int number, List<Skull> skulls, GUI gui) {
        this.number = number;
        this.skulls = skulls;
        this.gui = gui;
        this.inventory = Bukkit.createInventory(gui.getPlayer(), 54,
                ((CategoryGUI) gui).getCategory().getTitle());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getNumber() {
        return number;
    }

    void initializeContent() {
        for (int i = 0; i < skulls.size() && i < 45; i++) {
            inventory.setItem(i, skulls.get(i));
        }
        if (number > 0) {
            inventory.setItem(47, getPreviousItem());
        }
        inventory.setItem(49, getBackItem());
        if (((CategoryGUI) gui).getPages().size() > number + 1) {
            inventory.setItem(51, getNextItem());
        }
    }

    public void showPage() {
        ((CategoryGUI) gui).setCurrentPage(this);
        gui.getPlayer().openInventory(inventory);
    }

    /**
     * Get an item representing the "Back" option in the GUI
     *
     * @return ItemStack, an arrow
     */
    private ItemStack getBackItem() {
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = arrow.getItemMeta();
        meta.setDisplayName("§l§6Back");
        arrow.setItemMeta(meta);
        return arrow;
    }

    /**
     * Get an item representing the "Previous" option in the GUI
     *
     * @return ItemStack, a paper
     */
    public ItemStack getPreviousItem() {
        ItemStack previous = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = previous.getItemMeta();
        meta.setDisplayName("§l§6Previous Page (" + number + "/" + ((CategoryGUI) gui).getPages().size() + ")");
        previous.setItemMeta(meta);
        return previous;
    }

    /**
     * Get an item representing the "Next" option in the GUI
     *
     * @return ItemStack, a paper
     */
    public ItemStack getNextItem() {
        ItemStack next = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = next.getItemMeta();
        meta.setDisplayName("§l§6Next Page (" + (number + 2) + "/" + ((CategoryGUI) gui).getPages().size() + ")");
        next.setItemMeta(meta);
        return next;
    }
}
