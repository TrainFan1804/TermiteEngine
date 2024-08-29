package engine.core.subsystems.filesystem.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResources;
import engine.core.services.InputService;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.SaveFileAlreadyExistException;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class SaveSystem implements EngineSubsystem {

    @Override
    public void execute() {

		// adding input for name of the file 
		ApplicationResources.OUT.printString("Name of the save game?");
		String saveGameFileName = ApplicationResources.IN.read();
		if (saveGameFileName.isEmpty()) saveGameFileName = "default";

		FileConnection connection = new FileConnection(saveGameFileName);

		// check here if file already exists and ask the user if he want to override it

		ObjectMapper mapper = new JsonMapper();

		try {

			SaveGame save = SaveGame.generateSaveGame();
			mapper.writerWithDefaultPrettyPrinter()
					.writeValue(connection.getConnection(), save);
		} catch (IOException e) {

			System.out.println(e.getLocalizedMessage());
		}

        System.out.println("Game saved succefully");
    }
}
