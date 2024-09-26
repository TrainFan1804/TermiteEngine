package engine.core.subsystems.filesystem.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.EngineResources;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.IOException;

/**
 * @author o.le
 * @version 1.0
 * @since 1.1.1
 */
class SaveFileGenerator {

	void generateSaveFile(FileConnection con) {
		
		ObjectMapper mapper = new JsonMapper();

		try {
			
			SaveGame save = SaveGame.generateSaveGame();
			mapper.writerWithDefaultPrettyPrinter()
					.writeValue(con.getConnection(), save);
		} catch (IOException e) {

			EngineResources.INSTANCE.OUT.printError(e);
		}
	}
}
