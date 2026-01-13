package de.o.le.termite.backend;

import de.o.le.termite.util.LogService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class provide a simple interface to load any kind of game file handler into
 * memory.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.3
 * @implNote                            This file loader will buffer one file to
 *  avoid loading the same file multiple times.
 */
public class GameFileHandler {

    private static final LogService LOG = new LogService(GameFileHandler.class.getName());

    private final Path GAME_DIR;
    private final Path SAVE_DIR;

    private File currentFile;

    /**
     * @param gameDir   The game dir is set <b>once</b> at the engines start up.
     *                  The game dir is the directory the engine is looking for
     *                  game data files (e.g. room files).
     * @throws FileNotFoundException
     */
    public GameFileHandler(String gameDir) throws FileNotFoundException {
        // this look very scary...
        String path = System.getProperty("user.dir") + "/../" + gameDir;
        this.GAME_DIR = Paths.get(path);
        if (!Files.exists(GAME_DIR)) {
            throw new FileNotFoundException("Game path '" + gameDir + "' doesn't exist");
        }
        this.SAVE_DIR = Paths.get(this.GAME_DIR + "/save");
        LOG.config("Setup file loader with game path: '" + gameDir + "'");
    }

    /**
     * Create a file handler.
     * <p>
     *     <b>Important:</b> This does <b>NOT</b> create a not existing file, only
     *     creating a handle to the file!
     * </p>
     *
     * @param fileName                  The name of the file that should be read.
     * @return                          The file handler.
     * @throws FileNotFoundException    Will be thrown when the file doesn't exist.
     */
    public File createFileHander(Path fileName) throws FileNotFoundException {

        Path path = Path.of(String.valueOf(GAME_DIR), fileName + ".json");

        if (isCurrentFile(path)) {
            return currentFile;
        }

        File f = path.toFile();
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + path + "' doesn't exists.");
        }
        LOG.fine("Load file '" + fileName + "' successfully");
        currentFile = f;
        return f;
    }

    private boolean isCurrentFile(Path fileName) {
        return currentFile != null && currentFile.toPath().equals(fileName);
    }

    // TODO improve this ugly monster
    public File createFile(Path fileName) throws IOException {

        Path fullPath = Path.of(String.valueOf(SAVE_DIR), fileName + ".json");

        if (!Files.exists(fullPath.getParent())) {
            Files.createDirectory(fullPath.getParent());
        }
        if (!Files.exists(fullPath)) {
            Files.createFile(fullPath);
        }

        File f = fullPath.toFile();
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + fullPath + "' doesn't exists.");
        }
        LOG.fine("File '" + fileName + "' created successfully.");
        return f;
    }
}
