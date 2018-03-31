package fr.pinath.command;

import fr.pinath.gui.Category;
import fr.pinath.gui.CategoryGUI;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class HeadCommand extends AbstractCommand {

    @Override
    public boolean executeCommand(Player player, Command command, String s, String[] strings) {
        new CategoryGUI(Category.COLOR, player).showGUI();
        return true;
    }
}
