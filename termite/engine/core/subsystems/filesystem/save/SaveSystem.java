package engine.core.subsystems.filesystem.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResources;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.NoOverrideException;
import engine.core.subsystems.filesystem.utils.SaveGame;
import engine.instance.Message;
import java.io.IOException;

/**
 * TODO more classes?
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class SaveSystem implements EngineSubsystem {

	private static final Message ASK_MSG;
	private static final Message SUC_MSG;
	private static final Message OVR_MSG;

	static {
		ASK_MSG = new Message("Name of the save game? Press enter to create with default name");
		OVR_MSG = new Message("Do you want to override this file? (Y/N)");
		SUC_MSG = new Message("Game saced successfully");
	}

    @Override
    public void execute() {


		String fileName = this.askForFileName();
		FileConnection connection = new FileConnection(fileName);

		// check here if file already exists and ask the user if he want to override it
		try {

			this.genSaveFile(connection);
		} catch (NoOverrideException e) {

			ApplicationResources.OUT.printError(e);
			return; 
		}

		ApplicationResources.OUT.printMessage(SUC_MSG);
    }

	private String askForFileName() {

		ApplicationResources.OUT.printMessage(ASK_MSG);
		String fileName = ApplicationResources.IN.read();
		if (fileName.isEmpty()) fileName = "default";
		
		return fileName; 
	}

	private void genSaveFile(FileConnection con) throws NoOverrideException {

		if (con.getConnection().exists()) this.askForOverride();

		ObjectMapper mapper = new JsonMapper();

		try {

			SaveGame save = SaveGame.generateSaveGame();
			mapper.writerWithDefaultPrettyPrinter()
					.writeValue(con.getConnection(), save);
		} catch (IOException e) {

			ApplicationResources.OUT.printError(e);
		}
	}

	private void askForOverride() throws NoOverrideException {

		ApplicationResources.OUT.printMessage(OVR_MSG);

		String input;
		do {

			input = ApplicationResources.IN.read().toUpperCase();

			if (input.equals("Y")) return;

			if (input.equals("N")) throw new NoOverrideException(); 

		} while(true);
	}
}
