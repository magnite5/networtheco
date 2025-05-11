package me.CallMeCanadian.networtheco;

import me.CallMeCanadian.networtheco.Commands.KillsCommand;
import me.CallMeCanadian.networtheco.Commands.NwCommand;
import me.CallMeCanadian.networtheco.Commands.NwGuiCommand;
import me.CallMeCanadian.networtheco.Listeners.GuiListeners;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import net.luckperms.api.LuckPerms;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Networtheco extends JavaPlugin {

//    private LuckPerms luckPerms;

    public final Map<UUID, Integer> killCount = new HashMap<>();
    public final Map<UUID, Integer> nwCount = new HashMap<>();
    private FileConfiguration config;

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new GuiListeners(), this);

        getCommand("nwgui").setExecutor(new NwGuiCommand());
        getCommand("nw").setExecutor(new NwCommand());
        getCommand("kills").setExecutor(new KillsCommand());

//        this.luckPerms = getServer().getServicesManager().load(LuckPerms.class);
    }

    @Override
    public void onDisable() {
//        for (Map.Entry<UUID, Integer> entry : )
    }

    public  static Networtheco getInstance() {
        return getPlugin(Networtheco.class);
    }
}
