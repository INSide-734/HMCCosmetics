package com.hibiscusmc.hmccosmetics.database;

import com.hibiscusmc.hmccosmetics.cosmetic.Cosmetic;
import com.hibiscusmc.hmccosmetics.cosmetic.CosmeticSlot;
import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserData {

    @Getter
    private UUID owner;
    @Setter
    @Getter
    private HashMap<CosmeticSlot, Map.Entry<Cosmetic, Integer>> cosmetics;
    @Getter
    private ArrayList<CosmeticUser.HiddenReason> hiddenReasons;

    public UserData(UUID owner) {
        this.owner = owner;
        this.cosmetics = new HashMap<>();
        this.hiddenReasons = new ArrayList<>();
    }

    public void addCosmetic(CosmeticSlot slot, Cosmetic cosmetic, Integer color) {
        cosmetics.put(slot, Map.entry(cosmetic, color));
    }

    public void addHiddenReason(CosmeticUser.HiddenReason reason) {
        hiddenReasons.add(reason);
    }
}
