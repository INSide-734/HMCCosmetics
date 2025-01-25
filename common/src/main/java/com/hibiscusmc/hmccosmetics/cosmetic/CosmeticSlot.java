package com.hibiscusmc.hmccosmetics.cosmetic;

import com.hibiscusmc.hmccosmetics.cosmetic.types.*;
import me.lojosho.shaded.configurate.ConfigurationNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CosmeticSlot {
    private static final ConcurrentHashMap<String, CosmeticSlot> REGISTRY = new ConcurrentHashMap<>();

    public static final CosmeticSlot HELMET = register("HELMET", CosmeticArmorType::new);
    public static final CosmeticSlot CHESTPLATE = register("CHESTPLATE", CosmeticArmorType::new);
    public static final CosmeticSlot LEGGINGS = register("LEGGINGS", CosmeticArmorType::new);
    public static final CosmeticSlot BOOTS = register("BOOTS", CosmeticArmorType::new);
    public static final CosmeticSlot MAINHAND = register("MAINHAND", CosmeticMainhandType::new);
    public static final CosmeticSlot OFFHAND = register("OFFHAND", CosmeticArmorType::new);
    public static final CosmeticSlot BACKPACK = register("BACKPACK", CosmeticBackpackType::new);
    public static final CosmeticSlot BALLOON = register("BALLOON", CosmeticBalloonType::new);
    public static final CosmeticSlot EMOTE = register("EMOTE", CosmeticEmoteType::new);

    private final String name;
    private final BiConsumer<String, ConfigurationNode> consumer;

    private CosmeticSlot(@NotNull String name, @NotNull BiConsumer<String, ConfigurationNode> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    /**
     * Accepts the given id and configuration node to run the consumer relating to the ConsumerSlot
     * @param id The id of the cosmetic
     * @param config The configuration node of the cosmetic
     */
    public void accept(@NotNull String id, @NotNull ConfigurationNode config) {
        consumer.accept(id, config);
    }

    /**
     * Registers a new slot with the given name. If a slot with the given name already exists, it will be returned.
     * @param name The name of the slot (This will automatically be converted into all UPPERCASE)
     * @return The slot that was registered or already exists.
     */
    @NotNull
    public static CosmeticSlot register(@NotNull String name, @NotNull BiConsumer<String, ConfigurationNode> consumer) {
        name = name.toUpperCase();
        return REGISTRY.computeIfAbsent(name, key -> new CosmeticSlot(key, consumer));
    }

    /**
     * Returns an unmodifiable map of all the slots that have been registered.
     * @return An unmodifiable map of all the slots that have been registered.
     */
    @NotNull
    public static Map<String, CosmeticSlot> values() {
        return Collections.unmodifiableMap(REGISTRY);
    }

    /**
     * Gets the slot with the given name.
     * @param name The name of the slot to get. This is automatically converted to all UPPERCASE.
     * @return The slot with the given name, or null if it does not exist.
     */
    @Nullable
    public static CosmeticSlot valueOf(@NotNull String name) {
        name = name.toUpperCase();
        return REGISTRY.get(name);
    }

    /**
     * Checks if the registry contains a slot with the given name.
     * @param name The name of the slot to check for. This is automatically converted to all UPPERCASE.
     * @return True if the slot exists, false otherwise.
     */
    public static boolean contains(@NotNull String name) {
        name = name.toUpperCase();
        return REGISTRY.containsKey(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
