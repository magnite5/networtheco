package me.CallMeCanadian.networtheco.Commands;

import io.papermc.paper.datacomponent.DataComponentTypes;
import me.CallMeCanadian.networtheco.Items;
import me.CallMeCanadian.networtheco.Networtheco;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.RGBLike;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("UnstableApiUsage")
public class NwGuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players may use this command.");

            return true;

        }

        Player player = (Player) commandSender;

        player.sendMessage("You have executed the 'nwgui'  command.");

        Inventory inventory = Bukkit.createInventory(player, (9 * 6), ChatColor.GOLD + "Net Worth Conversions");

        ItemStack background = ItemStack.of(Material.CYAN_STAINED_GLASS_PANE);
        background.setData(DataComponentTypes.ITEM_NAME, Component.text(" "));

        for(int i = 0; i <= inventory.getSize(); i++) inventory.setItem(i, background);
        inventory.setItem(18, new Items().getBackButton());




        player.openInventory(inventory);
        player.setMetadata("ActiveMenu", new FixedMetadataValue(Networtheco.getInstance(), "nwgui"));

        return false;
    }
}
