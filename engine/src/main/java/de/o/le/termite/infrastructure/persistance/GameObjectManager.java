package de.o.le.termite.infrastructure.persistance;

import de.o.le.termite.application.port.GameObjectRepository;
import de.o.le.termite.application.EngineContext;

import de.o.le.termite.core.model.GameObject;
import de.o.le.termite.application.state.SaveState;

import de.o.le.termite.infrastructure.persistance.utils.IdInjector;

import de.o.le.termite.util.TimeUtils;

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
 *
 * TODO this class could benefit from a file cache buffer
 */
public class GameObjectManager implements GameObjectRepository {

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
    @Override
    public <T> T getData(GameObject type, String data) {

        Path path = new GameObjectStorageConfig().resolvePath(type).resolve(data); //type.getPath().resolve(data);
        try {
            File dataFile = loader.createFileHander(path);
            T t = jsonHandler.loadFileValue(dataFile, type);
            IdInjector.inject(t, path);
            return t;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadData(SaveState state) {

        Path path = Path.of(TimeUtils.getCurrentTimeStamp());
        try {
            File saveFile = loader.createFile(path);
            this.jsonHandler.saveFileValue(saveFile, state);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
