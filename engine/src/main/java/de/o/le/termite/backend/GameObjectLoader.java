package de.o.le.termite.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
public class GameObjectLoader {

    private final Path GAME_DIR;

    public GameObjectLoader(String gameDir) throws FileNotFoundException {
        // this look very scary...
        String path = System.getProperty("user.dir") + "/../" + gameDir;
        this.GAME_DIR = Paths.get(path);
        if (!Files.exists(GAME_DIR)) {
            throw new FileNotFoundException("Game path '" + gameDir + "' doesn't exist");
        }
    }

    /**
     * Load a file handler into memory.
     *
     * @param fileName                  The name of the file that should be read.
     * @return                          The file handler.
     * @throws FileNotFoundException    Will be thrown when the file doesn't exist.
     */
    public File loadFile(Path fileName) throws FileNotFoundException {

        String path = GAME_DIR + "/" + fileName + ".json";
        File f = new File(path);
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + path + "' doesn't exists.");
        }
        return f;
    }
}
