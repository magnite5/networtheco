package me.CallMeCanadian.networtheco;

import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class Items {

    public @Nullable ItemStack getBackButton() {
        ItemStack backButton =  new ItemStack(Material.BARRIER);
        backButton.setData(DataComponentTypes.ITEM_NAME, Component.text("Back", TextColor.color(255, 6, 0)));

        return backButton;
    }



}
