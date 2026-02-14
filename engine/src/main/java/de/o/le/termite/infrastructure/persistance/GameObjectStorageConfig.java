package de.o.le.termite.infrastructure.persistance;

import de.o.le.termite.core.model.Inventory;
import de.o.le.termite.core.model.Item;
import de.o.le.termite.core.model.Player;
import de.o.le.termite.core.model.room.Room;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.02.13
 */
public class GameObjectStorageConfig {

    private static final String ROOM_PATH_STR = "data/rooms";
    private static final String PLAYER_INV_PATH_STR = "data/user";
    private static final String ITEM_PATH_STR = "data/items";

    public Path resolvePath(GameObject type) {
        if (type instanceof Room) {
            return Paths.get(ROOM_PATH_STR);
        } else if (type instanceof Player || type instanceof Inventory) {
            return Paths.get(PLAYER_INV_PATH_STR);
        } else if (type instanceof Item) {
            return Paths.get(ITEM_PATH_STR);
        }
        return Paths.get("");
    }
}
