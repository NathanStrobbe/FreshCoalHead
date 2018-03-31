package fr.pinath.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.RED;

public abstract class AbstractCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(RED + "Vous devez être un joueur pour pouvoir exécuter cette commande !");
            return true;
        }
        return executeCommand((Player) commandSender, command, s, strings);
    }

    public abstract boolean executeCommand(Player player, Command command, String s, String[] strings);
}
