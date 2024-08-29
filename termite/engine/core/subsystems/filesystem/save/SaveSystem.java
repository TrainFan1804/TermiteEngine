package engine.core.subsystems.filesystem.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class SaveSystem implements EngineSubsystem {


    @Override
    public void execute() {

		// adding input for name of the file 
		FileConnection connection = new FileConnection("test");

		ObjectMapper mapper = new JsonMapper();

		try {

			SaveGame save = SaveGame.generateSaveGame();
			mapper.writeValue(connection.getConnection(), save);

			String v = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(save);
			System.out.println(v);
		} catch (IOException e) {

			System.out.println(e.getLocalizedMessage());
		}

        System.out.println("Game saved succefully");
    }
}
