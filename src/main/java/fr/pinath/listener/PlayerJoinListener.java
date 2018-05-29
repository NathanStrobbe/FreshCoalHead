package fr.pinath.listener;

import fr.pinath.gui.GUI;
import fr.pinath.gui.MainGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

/**
 * Listener on the join of a player.
 *
 * @author Nathan Strobbe
 */
public class PlayerJoinListener implements Listener {
    private JavaPlugin plugin;
    private Map<Player, GUI> guiOfPlayers;

    public PlayerJoinListener(JavaPlugin plugin, Map<Player, GUI> guiOfPlayers) {
        this.plugin = plugin;
        this.guiOfPlayers = guiOfPlayers;
    }

    /**
     * Create the {@link MainGUI} for the player who has join
     *
     * @param e event
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (e != null && e.getPlayer() != null) {
            if (!guiOfPlayers.containsKey(e.getPlayer())) {
                guiOfPlayers.put(e.getPlayer(), new MainGUI(plugin, e.getPlayer()));
            }
        }
    }

    /**
     * Remove useless GUI stored when a player left the server
     *
     * @param e event
     */
    @EventHandler
    public void onPlayerLeft(PlayerQuitEvent e) {
        if (e != null && e.getPlayer() != null) {
            if (guiOfPlayers.containsKey(e.getPlayer())) {
                guiOfPlayers.remove(e.getPlayer());
            }
        }
    }
}
