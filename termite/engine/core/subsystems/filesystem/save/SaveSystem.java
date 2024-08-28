package engine.core.subsystems.filesystem.save;

import engine.core.subsystems.filesystem.utils.FileConnection;
import engine.core.ApplicationResources;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.filesystem.utils.SaveGame;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class SaveSystem implements EngineSubsystem {

	private FileConnection connection;

    @Override
    public void execute() {

		this.connection = this.createConnection();

		try (SaveWriter writer = this.createWriter()) {

			SaveGame save = SaveGame.generateSaveGame();
			writer.writeIdToFile(save);
		} catch (IOException e) {

			System.out.println(e.getLocalizedMessage());
		}

        System.out.println("Game saved succefully");
    }

	private FileConnection createConnection() { return  new FileConnection("custom string"); }
	
	private SaveWriter createWriter() throws IOException { return new SaveWriter(this.connection); }
}
