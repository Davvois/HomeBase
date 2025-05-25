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

public class DelHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("[HomeBase] You must be a player to perform this command!");
            return true;
        }

        Player executor = (Player) sender;

        if (args.length > 0){
            executor.sendMessage(Messages.defaultMessagePrefix + "Usage: /delhome");
            return true;
        }

        HomeManager homeManager = HomeBase.getInstance().getHomeManager();
        HomeData home = homeManager.getHome(executor.getUniqueId());

        if (homeManager.getHome(executor.getUniqueId()) == null){
            executor.sendMessage(Messages.defaultMessagePrefix + "Home must be set before executing this command!");
        } else {
            homeManager.removeHome(executor.getUniqueId(), home);
            executor.sendMessage(Messages.defaultMessagePrefix + "Home has been successfully deleted.");
            executor.playSound(executor.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f);
        }

        return true;
    }
}
