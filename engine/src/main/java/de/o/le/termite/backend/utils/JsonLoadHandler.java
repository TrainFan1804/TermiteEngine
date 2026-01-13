package de.o.le.termite.backend.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import de.o.le.termite.backend.data.GameObject;

import java.io.File;
import java.io.IOException;

/**
 * This class will load a Json formatted file and map it to a given type.
 * 
 * @author o.le
 * @version 1.2
 * @since 1.4.5
 */
public class JsonLoadHandler {

	private final ObjectMapper MAPPER;

	/**
	 * Create a JsonLoadHandler instance.
	 */
	public JsonLoadHandler() {

		this.MAPPER = new JsonMapper();
        this.MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
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
	public <T> T loadFileValue(File file,  GameObject go) throws IOException {

		return this.MAPPER.readValue(file, go.getType());
	}
}
