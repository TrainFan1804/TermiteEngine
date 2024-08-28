package engine.core.subsystems.save;

import engine.core.ApplicationResources;
import engine.core.subsystems.EngineSubsystem;
import java.io.IOException;

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

			int id = ApplicationResources.GAME.getCurrentInstanceId();
			writer.writeIdToFile(id);
		} catch (IOException e) {

			System.out.println(e.getLocalizedMessage());
		}

        System.out.println("Game saved succefully");
    }

	private FileConnection createConnection() { return  new FileConnection("savefile.txt"); }

	private SaveWriter createWriter() throws IOException { return new SaveWriter(this.connection); }
}
