package me.CallMeCanadian.networtheco.Commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KillsCommand implements CommandExecutor {

    MiniMessage mm = MiniMessage.miniMessage();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(sender instanceof Player)) { sender.sendMessage("This command can only be executed by a player"); return false; }
        int kills = ((Player) sender).getStatistic(Statistic.PLAYER_KILLS);

        sender.sendMessage(mm.deserialize("<dark_aqua>You currently have <#FF004D><bold>" + "</bold> <dark_aqua>Player Kills"));
        return false;
    }

/*
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
*/
}
