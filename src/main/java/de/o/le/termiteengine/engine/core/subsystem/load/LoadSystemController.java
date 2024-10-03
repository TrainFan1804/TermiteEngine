package de.o.le.termiteengine.engine.core.subsystem.load;

import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.core.subsystem.util.ExitFileMenuException;
import de.o.le.termiteengine.engine.core.subsystem.util.FileNameExtractor;
import java.io.File;

/**
 * @author o.le
 * @version 1.3
 * @since 1.2.0
 */
class LoadSystemController {

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

					EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_LOAD_FILE_NOT_FOUNT);
				}

			} while(!file.exists());

			LoadFileLoader loader = new LoadFileLoader();
			loader.load(file);
		} catch (ExitFileMenuException e) {

			EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_LOAD_CANCEL);
		}
	}

	private String askForFile() throws ExitFileMenuException {

		FileNameExtractor extractor = new FileNameExtractor();
		String fileName = extractor.extractFileName(MessageType.MSG_SAVE_ASK_FILE);

		return fileName;
	}
}
