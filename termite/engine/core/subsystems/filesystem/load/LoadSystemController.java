package engine.core.subsystems.filesystem.load;

import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.IOException;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.0
 */
class LoadSystemController {

	void init() {

		GameFilePrinter printer = new GameFilePrinter();
		printer.printName();

		LoadFileNameExtractor extractor = new LoadFileNameExtractor();
		String fileName = extractor.askForFileName();

		FileConnection con = new FileConnection(fileName);

		LoadFileLoader loader = new LoadFileLoader();

		try {

			SaveGame save = loader.readDataFromFile(con);
			ApplicationResources.GAME.setCurrentInstance(save.getInstanceId());
			ApplicationResources.OUT.printMessage(MessageType.MSG_LOAD_SUC);
			ApplicationResources.wasInstanceSwitch = false;
		} catch (IOException e) {

			ApplicationResources.OUT.printError(e);
		}
	}
}
