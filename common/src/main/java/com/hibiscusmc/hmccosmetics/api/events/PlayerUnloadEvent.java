package com.hibiscusmc.hmccosmetics.api.events;

import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerUnloadEvent extends PlayerCosmeticEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerUnloadEvent(@NotNull CosmeticUser who) {
        super(who);
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
