package fr.pinath.listener;

import fr.pinath.skull.Category;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public abstract class GUIListener implements Listener {
    protected JavaPlugin plugin;
    protected Inventory inventory;
    protected Player player;
    private ItemStack[] content;

    GUIListener(JavaPlugin plugin, Inventory inventory, Player player) {
        this.plugin = plugin;
        this.inventory = inventory;
        this.player = player;
    }

    @EventHandler
    public void onOpenGUI(InventoryOpenEvent e) {
        if (e.getPlayer().equals(player) && e.getInventory().equals(inventory)) {
            content = player.getInventory().getContents();
            player.getInventory().clear();
        }
    }

    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
        if (e.getWhoClicked().equals(player)
                && e.getClickedInventory() != null
                && e.getClickedInventory().equals(inventory)) {
            e.setCancelled(true);
        }
    }

    protected List<String> getSkullNames() {
        return Arrays.stream(Category.values()).map(Category::getTitle).collect(Collectors.toList());
    }

    @EventHandler
    public abstract void onSkullClick(InventoryClickEvent e);

    @EventHandler
    public void onCloseGUI(InventoryCloseEvent e) {
        if (e.getPlayer().equals(player) && e.getInventory().equals(inventory)) {
            player.getInventory().setContents(content);
        }
    }
}
