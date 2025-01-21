package com.hibiscusmc.hmccosmetics.api.events;

import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a cosmetic user related event
 */
public abstract class PlayerCosmeticEvent extends PlayerEvent {
    protected CosmeticUser user;

    public PlayerCosmeticEvent(@NotNull final CosmeticUser who) {
        super(who.getUniqueId());
        user = who;
    }

    /**
     * Returns the user involved in this event
     *
     * @return User who is involved in this event
     */
    @NotNull
    public final CosmeticUser getUser() {
        return user;
    }
}
