package me.CallMeCanadian.networtheco.Commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.apache.commons.lang3.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class KillsCommand implements CommandExecutor, TabExecutor {
    // /kills <task> <target> <amount>

    MiniMessage mm = MiniMessage.miniMessage();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command may only be executed by a player");
            return false;
        }
        //TODO: Help Menu
        if (args.length > 1 && !(player.hasPermission("kills.admin"))) player.sendMessage(mm.deserialize("<light_red>You do not have permission to modify Player Kills."));

        if (!(args.length == 0)) {
            if (args[0].equalsIgnoreCase("set")) {
                if (args.length < 3) {
                    sender.sendMessage(mm.deserialize("<light_red>Please specify a valid Target Player and Amount."));
                    return false;
                }

                int amount;

                try {
                    amount = Integer.parseInt(args[2]);
                } catch (NumberFormatException exception) {
                    sender.sendMessage("<light_red>\"" + args[2] + "\" Is not a valid number.");
                    return false;
                }

                Bukkit.getPlayer(args[1]).setStatistic(Statistic.PLAYER_KILLS, amount);
                sender.sendMessage(mm.deserialize("<dark_aqua>Set <gold>" + Bukkit.getPlayer(args[1]).getName() + "<dark_aqua>'s <aqua>Player Kills <dark_aqua>to <#FF004D><bold>" + Integer.toString(Bukkit.getPlayer(args[1]).getStatistic(Statistic.PLAYER_KILLS)) + "</bold><dark_aqua>."));
                return false;
            } else if (args[0].equalsIgnoreCase("get")) {
                if (args.length < 2) {
                    sender.sendMessage(mm.deserialize("<light_red>Please specify a valid Target Player."));
                    return false;
                }

                sender.sendMessage(mm.deserialize("<dark_aqua>Player <gold>" + Bukkit.getPlayer(args[1]).getName() + " <dark_aqua>Currently has <#FF004D><bold>" + Integer.toString(Bukkit.getPlayer(args[1]).getStatistic(Statistic.PLAYER_KILLS)) + "</bold><aqua> Player Kills<dark_aqua>."));
                return false;
            } else if (args[0].equalsIgnoreCase("add")) {
                if (args.length < 3) {
                    sender.sendMessage(mm.deserialize("<light_red>Please specify a valid Target Player and Amount."));
                    return false;
                }

                    int amount;

                    try {
                        amount = Integer.parseInt(args[2]);
                    } catch (NumberFormatException exception) {
                        sender.sendMessage("<light_red>\"" + args[2] + "\" Is not a valid number.");
                        return false;
                    }
                    int total = amount + Bukkit.getPlayer(args[1]).getStatistic(Statistic.PLAYER_KILLS);

                    sender.sendMessage(mm.deserialize("<dark_aqua>Added <#FF004D><bold>" + Integer.toString(amount) + "</bold> <aqua>Player Kills <dark_aqua>to <gold>" + Bukkit.getPlayer(args[1]).getName() + "<dark_aqua>'s total. They now have <#FF004D><bold>" + Integer.toString(total) + "</bold> <dark_aqua>Total."));
            } else if (args[0].equalsIgnoreCase("subtract")) {
                if (args.length < 3) {
                    sender.sendMessage(mm.deserialize("<light_red>Please specify a valid Target Player and Amount."));
                    return false;
                }

                int amount;

                try {
                    amount = Integer.parseInt(args[2]);
                } catch (NumberFormatException exception) {
                    sender.sendMessage("<light_red>\"" + args[2] + "\" Is not a valid number.");
                    return false;
                }
                int total = Bukkit.getPlayer(args[1]).getStatistic(Statistic.PLAYER_KILLS) - amount;
                if (total < 0) total = 0;

                sender.sendMessage(mm.deserialize("<dark_aqua>Subtracted <#FF004D><bold>" + Integer.toString(amount) + "</bold> <aqua>Player Kills <dark_aqua>from <gold>" + Bukkit.getPlayer(args[1]).getName() + "<dark_aqua>'s total. They now have <#FF004D><bold>" + Integer.toString(total) + "</bold> <dark_aqua>Total."));
            }
        } else {
                sender.sendMessage(mm.deserialize("<dark_aqua>You currently have <#FF004D><bold>" + Integer.toString(player.getStatistic(Statistic.PLAYER_KILLS)) + "</bold> <aqua>Player Kills<dark_aqua>."));
            }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        final List<String> validArguments = new ArrayList<>();
        if (args.length == 1 && commandSender.hasPermission("kills.admin")) {
            StringUtil.copyPartialMatches(args[0], List.of("get", "set", "add", "subtract"), validArguments); //TODO: Help Menu
            return validArguments;
        }
        
        return List.of();
        }
}