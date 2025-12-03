package de.o.le.termite;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
public class DataLoader {

    /**
     * Load a file handler into memory.
     *
     * @param fileName                  The name of the file that should be read.
     * @return                          The file handler.
     * @throws FileNotFoundException    Will be thrown when the file doesn't exist.
     */
    public static File loadFile(String fileName) throws FileNotFoundException {
        // this look very scary...
        String path = System.getProperty("user.dir") + "/../" + fileName;
        File f = new File(path);
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + path + "' doesn't exists.");
        }
        return f;
    }
}
