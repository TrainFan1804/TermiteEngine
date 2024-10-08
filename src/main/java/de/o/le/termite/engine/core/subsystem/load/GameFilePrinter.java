package de.o.le.termite.engine.core.subsystem.load;

import de.o.le.termite.engine.core.EngineOutputResource;
import java.io.File;

/**
 * Will print out all files that are save files.
 * <p>
 * Should be moved to the filesystem package.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.2.0
 */
class GameFilePrinter {

	private final File FOLDER = new File("./");

	/**
	 * Print out all files that are save files.
	 */
	void printName() {

		File[] folderContent = this.FOLDER.listFiles((dir, name) ->
														name.toLowerCase()
															.endsWith(".json"));

		for (File file : folderContent) {

			EngineOutputResource.getInstance().OUT.printString(file.getName());
		}
	}
}
