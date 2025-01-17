package com.hibiscusmc.hmccosmetics.cosmetic;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CosmeticSlot {
    private static final ConcurrentHashMap<String, CosmeticSlot> REGISTRY = new ConcurrentHashMap<>();

    public static final CosmeticSlot HELMET = new CosmeticSlot("HELMET");
    public static final CosmeticSlot CHESTPLATE = new CosmeticSlot("CHESTPLATE");
    public static final CosmeticSlot LEGGINGS = new CosmeticSlot("LEGGINGS");
    public static final CosmeticSlot BOOTS = new CosmeticSlot("BOOTS");
    public static final CosmeticSlot MAINHAND = new CosmeticSlot("MAINHAND");
    public static final CosmeticSlot OFFHAND = new CosmeticSlot("OFFHAND");
    public static final CosmeticSlot BACKPACK = new CosmeticSlot("BACKPACK");
    public static final CosmeticSlot BALLOON = new CosmeticSlot("BALLOON");
    public static final CosmeticSlot EMOTE = new CosmeticSlot("EMOTE");
    public static final CosmeticSlot CUSTOM = new CosmeticSlot("CUSTOM");

    private final String name;

    private CosmeticSlot(@NotNull String name) {
        this.name = name;
        REGISTRY.put(name, this);
    }

    public static CosmeticSlot register(@NotNull String name) {
        name = name.toUpperCase();
        return REGISTRY.computeIfAbsent(name, key -> new CosmeticSlot(key));
    }

    public static Map<String, CosmeticSlot> values() {
        return Collections.unmodifiableMap(REGISTRY);
    }

    public static CosmeticSlot valueOf(@NotNull String name) {
        name = name.toUpperCase();
        return REGISTRY.get(name);
    }

    /**
     * Checks if the registry contains a slot with the given name.
     * @param name
     * @return
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
