package engine.core.subsystems.filesystem.load;

import engine.core.ApplicationResourcesSingleton;
import java.io.File;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.0
 */
class GameFilePrinter {

	private final File FOLDER = new File("./");

	void printName() {

		File[] folderContent = this.FOLDER.listFiles((dir, name) ->
														name.toLowerCase()
															.endsWith(".json"));

		for (File file : folderContent) {

			ApplicationResourcesSingleton.INSTANCE.OUT.printString(file.getName());
		}
	}
}
