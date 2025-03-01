package com.hibiscusmc.hmccosmetics.cosmetic;

import com.google.common.collect.ImmutableCollection;
import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Represents any object that can wear/hold cosmetics,
 * users, for example.
 */
public interface CosmeticHolder {
    @Nullable Cosmetic getCosmetic(CosmeticSlot slot);

    ImmutableCollection<Cosmetic> getCosmetics();

    void addCosmetic(@NotNull Cosmetic cosmetic, @Nullable Color color);

    default void addCosmetic(@NotNull Cosmetic cosmetic) {
        addCosmetic(cosmetic, null);
    }

    default void removeCosmetics() {
        // Small optimization could be made, but Concurrent modification prevents us from both getting and removing
        for (CosmeticSlot slot : CosmeticSlot.values().values()) {
            removeCosmeticSlot(slot);
        }
    }

    void removeCosmeticSlot(CosmeticSlot slot);

    default void removeCosmeticSlot(Cosmetic cosmetic) {
        removeCosmeticSlot(cosmetic.getSlot());
    }

    default boolean hasCosmeticInSlot(CosmeticSlot slot) {
        return getCosmetic(slot) != null;
    }

    default boolean hasCosmeticInSlot(Cosmetic cosmetic) {
        final var existingCosmetic = getCosmetic(cosmetic.getSlot());
        if (existingCosmetic == null) return false;
        return Objects.equals(cosmetic.getId(), existingCosmetic.getId());
    }

    default boolean canEquipCosmetic(Cosmetic cosmetic) {
        return canEquipCosmetic(cosmetic, false);
    }

    boolean canEquipCosmetic(Cosmetic cosmetic, boolean ignoreWardrobe);

    void updateCosmetic(CosmeticSlot slot);

    /**
     * Just for backwards compatibility, ensures that the given viewer and the given cosmetic holder
     * represent the same user.
     *
     * @param viewer the viewer
     * @param cosmeticHolder the cosmetic holder
     */
    @ApiStatus.Internal
    static @NotNull CosmeticUser ensureSingleCosmeticUser(@NotNull Player viewer, @NotNull CosmeticHolder cosmeticHolder) {
        if (!(cosmeticHolder instanceof CosmeticUser user) || !user.getUniqueId().equals(viewer.getUniqueId())) {
            throw new IllegalStateException("This method does not support having a different viewer than" +
                    " the same cosmetic holder. Needs to be updated to support the overload that takes a viewer and" +
                    " a cosmetic holder instead of a single CosmeticUser.");
        }
        return user;
    }
}
