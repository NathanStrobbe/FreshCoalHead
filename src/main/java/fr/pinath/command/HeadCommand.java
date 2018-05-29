package fr.pinath.command;

import fr.pinath.gui.GUI;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class HeadCommand extends AbstractCommand {
    private Map<Player, GUI> guiOfPlayers;

    public HeadCommand(JavaPlugin plugin, Map<Player, GUI> guiOfPlayers) {
        super(plugin);
        this.guiOfPlayers = guiOfPlayers;
    }

    @Override
    public boolean executeCommand(Player player, Command command, String s, String[] strings) {
        if (guiOfPlayers.containsKey(player)) {
            guiOfPlayers.get(player).showGUI();
            return true;
        }
        player.sendMessage("Impossible d'ouvrir le menu");
        return false;
    }
}
