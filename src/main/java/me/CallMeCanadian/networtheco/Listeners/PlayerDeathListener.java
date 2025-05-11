package me.CallMeCanadian.networtheco.Listeners;

import me.CallMeCanadian.networtheco.Networtheco;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class PlayerDeathListener implements Listener {


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player victim = event.getPlayer();
        Entity attackingEntity = event.getDamageSource().getCausingEntity();

        if (attackingEntity instanceof Player) {
            Player attackingPlayer = (Player) attackingEntity;
        }




    }
}
