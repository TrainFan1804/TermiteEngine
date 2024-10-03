package de.o.le.termiteengine.engine.core.subsystem.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.engine.core.subsystem.filesystem.util.SaveGame;
import java.io.File;
import java.io.IOException;

/**
 * @author o.le
 * @version 1.1
 * @since 1.1.1
 */
class SaveFileGenerator {

	void generateSaveFile(File file) {
		
		ObjectMapper mapper = new JsonMapper();

		try {
			
			SaveGame save = SaveGame.generateSaveGame();
			mapper.writerWithDefaultPrettyPrinter()
					.writeValue(file, save);
		} catch (IOException e) {

			EngineResources.getInstance().OUT.printError(e);
		}
	}
}
