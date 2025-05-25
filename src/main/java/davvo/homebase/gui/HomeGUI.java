package davvo.homebase.gui;

import davvo.homebase.HomeBase;
import davvo.homebase.manager.HomeManager;
import davvo.homebase.misc.HomeData;
import davvo.homebase.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

import static davvo.homebase.gui.GUIUtils.fillBorder;
import static davvo.homebase.gui.GUIUtils.homeExists;
import static davvo.homebase.utils.Messages.defaultColors;

public class HomeGUI {
    public static void openGui(Player player) {
        HomeManager homeManager = HomeBase.getInstance().getHomeManager();
        HomeData home = homeManager.getHome(player.getUniqueId());

        Inventory inv = Bukkit.createInventory(null, 27, Messages.defaultGuiName);

        ItemStack border = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        fillBorder(inv, border);

        if (homeExists(player)){
            ItemStack homeSkull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
            SkullMeta homeItemMeta = (SkullMeta) homeSkull.getItemMeta();
            homeItemMeta.setOwningPlayer(player);
            homeItemMeta.setDisplayName(defaultColors + home.getName());

            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Click to teleport");

            homeItemMeta.setLore(lore);
            homeSkull.setItemMeta(homeItemMeta);
            inv.setItem(13, homeSkull);
        }
        player.openInventory(inv);
    }
}
