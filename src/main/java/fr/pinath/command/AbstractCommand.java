package fr.pinath.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.ChatColor.RED;

public abstract class AbstractCommand implements CommandExecutor {
    protected JavaPlugin plugin;

    public AbstractCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(RED + "You have to be a player to execute this command!");
            return true;
        }
        return executeCommand((Player) commandSender, command, s, strings);
    }

    public abstract boolean executeCommand(Player player, Command command, String s, String[] strings);
}
