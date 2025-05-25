package davvo.homebase.gui;

import davvo.homebase.HomeBase;
import davvo.homebase.manager.HomeManager;
import davvo.homebase.misc.HomeData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIUtils {
    public static void fillBorder(Inventory inv, ItemStack filler) {
        int size = inv.getSize();
        for (int i = 0; i < size; i++) {
            if (i < 9
                    || i >= size - 9
                    || i % 9 == 0
                    || (i + 1) % 9 == 0) {
                inv.setItem(i, filler);
            }
        }
    }

    public static boolean homeExists(Player player){
        HomeManager homeManager = HomeBase.getInstance().getHomeManager();
        HomeData home = homeManager.getHome(player.getUniqueId());

        return home != null;
    }
}
