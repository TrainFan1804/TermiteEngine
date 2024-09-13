package engine.core.subsystems.filesystem.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResources;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveGame;
import engine.core.services.output.MessageType;
import java.io.File;
import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.22
 */
class LoadSystem implements EngineSubsystem {

    @Override
    public void execute() {

		// adding input for custom load
		String fileName = this.askForFileName();
		FileConnection connection = new FileConnection(fileName);

		ObjectMapper mapper = new JsonMapper();

		try {
			
			SaveGame save = mapper.readValue(connection.getConnection(), SaveGame.class);
			ApplicationResources.GAME.setCurrentInstance(save.getInstanceId());
		} catch (IOException e) {

			ApplicationResources.OUT.printError(e);
			return;
		}

		ApplicationResources.OUT.printMessage(MessageType.MSG_LOAD_SUC);

		/*
			This is the f* reason why I don't like this static class..
		*/
		 ApplicationResources.wasInstanceSwitch = false;
    }

	private String askForFileName() {

		this.printAllGames();
		ApplicationResources.OUT.printMessage(MessageType.MSG_LOAD_ASK_FILE);
		String input = ApplicationResources.IN.read();
		return input;
	}

	private void printAllGames() {

		File fold = new File("./");
		File[] files = fold.listFiles((dir, name) 
									-> name.toLowerCase().endsWith(".json"));

		for (File file : files) {

			ApplicationResources.OUT.printString(file.getName());
		}
	}
}
