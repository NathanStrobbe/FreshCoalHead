package fr.pinath;

import fr.pinath.command.HeadCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class FreshCoalHead extends JavaPlugin {
    private JavaPlugin instance;

    public JavaPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info(getDescription().getName() + " has been enabled !");
        getCommand("head").setExecutor(new HeadCommand());
    }

    @Override
    public void onDisable() {
        // no need to do things here
    }
}
