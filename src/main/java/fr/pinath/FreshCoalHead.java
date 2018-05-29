package fr.pinath;

import fr.pinath.command.HeadCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Recover heads from website FreshCoal Heads
 * @see <a href="http://freshcoal.com/mainapi.php">Fresh Coal</a>
 *
 * @author Nathan Strobbe
 */
public class FreshCoalHead extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(getDescription().getName() + " has been enabled !");
        getCommand("head").setExecutor(new HeadCommand(this));
    }

    @Override
    public void onDisable() {
        // Bukkit.getOnlinePlayers().forEach(HumanEntity::closeInventory);
    }
}
