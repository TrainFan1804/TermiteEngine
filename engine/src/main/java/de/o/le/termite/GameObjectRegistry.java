package de.o.le.termite;

import de.o.le.termite.data.GameObject;
import de.o.le.termite.data.Room;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.4
 */
public class GameObjectRegistry {

    private GameObjectRegistry() {}

    private static final Map<Class<?>, Path> PATH_REGISTRY = Map.of(
            Room.class, Paths.get("data/rooms")
    );

    private static final Map<String, Class<?>> REGISTRY = Map.of(
            "room", Room.class
    );

    public static Path getTypePath(Class<?> type) {
        return PATH_REGISTRY.get(type);
    }

    public static Class<?> getType(String type) {
        return REGISTRY.get(type);
    }
}
