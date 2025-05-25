package davvo.homebase.listeners;

import davvo.homebase.utils.Messages;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static davvo.homebase.utils.Messages.defaultColors;

public class HomeGUIClickListener implements Listener {
    @EventHandler
    public void clickInventoryEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals(Messages.defaultGuiName)){
            if (event.getCursor().getType().equals(Material.PLAYER_HEAD)){
                player.performCommand("home manna");
            }
            event.setCancelled(true);
        }
    }
}
