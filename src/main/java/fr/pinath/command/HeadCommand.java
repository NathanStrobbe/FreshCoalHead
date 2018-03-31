package fr.pinath.command;

import fr.pinath.gui.MainGUI;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HeadCommand extends AbstractCommand {

    public HeadCommand(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public boolean executeCommand(Player player, Command command, String s, String[] strings) {
        new MainGUI(plugin, player).showGUI();
        return true;
    }
}
