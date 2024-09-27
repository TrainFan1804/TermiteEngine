package de.o.le.termiteengine.engine.core.subsystem.filesystem.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.core.subsystem.filesystem.util.FileConnection;
import de.o.le.termiteengine.engine.core.subsystem.filesystem.util.SaveGame;
import java.io.IOException;

/**
 * @author o.le
 * @version 1.1
 * @since 1.2.0
 */
class LoadFileLoader {

	private final EngineResources RES;
	private final ObjectMapper mapper;
	
	LoadFileLoader() {
		
		this.RES = EngineResources.getInstance();
		this.mapper = new JsonMapper();
	}

	void load(FileConnection con) {

		try {

			SaveGame save = this.mapper.readValue(con.getConnection(), SaveGame.class);
			this.RES.GAME.setCurrentInstance(save.getInstanceId());
			this.RES.OUT.printMessage(MessageType.MSG_LOAD_SUC);
		} catch (IOException ex) {

			this.RES.OUT.printError(ex);
		}
	}
}
