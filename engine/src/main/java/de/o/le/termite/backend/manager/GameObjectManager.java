package de.o.le.termite.backend.manager;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.GameFileHandler;
import de.o.le.termite.backend.SaveState;
import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.backend.utils.JsonLoadHandler;
import de.o.le.termite.backend.utils.TimeUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * This class provide an interface to handle game data objects easily.
 *
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.4
 *
 * @apiNote Instead of creating a new object of that class use the provided
 * instance in {@link EngineContext}.
 */
public class GameObjectManager {

    private GameFileHandler loader;
    private JsonLoadHandler jsonHandler;

    public GameObjectManager(String gameDir) throws FileNotFoundException {
        loader = new GameFileHandler(gameDir);
        jsonHandler = new JsonLoadHandler();
    }

    /**
     * Load a game data object from a file. The file location will be automatically
     * determined by the {@code type} param and the file name by the {@code data} param.
     *
     * @param type
     * @param data
     * @return
     * @param <T>
     */
    public <T> T getData(GameObject type, String data) {

        Path path = type.getPath().resolve(data);
        try {
            File dataFile = loader.createFileHander(path);
            return jsonHandler.loadFileValue(dataFile, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setData(SaveState state) {

        Path path = Path.of(TimeUtils.getCurrentTimeStamp());
        try {
            File saveFile = loader.createFile(path);
            this.jsonHandler.saveFileValue(saveFile, state);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
