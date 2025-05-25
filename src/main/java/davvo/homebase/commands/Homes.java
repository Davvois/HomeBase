package davvo.homebase.commands;

import davvo.homebase.utils.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static davvo.homebase.gui.HomeGUI.openGui;

public class Homes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("[HomeBase] You must be a player to perform this command!");
            return true;
        }
        Player executor = (Player) sender;

        if (args.length > 0){
            executor.sendMessage(Messages.defaultMessagePrefix + "Usage: /homes");
            return true;
        }
        openGui(executor);

        return true;
    }
}
