package engine.core.subsystems.filesystem.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.IOException;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.0
 */
class LoadFileLoader {

	private final ObjectMapper mapper;
	
	LoadFileLoader() {
		
		this.mapper = new JsonMapper();
	}

	SaveGame readDataFromFile(FileConnection con) throws IOException {
		
		return mapper.readValue(con.getConnection(), SaveGame.class);
	}
}
