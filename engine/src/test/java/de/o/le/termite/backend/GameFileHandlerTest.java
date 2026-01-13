package de.o.le.termite.backend;

import de.o.le.termite.TestSetting;
import de.o.le.termite.backend.manager.GameFileHandler;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.13
 */
class GameFileHandlerTest {

    @Test
    void createFile() {

        try {
            GameFileHandler gfl = new GameFileHandler(TestSetting.GAME_DIR);
            File f = gfl.createFile(Path.of(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString()));
            assertTrue(f.exists());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}