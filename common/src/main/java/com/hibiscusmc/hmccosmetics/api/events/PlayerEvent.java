package com.hibiscusmc.hmccosmetics.api.events;

import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class PlayerEvent extends Event {

    protected UUID player;

    public PlayerEvent(@NotNull final UUID uuid) {
        this.player = uuid;
    }

    /**
     * Returns the UUID of the player involved in this event
     * @return User who is involved in this event
     */
    @NotNull
    public final UUID getUniqueId() {
        return player;
    }
}
