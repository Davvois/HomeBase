package davvo.homebase.commands;

import davvo.homebase.HomeBase;
import davvo.homebase.manager.HomeManager;
import davvo.homebase.misc.HomeData;
import davvo.homebase.utils.Messages;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHome implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("[HomeBase] You must be a player to perform this command!");
            return true;
        }

        Player executor = (Player) sender;

        if (args.length < 1){
            executor.sendMessage(Messages.defaultMessagePrefix + "Usage: /sethome (name)");
            return true;
        }

        String homeName = args[0];
        HomeManager homeManager = HomeBase.getInstance().getHomeManager();

        Location executorLocation = new Location(executor.getWorld(), executor.getLocation().getX(), executor.getLocation().getY(), executor.getLocation().getZ(), executor.getLocation().getYaw(), executor.getLocation().getPitch());

        homeManager.setHome(executor.getUniqueId(), new HomeData(homeName, executor.getUniqueId(), executorLocation));
        executor.sendMessage(Messages.defaultMessagePrefix + "Home has been successfully set with name: " + homeManager.getHome(executor.getUniqueId()).getName());
        executor.playSound(executorLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f);

        return true;
    }
}