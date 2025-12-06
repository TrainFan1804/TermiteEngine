package de.o.le.termite.backend;

import de.o.le.termite.data.GameObject;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.4
 * @deprecated                          Deprecated because the information about
 *                                      data paths and co. are saved in {@link data/GameObject}
 */
@Deprecated(since = "25.12.6", forRemoval = true)
public class GameObjectRegistry {

    private GameObjectRegistry() {}

    private static final Map<String, GameObject> REGISTRY = Map.of(
            "room", GameObject.ROOM,
            "player", GameObject.PLAYER
    );

    private static final Map<GameObject, Path> PATH_REGISTRY = Map.of(
            GameObject.PLAYER, Paths.get(""),
            GameObject.ROOM, Paths.get("data/rooms")
    );

    public static GameObject getType(String type) { return REGISTRY.get(GameObject.valueOf(type)); }

    public static Path getTypePath(Class<?> type) {
        return PATH_REGISTRY.get(type);
    }
}
