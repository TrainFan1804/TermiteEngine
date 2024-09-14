package engine.core.subsystems.filesystem.load;

import engine.core.subsystems.filesystem.utils.FileConnection;

/**
 * @author o.le
 * @version 1.1
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
		loader.load(con);
	}
}
