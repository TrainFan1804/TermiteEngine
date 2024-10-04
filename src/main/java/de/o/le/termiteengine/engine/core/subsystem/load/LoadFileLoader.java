package de.o.le.termiteengine.engine.core.subsystem.load;

import de.o.le.termiteengine.engine.core.EngineOutputResource;
import de.o.le.termiteengine.engine.core.EngineSystemResources;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.core.subsystem.util.SaveGame;
import de.o.le.termiteengine.engine.filesystem.JsonLoadHandler;
import java.io.File;
import java.io.IOException;

/**
 * This class will load a save file.
 * 
 * @author o.le
 * @version 1.3
 * @since 1.2.0
 */
class LoadFileLoader {

	/**
	 * Load the given save file and reorganize the game so the player can
	 * play further his game.
	 * 
	 * @param file The save file that is loaded.
	 */
	void load(File file) {

		JsonLoadHandler loader = new JsonLoadHandler();
		try {

			SaveGame save = loader.loadFileValue(file, SaveGame.class);
			EngineSystemResources.getInstance().GAME.setCurrentInstance(save.getInstanceId());
			EngineOutputResource.getInstance().OUT.printMessage(MessageType.MSG_LOAD_SUC);
		} catch (IOException e) {

			EngineOutputResource.getInstance().OUT.printError(e);
		}
	}
}
