package me.CallMeCanadian.networtheco.Listeners;

import me.CallMeCanadian.networtheco.Items;
import me.CallMeCanadian.networtheco.Networtheco;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiListeners implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if (player.hasMetadata("ActiveMenu")) {
            event.setCancelled(true);

            assert item != null;
            if (item.equals(new Items().getBackButton())) {
                Inventory previousInventory = event.getClickedInventory();

            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (player.hasMetadata("ActiveMenu")) player.removeMetadata("ActiveMenu", Networtheco.getInstance());
    }
}
