package engine.core.subsystems.filesystem.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResources;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveFileAlreadyExistException;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class LoadSystem implements EngineSubsystem {

    @Override
    public void execute() {

		// adding input for custom load
		FileConnection connection = null;

		connection = new FileConnection("test");

		ObjectMapper mapper = new JsonMapper();

		try {
			
			SaveGame save = mapper.readValue(connection.getConnection(), SaveGame.class);
			ApplicationResources.GAME.setCurrentInstance(save.getInstanceId());
		} catch (IOException ex) {

			System.out.println(ex.getLocalizedMessage());
		}

        System.out.println("Game load succefully"); // also print new current instance

		/*
			This is the f* reason why I don't like this static class..
		*/
		 ApplicationResources.wasInstanceSwitch = false;
    }
}
