package de.o.le.termiteengine.engine.core.subsystem.filesystem.load;

import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.core.subsystem.filesystem.util.FileConnection;
import de.o.le.termiteengine.engine.core.subsystem.filesystem.util.SaveGame;
import de.o.le.termiteengine.engine.filesystem.JsonLoader;
import java.io.IOException;

/**
 * @author o.le
 * @version 1.2
 * @since 1.2.0
 */
class LoadFileLoader {

	private final EngineResources RES;
	
	LoadFileLoader() {
		
		this.RES = EngineResources.getInstance();
	}

	void load(FileConnection con) {

		JsonLoader loader = new JsonLoader();
		try {

			SaveGame save = loader.loadFileValue(con.getConnection(), SaveGame.class);
			this.RES.GAME.setCurrentInstance(save.getInstanceId());
			this.RES.OUT.printMessage(MessageType.MSG_LOAD_SUC);
		} catch (IOException e) {

			this.RES.OUT.printError(e);
		}
	}
}
