package davvo.homebase;

import davvo.homebase.commands.DelHome;
import davvo.homebase.commands.Home;
import davvo.homebase.commands.Homes;
import davvo.homebase.commands.SetHome;
import davvo.homebase.gui.HomeGUI;
import davvo.homebase.listeners.HomeGUIClickListener;
import davvo.homebase.manager.HomeManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomeBase extends JavaPlugin {
    private HomeManager homeManager;
    private static HomeBase instance;

    @Override
    public void onEnable() {
        instance = this;
        homeManager = new HomeManager();

        getLogger().info("Made by Davvolol.");

        //Commands
        this.getCommand("home").setExecutor(new Home());
        this.getCommand("sethome").setExecutor(new SetHome());
        this.getCommand("delhome").setExecutor(new DelHome());
        this.getCommand("homes").setExecutor(new Homes());

        //Listeners
        getServer().getPluginManager().registerEvents(new HomeGUIClickListener(), this);
    }

    @Override
    public void onLoad() {
        getLogger().info("Loading 1.0-alpha version.");
    }

    public static HomeBase getInstance() {
        return instance;
    }

    public HomeManager getHomeManager() {
        return homeManager;
    }
}
