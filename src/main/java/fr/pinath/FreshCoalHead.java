package fr.pinath;

import fr.pinath.command.HeadCommand;
import fr.pinath.gui.GUI;
import fr.pinath.gui.MainGUI;
import fr.pinath.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Recover heads from website FreshCoal Heads
 * @see <a href="http://freshcoal.com/mainapi.php">Fresh Coal</a>
 *
 * @author Nathan Strobbe
 */
public class FreshCoalHead extends JavaPlugin {
    private Map<Player, GUI> guiOfPlayers;

    @Override
    public void onEnable() {
        getLogger().info(getDescription().getName() + " has been enabled !");
        createGuiOfOnlinePlayers();
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this, guiOfPlayers), this);
        getCommand("head").setExecutor(new HeadCommand(this, guiOfPlayers));
    }

    @Override
    public void onDisable() {
        // Bukkit.getOnlinePlayers().forEach(HumanEntity::closeInventory);
    }

    /**
     * Create the main GUI for each online players
     */
    private void createGuiOfOnlinePlayers() {
        guiOfPlayers = new HashMap<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            guiOfPlayers.put(player, new MainGUI(this, player));
        }
    }
}
