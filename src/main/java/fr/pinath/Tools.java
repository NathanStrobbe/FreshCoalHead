package fr.pinath;

import fr.pinath.listener.BlockListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Tools extends JavaPlugin {
    /*private JavaPlugin instance;

    public Tools(JavaPlugin instance) {
        this.instance = instance;
    }

    public JavaPlugin getInstance() {
        return instance;
    }*/

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

    @Override
    public void onDisable() {
        // no need to do things here
    }
}
