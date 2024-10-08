package de.o.le.termite.engine.core.subsystem.load;

import de.o.le.termite.engine.core.EngineOutputResource;
import de.o.le.termite.engine.core.service.output.MessageType;
import de.o.le.termite.engine.core.subsystem.util.ExitFileMenuException;
import de.o.le.termite.engine.core.subsystem.util.FileNameExtractor;
import java.io.File;

/**
 * This class is a controller to control the load routine. Will handle exceptions,
 * load order, etc.
 * 
 * @author o.le
 * @version 1.3
 * @since 1.2.0
 */
class LoadSystemController {

	/**
	 * Initialize the controller. 
	 */
	void init() {

		try {

			GameFilePrinter printer = new GameFilePrinter();
			printer.printName();

			// TODO add here loop aslong as it the input is valid or user enter "EXIT"
			File file;
			do {
				
				String fileName = this.askForFile();

				file = new File(fileName + ".json");
				// TODO this must be do better!
				if (!file.exists()) {

					EngineOutputResource.getInstance().OUT.printMessage(MessageType.MSG_LOAD_FILE_NOT_FOUNT);
				}

			} while(!file.exists());

			LoadFileLoader loader = new LoadFileLoader();
			loader.load(file);
		} catch (ExitFileMenuException e) {

			EngineOutputResource.getInstance().OUT.printMessage(MessageType.MSG_LOAD_CANCEL);
		}
	}

	/**
	 * Ask the player what file he want to load.
	 * 
	 * @throws ExitFileMenuException Will end the load routine.
	 */
	private String askForFile() throws ExitFileMenuException {

		FileNameExtractor extractor = new FileNameExtractor();
		String fileName = extractor.extractFileName(MessageType.MSG_SAVE_ASK_FILE);

		return fileName;
	}
}
