package com.hibiscusmc.hmccosmetics.database.types;

import com.hibiscusmc.hmccosmetics.database.UserData;
import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class NoneData extends Data {
    @Override
    public void setup() {
        // Nothing
    }

    @Override
    public void save(CosmeticUser user) {
        // Nothing
    }

    @Override
    public @Nullable CompletableFuture<UserData> get(UUID uniqueId) {
        return CompletableFuture.completedFuture(new UserData(uniqueId));
    }

    @Override
    public void clear(UUID uniqueId) {
        // Nothing
    }
}
