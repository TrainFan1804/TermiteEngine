package de.o.le.termite.infrastructure.persistance;

import de.o.le.termite.core.model.GameObject;
import de.o.le.termite.core.model.Inventory;
import de.o.le.termite.core.model.Player;
import de.o.le.termite.core.model.Item;
import de.o.le.termite.infrastructure.entity.room.RoomEntity;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.02.13
 */
public class GameObjectStorageConfig {

    static final Map<GameObject, Class<?>> typeMap = Map.of(
            GameObject.ROOM, RoomEntity.class,
            GameObject.PLAYER, Player.class,
            GameObject.ITEM, Item.class,
            GameObject.INVENTORY, Inventory.class
    );

    public Path resolvePath(GameObject type) {
        return switch (type) {
            case ROOM -> Paths.get("data/rooms");
            case PLAYER, INVENTORY -> Paths.get("data/user");
            case ITEM -> Paths.get("data/items");
        };
    }
}
