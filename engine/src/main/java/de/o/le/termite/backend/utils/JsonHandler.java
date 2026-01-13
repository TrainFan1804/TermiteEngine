package de.o.le.termite.backend.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import de.o.le.termite.backend.data.GameObject;

import java.io.File;
import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.13
 */
public class JsonHandler {

    private final ObjectWriter WRITER;

    public JsonHandler() {
        this.WRITER = new JsonMapper().writerWithDefaultPrettyPrinter();
    }

    public void saveFileValue(File file) {

        try {
            this.WRITER.withDefaultPrettyPrinter().writeValues(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
