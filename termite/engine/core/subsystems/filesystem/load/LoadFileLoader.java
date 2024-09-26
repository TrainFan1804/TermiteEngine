package engine.core.subsystems.filesystem.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResourcesSingleton;
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

	private final ApplicationResourcesSingleton RES;
	private final ObjectMapper mapper;
	
	LoadFileLoader() {
		
		this.RES = ApplicationResourcesSingleton.getInstance();
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
