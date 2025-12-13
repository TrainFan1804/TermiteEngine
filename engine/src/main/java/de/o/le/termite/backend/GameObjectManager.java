package de.o.le.termite.backend;

import de.o.le.termite.data.GameObject;
import de.o.le.termite.engine.filesystem.JsonLoadHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.4
 *
 * @apiNote Instead of creating a new object of that class use the provided
 * instance in {@link EngineContext}.
 */
public class GameObjectManager {

    private GameObjectLoader loader;
    private JsonLoadHandler jsonHandler;

    public GameObjectManager(String gameDir) throws FileNotFoundException {
        loader = new GameObjectLoader(gameDir);
        jsonHandler = new JsonLoadHandler();
    }

    public <T> T getData(GameObject type, String data) {

        Path path = type.getPath().resolve(data);
        try {
            File dataFile = loader.loadFile(path);
            return jsonHandler.loadFileValue(dataFile, type.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
