package engine.core.subsystems.filesystem.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.IOException;

/**
 * @author o.le
 * @version 1.1
 * @since 1.2.0
 */
class LoadFileLoader {

	private final ObjectMapper mapper;
	
	LoadFileLoader() {
		
		this.mapper = new JsonMapper();
	}

	void load(FileConnection con) {

		try {

			SaveGame save = this.mapper.readValue(con.getConnection(), SaveGame.class);
			ApplicationResources.GAME.setCurrentInstance(save.getInstanceId());
			ApplicationResources.OUT.printMessage(MessageType.MSG_LOAD_SUC);
			ApplicationResources.wasInstanceSwitch = false;
		} catch (IOException e) {

			ApplicationResources.OUT.printError(e);
		}
	}
}
