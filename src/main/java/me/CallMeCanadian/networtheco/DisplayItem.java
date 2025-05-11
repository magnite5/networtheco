package me.CallMeCanadian.networtheco;

import org.bukkit.inventory.ItemStack;

public class DisplayItem {
    ItemStack itemtype;
    int amount;

    public DisplayItem(ItemStack itemtype, int amount) {
        this.itemtype = itemtype;
        this.amount = amount;
    }

}
