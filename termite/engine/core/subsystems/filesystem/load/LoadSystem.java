package engine.core.subsystems.filesystem.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResources;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveGame;
import engine.instance.Message;
import java.io.File;
import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class LoadSystem implements EngineSubsystem {

	private static final Message ASK_MSG;
	private static final Message SUC_MSG;

	static {
		ASK_MSG = new Message("What file do you want to load?");
		SUC_MSG = new Message("Game loaded successfully");
	}

    @Override
    public void execute() {

		// adding input for custom load
		String fileName =this.askForFileName();
		FileConnection connection = new FileConnection(fileName);

		ObjectMapper mapper = new JsonMapper();

		try {
			
			SaveGame save = mapper.readValue(connection.getConnection(), SaveGame.class);
			ApplicationResources.GAME.setCurrentInstance(save.getInstanceId());
		} catch (IOException e) {

			ApplicationResources.OUT.printError(e);
			return;
		}

		ApplicationResources.OUT.printMessage(SUC_MSG);

		/*
			This is the f* reason why I don't like this static class..
		*/
		 ApplicationResources.wasInstanceSwitch = false;
    }

	private String askForFileName() {

		this.printAllGames();
		ApplicationResources.OUT.printMessage(ASK_MSG);
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
