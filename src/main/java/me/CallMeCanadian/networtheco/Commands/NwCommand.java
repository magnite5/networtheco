package me.CallMeCanadian.networtheco.Commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class NwCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        String[] helpAliases = { "-h", "help"};
        MiniMessage mm = MiniMessage.miniMessage();

        if (strings.length >= 1) {
            if (Arrays.stream(helpAliases).anyMatch(strings[0].toLowerCase()::contains)) {

                commandSender.sendMessage(mm.deserialize("<aqua>| <dark_aqua>About <gold>Net Worth <aqua>| <dark_aqua>----------------"));
                commandSender.sendMessage("");
                commandSender.sendMessage(mm.deserialize("<aqua><bold>»</bold>"));
            }


            }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {


        if (strings.length == 1 && commandSender.hasPermission("nw.admin")) return Arrays.asList("help", "get", "set", "add");
        return List.of();

    }
}
