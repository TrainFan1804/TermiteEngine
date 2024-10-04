package de.o.le.termiteengine.engine.core.subsystem.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import de.o.le.termiteengine.engine.core.EngineOutputResource;
import de.o.le.termiteengine.engine.core.subsystem.util.SaveGame;
import java.io.File;
import java.io.IOException;

/**
 * This class will generate the save file.
 * <p>
 * Not the entire class but the part where the file is writing should be moved
 * into the filesystem package.
 * 
 * @author o.le
 * @version 1.1
 * @since 1.1.1
 */
class SaveFileGenerator {

	/**
	 * Fill the given file with the content of the {@link SaveGame}.
	 * 
	 * @param file The file that is saved to.
	 */
	void generateSaveFile(File file) {
		
		ObjectMapper mapper = new JsonMapper();

		try {
			
			SaveGame save = SaveGame.generateSaveGame();
			// this line was meant by the JavaDoc
			mapper.writerWithDefaultPrettyPrinter()
					.writeValue(file, save);
		} catch (IOException e) {

			EngineOutputResource.getInstance().OUT.printError(e);
		}
	}
}
