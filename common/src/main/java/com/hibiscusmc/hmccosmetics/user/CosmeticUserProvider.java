package com.hibiscusmc.hmccosmetics.user;

import com.hibiscusmc.hmccosmetics.HMCCosmeticsPlugin;
import com.hibiscusmc.hmccosmetics.database.UserData;
import org.bukkit.plugin.Plugin;

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
     */
    CosmeticUser createCosmeticUser(UUID playerId, UserData userData);

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
        public CosmeticUser createCosmeticUser(UUID playerId, UserData userData) {
            return new CosmeticUser(playerId, userData);
        }

        @Override
        public Plugin getProviderPlugin() {
            return HMCCosmeticsPlugin.getInstance();
        }
    }
}