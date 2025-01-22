package com.hibiscusmc.hmccosmetics.api.events;

import com.hibiscusmc.hmccosmetics.gui.Menu;
import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link Menu} is closed by a player.
 */
public class PlayerMenuCloseEvent extends PlayerMenuEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public PlayerMenuCloseEvent(@NotNull CosmeticUser who, @NotNull Menu menu) {
        super(who, menu);
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
