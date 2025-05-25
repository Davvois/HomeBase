package davvo.homebase.commands;

import davvo.homebase.HomeBase;
import davvo.homebase.manager.HomeManager;
import davvo.homebase.misc.HomeData;
import davvo.homebase.utils.Messages;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static davvo.homebase.gui.HomeGUI.openGui;

public class Home implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("[HomeBase] You must be a player to perform this command!");
            return true;
        }

        Player executor = (Player) sender;

        if (!(args.length > 0)) {
            executor.sendMessage(Messages.defaultMessagePrefix + "Usage: /home (home-name)");
            return true;
        }

        HomeManager homeManager = HomeBase.getInstance().getHomeManager();
        HomeData home = homeManager.getHome(executor.getUniqueId());

        if (homeManager.getHome(executor.getUniqueId()) == null){
            executor.sendMessage(Messages.defaultMessagePrefix + "Home must be set before executing this command!");
            return true;
        }
        else {
            new BukkitRunnable() {
                int countdown = 5;

                @Override
                public void run() {
                    if (countdown > 1) {
                        executor.sendMessage(Messages.defaultMessagePrefix + "You will be teleported in " + countdown + " seconds.");
                        executor.playSound(executor.getLocation(), Sound.UI_BUTTON_CLICK, 1f, 0.9f);
                        countdown--;
                    } else if (countdown == 1) {
                        executor.sendMessage(Messages.defaultMessagePrefix + "You will be teleported in " + countdown + " second.");
                        executor.playSound(executor.getLocation(), Sound.UI_BUTTON_CLICK, 1f, 0.9f);
                        countdown--;
                    } else {
                        executor.teleport(home.getLocation());
                        executor.playSound(executor.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
                        this.cancel();
                    }
                }
            }.runTaskTimer(HomeBase.getInstance(), 0L, 20L);
        }
        return true;
    }
}
