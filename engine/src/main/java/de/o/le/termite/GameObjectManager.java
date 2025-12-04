package de.o.le.termite;

import de.o.le.termite.data.GameObject;
import de.o.le.termite.data.Room;
import de.o.le.termite.engine.filesystem.JsonLoadHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.4
 */
public class GameObjectManager {
    private GameObjectLoader loader;
    private JsonLoadHandler jsonHandler;

    public GameObjectManager() throws FileNotFoundException {
        loader = new GameObjectLoader("game/default");
        jsonHandler = new JsonLoadHandler();
    }

    public Room getData(String type, String data) {

        Class<?> path = GameObjectRegistry.getType(type);

        switch (type) {
            case "ROOM" -> {
                try {
                    Path p = GameObjectRegistry.getTypePath(path);
                    var v = loader.loadFile(p);
                    return (Room) jsonHandler.loadFileValue(v, path);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}
