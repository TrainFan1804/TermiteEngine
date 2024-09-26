package engine.core.services.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResourcesSingleton;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A object of this class is used to read the JSON file that contains all
 * custom messages that should be printed out from the engine.
 * 
 * @author o.le
 * @version 1.1
 * @since 1.1.0
 */
class MessageContentReader {
	
	Map<String, String> read(String path) {

		ObjectMapper mapper = new JsonMapper();
		Map<String, String> content = null;
		try {

			content = mapper.readValue(new File(path), HashMap.class);
		} catch (IOException e) {
			
			ApplicationResourcesSingleton.INSTANCE.OUT.printError(e);
		}
		
		return content;
	}
}
