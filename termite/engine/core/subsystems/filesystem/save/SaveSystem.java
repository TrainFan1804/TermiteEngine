package engine.core.subsystems.filesystem.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResources;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.NoOverrideException;
import engine.core.subsystems.filesystem.utils.SaveGame;
import engine.core.services.output.Message;
import engine.core.services.output.MessageType;
import java.io.IOException;

/**
 * TODO more classes?
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.22
 */
class SaveSystem implements EngineSubsystem {

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

		ApplicationResources.OUT.printMessage(MessageType.MSG_SAVE_SUC);
    }

	private String askForFileName() {

		ApplicationResources.OUT.printMessage(MessageType.MSG_SAVE_ASK_FILE);
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

		ApplicationResources.OUT.printMessage(MessageType.MSG_SAVE_OVR_FILE);

		String input;
		do {

			input = ApplicationResources.IN.read().toUpperCase();

			if (input.equals("Y")) return;

			if (input.equals("N")) throw new NoOverrideException(); 

		} while(true);
	}
}
