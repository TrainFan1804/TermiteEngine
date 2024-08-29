package engine.core.subsystems.filesystem.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.ApplicationResources;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class LoadSystem implements EngineSubsystem {

    @Override
    public void execute() {

		FileConnection connection = new FileConnection("test");
		ObjectMapper mapper = new JsonMapper();

		try {
			
			System.out.println("hier bin ich");
			SaveGame save = mapper.readValue(connection.getConnection(), SaveGame.class);
			System.out.println(save.getInstanceId());
			// ApplicationResources.GAME.setCurrentInstance(id);
		} catch (FileNotFoundException ex) {

			System.out.println("File doesn't exist!");
		} catch (IOException ex) {

			System.out.println(ex.getLocalizedMessage());
		}

        System.out.println("Game load succefully"); // also print new current instance

		/*
			This is the f* reason why I don't like this static class..
		*/
		 // ApplicationResources.wasInstanceSwitch = false;
    }
}
