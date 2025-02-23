package com.hibiscusmc.hmccosmetics.hooks.misc;

import com.hibiscusmc.hmccosmetics.api.events.PlayerWardrobeEnterEvent;
import com.hibiscusmc.hmccosmetics.api.events.PlayerWardrobeLeaveEvent;
import kr.toxicity.hud.api.BetterHud;
import kr.toxicity.hud.api.player.HudPlayer;
import me.lojosho.hibiscuscommons.hooks.Hook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import java.util.UUID;

public class HookBetterHud extends Hook {

    public HookBetterHud() {
        super("BetterHUD");
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerEnterWardrobe(PlayerWardrobeEnterEvent event) {
        UUID uuid = event.getUniqueId();
        HudPlayer hudPlayer = BetterHud.getInstance().getPlayerManager().getHudPlayer(uuid);
        if (hudPlayer == null) return;
        hudPlayer.setHudEnabled(false);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerLeaveWardrobe(PlayerWardrobeLeaveEvent event) {
        UUID uuid = event.getUniqueId();
        HudPlayer hudPlayer = BetterHud.getInstance().getPlayerManager().getHudPlayer(uuid);
        if (hudPlayer == null) return;
        hudPlayer.setHudEnabled(true);
    }
}
