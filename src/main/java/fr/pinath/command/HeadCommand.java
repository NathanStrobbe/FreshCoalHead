package fr.pinath.command;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class HeadCommand extends AbstractCommand {

    @Override
    public boolean executeCommand(Player player, Command command, String s, String[] strings) {
        player.sendMessage(command.getName());
        player.sendMessage(s);
        player.sendMessage(strings);
        return true;
    }
}
