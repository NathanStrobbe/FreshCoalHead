package fr.pinath.gui;

import fr.pinath.listener.CategoryGUIListener;
import fr.pinath.skull.Category;
import fr.pinath.skull.DataSkull;
import fr.pinath.skull.Skull;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Graphical User Interface of a Category. It contains the different heads of the category
 *
 * @author Nathan Strobbe
 */
public class CategoryGUI extends GUI {
    private Category category;
    private GUI previousGUI;
    private List<PageGUI> pages;
    private PageGUI currentPage;

    public CategoryGUI(JavaPlugin plugin, Category category, Player player, GUI previousGUI) {
        super(plugin, player);
        this.category = category;
        this.previousGUI = previousGUI;
        initializeContent();
        plugin.getServer().getPluginManager().registerEvents(new CategoryGUIListener(plugin, this), plugin);
    }

    protected void setCurrentPage(PageGUI pageGUI) {
        this.currentPage = pageGUI;
    }

    public PageGUI getCurrentPage() {
        return currentPage;
    }

    protected List<PageGUI> getPages() {
        return pages;
    }

    protected Category getCategory() {
        return category;
    }

    /**
     * Initialize the pages of the category GUI
     */
    @Override
    protected void initializeContent() {
        pages = new ArrayList<>();
        List<Skull> skulls = new DataSkull(category).collectSkull();
        int from = 0;
        int to = 45;
        for (int i = 0; i < skulls.size(); i++) {
            if (to > skulls.size()) {
                to = skulls.size();
            }
            pages.add(i, new PageGUI(i, skulls.subList(from, to), this));
            from += 45;
            to += 45;
            if (from > skulls.size()) {
                break;
            }
        }
        pages.forEach(PageGUI::initializeContent);
    }

    @Override
    public void showGUI() {
        if (!pages.isEmpty()) {
            pages.get(0).showPage();
        }
    }

    public GUI getPreviousGUI() {
        return previousGUI;
    }
}
