package fr.pinath;

import fr.pinath.command.HeadCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Pinath
 */
public class FreshCoalHead extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(getDescription().getName() + " has been enabled !");
        getCommand("head").setExecutor(new HeadCommand(this));
    }

    @Override
    public void onDisable() {
        Bukkit.getOnlinePlayers().forEach(HumanEntity::closeInventory);
    }
}
