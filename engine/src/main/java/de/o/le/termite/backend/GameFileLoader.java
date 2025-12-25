package de.o.le.termite.backend;

import de.o.le.termite.util.LogService;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class provide a simple interface to load any kind of game files into
 * memory.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.3
 * @implNote                            This file loader will buffer one file to
 *  avoid loading the same file multiple times.
 */
public class GameFileLoader {

    private static final LogService LOG = new LogService(GameFileLoader.class.getName());

    private final Path GAME_DIR;

    private File currentFile;

    /**
     * @param gameDir   The game dir is set <b>once</b> at the engines start up.
     *                  The game dir is the directory the engine is looking for
     *                  game data files (e.g. room files).
     * @throws FileNotFoundException
     */
    public GameFileLoader(String gameDir) throws FileNotFoundException {
        // this look very scary...
        String path = System.getProperty("user.dir") + "/../" + gameDir;
        this.GAME_DIR = Paths.get(path);
        if (!Files.exists(GAME_DIR)) {
            throw new FileNotFoundException("Game path '" + gameDir + "' doesn't exist");
        }
        LOG.info("Setup file loader with game path: '" + gameDir + "'");
    }

    /**
     * Load a file handler into memory.
     *
     * @param fileName                  The name of the file that should be read.
     * @return                          The file handler.
     * @throws FileNotFoundException    Will be thrown when the file doesn't exist.
     */
    public File loadFile(Path fileName) throws FileNotFoundException {

        Path path = Path.of(String.valueOf(GAME_DIR), fileName + ".json");

        if (isCurrentFile(path)) {
            return currentFile;
        }

        File f = path.toFile();
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + path + "' doesn't exists.");
        }
        LOG.info("Load file '" + fileName + "' successfully");
        currentFile = f;
        return f;
    }

    private boolean isCurrentFile(Path fileName) {
        return currentFile != null && currentFile.toPath().equals(fileName);
    }
}
