package de.o.le.termite.backend.utils;

import de.o.le.termite.backend.SaveState;
import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.util.LogService;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;

/**
 * This class will load a Json formatted file and map it to a given type.
 * 
 * @author o.le
 * @version 1.3
 * @since 1.4.5
 */
public class JsonLoadHandler {

	private static final LogService LOG = new LogService(JsonLoadHandler.class.getName());

	private final ObjectMapper MAPPER;

	/**
	 * Create a JsonLoadHandler instance.
	 */
	public JsonLoadHandler() {

		this.MAPPER = new JsonMapper();
        this.MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		this.MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
	}

	/**
	 * This method will read a file and map the content of the file to the
	 * given type.
	 * <p>
	 * <b>Caution</b>: Will <b>NOT</b> handle any exception!
	 * 
	 * @param <T> The type that was mapped from the files content.
	 * @param file The file that is read
	 * @param go The type that should be mapped
	 * @return The mapped object
	 * @throws IOException
	 */
	public <T> T loadFileValue(File file,  GameObject go) {

        try {
            T t = this.MAPPER.readValue(file, go.getType());
			LOG.filesystem("Game file '" + file + "' read and deserialized successfully");
			return t;
        } catch (IOException e) {
			LOG.error("Something went wrong: " + e);
            throw new RuntimeException(e);
        }
	}

	public void saveFileValue(File file, SaveState state) {

		try {
			this.MAPPER.writeValue(file, state);
			LOG.filesystem("Game state successfully serialized into '" + file + "'");
		} catch (IOException e) {
			LOG.error("Something went wrong: " + e);
			throw new RuntimeException();
		}
	}
}
