package engine.core.subsystems.filesystem.load;

import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;
import engine.core.subsystems.filesystem.utils.ExitFileMenuException;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.FileNameExtractor;

/**
 * @author o.le
 * @version 1.2
 * @since 1.2.0
 */
class LoadSystemController {

	void init() {

		try {

			GameFilePrinter printer = new GameFilePrinter();
			printer.printName();

			// TODO add here loop aslong as it the input is valid or user enter "EXIT"
			FileNameExtractor extractor = new FileNameExtractor();
			String fileName = extractor.extractFileName(MessageType.MSG_SAVE_ASK_FILE);

			FileConnection con = new FileConnection(fileName);

			LoadFileLoader loader = new LoadFileLoader();
			loader.load(con);
		} catch (ExitFileMenuException e) {

			ApplicationResources.OUT.printMessage(MessageType.MSG_LOAD_CANCEL);
		}
	}
}
