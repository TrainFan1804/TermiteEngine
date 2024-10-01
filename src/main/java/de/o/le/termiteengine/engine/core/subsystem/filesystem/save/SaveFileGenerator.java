package de.o.le.termiteengine.engine.core.subsystem.filesystem.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.engine.core.subsystem.filesystem.util.FileConnection;
import de.o.le.termiteengine.engine.core.subsystem.filesystem.util.SaveGame;
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
