package de.o.le.termite.engine.core.service.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import de.o.le.termite.engine.core.EngineOutputResource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A object of this class is used to read the JSON file that contains all
 * custom messages that should be printed out from the engine.
 * 
 * @author o.le
 * @version 1.2
 * @since 1.1.0
 */
class MessageContentReader {
	
	/**
	 * Will map the content of the file to a map that contains the name
	 * of the {@link MessageType} and the message itself. Both as string 
	 * values.
	 * 
	 * @param contentFile The file that contains the output content.
	 * @return The mapped values from the file.
	 */
	Map<String, String> read(File contentFile) {

		ObjectMapper mapper = new JsonMapper();
		Map<String, String> content = null;
		try {

			content = mapper.readValue(contentFile, HashMap.class);
		} catch (IOException e) {
			
			EngineOutputResource.getInstance().OUT.printError(e);
		}
		
		return content;
	}
}
