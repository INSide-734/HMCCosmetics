package com.hibiscusmc.hmccosmetics.user;

import com.hibiscusmc.hmccosmetics.HMCCosmeticsPlugin;
import com.hibiscusmc.hmccosmetics.database.UserData;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Allow custom implementations of a {@link CosmeticUser}.
 */
public interface CosmeticUserProvider {
    CosmeticUserProvider DEFAULT = new Default();

    /**
     * Construct the custom {@link CosmeticUser}.
     * @param playerId the player uuid
     * @param userData the user data associated with the player
     * @return the {@link CosmeticUser}
     * @apiNote This method is called during the {@link PlayerJoinEvent}.
     */
    @NotNull CosmeticUser createCosmeticUser(@NotNull UUID playerId, @NotNull UserData userData);

    /**
     * Construct the custom {@link CosmeticUser}.
     * @param playerId the player uuid
     * @return the {@link CosmeticUser}
     * @apiNote This method is called during the {@link PlayerJoinEvent}.
     */
    @NotNull CosmeticUser createCosmeticUserWithoutData(@NotNull UUID playerId);

    /**
     * Represents the plugin that is providing this {@link CosmeticUserProvider}
     * @return the plugin
     */
    Plugin getProviderPlugin();

    /**
     * Default implementation.
     */
    class Default implements CosmeticUserProvider {
        @Override
        public @NotNull CosmeticUser createCosmeticUser(@NotNull UUID playerId, @NotNull UserData userData) {
            return new CosmeticUser(playerId, userData);
        }

        @Override
        public @NotNull CosmeticUser createCosmeticUserWithoutData(@NotNull UUID playerId) {
            return new CosmeticUser(playerId);
        }

        @Override
        public Plugin getProviderPlugin() {
            return HMCCosmeticsPlugin.getInstance();
        }
    }
}