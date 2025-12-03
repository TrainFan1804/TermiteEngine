package de.o.le.termite.engine.filesystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.File;
import java.io.IOException;

/**
 * This class will load a Json file and map it to a given type.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.5
 */
public class JsonLoadHandler {

	private final ObjectMapper MAPPER;

	/**
	 * Create a JsonLoadHandler instance.
	 */
	public JsonLoadHandler() {

		this.MAPPER = new JsonMapper();
	}

	/**
	 * This method will read a file and map the content of the file to the
	 * given type.
	 * <p>
	 * <b>Caution</b>: Will <b>NOT</b> handle any exception!
	 * 
	 * @param <T> The type that was mapped from the files content.
	 * @param file The file that is read
	 * @param type The type that should be mapped 
	 * @return The mapped object
	 * @throws IOException
	 */
	public <T> T loadFileValue(File file,  Class<T> type) throws IOException {

		return this.MAPPER.readValue(file, type);
	}
}
