package com.hibiscusmc.hmccosmetics.api.events;

import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when cosmetics are shown from a player.
 */
public class PlayerCosmeticShowEvent extends PlayerCosmeticEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    private boolean cancel = false;

    public PlayerCosmeticShowEvent(@NotNull CosmeticUser who) {
        super(who);
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}