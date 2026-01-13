package de.o.le.termite.backend.data;

import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.backend.data.room.Room;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This enum represent data in the created game but not in a
 * logical view but in a storage view. E.g. it saves information about the
 * path where different data objects are saved.
 *
 * @author                              o.le
 * @version                             1.3
 * @since                               25.12.4
 */
public enum GameObject {
    ROOM(Room.class, "data/rooms"),
    PLAYER(Player.class, "data/user"),
    ITEM(Item.class, "data/items"),
    INVENTORY(Inventory.class, "data/user");

    private final Class<?> type;
    private final Path path;

    GameObject(Class<?> type, String path) {
        this.type = type;
        this.path = Paths.get(path);
    }

    public <T> Class<T> getType() { return (Class<T>) this.type; }

    public Path getPath() { return this.path; }
}
