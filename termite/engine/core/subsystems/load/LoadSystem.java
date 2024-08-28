package engine.core.subsystems.load;

import engine.core.ApplicationResources;
import engine.core.subsystems.EngineSubsystem;
import engine.core.subsystems.utils.FileConnection;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class LoadSystem implements EngineSubsystem {

	private FileConnection connection;

    @Override
    public void execute() {

		this.connection = this.createConnection();

		try (LoadReader reader = new LoadReader(this.connection)) {
			
			int id = reader.readFromFile();
			System.out.println(id);
			ApplicationResources.GAME.setCurrentInstance(id);
		} catch (FileNotFoundException ex) {

			System.out.println("File doesn't exist!");
		} catch (IOException ex) {

			System.out.println(ex.getLocalizedMessage());
		}

        System.out.println("Game load succefully"); // also print new current instance
		/*
			This is the f* reason why I don't like this static class..
		*/
		ApplicationResources.wasInstanceSwitch = false;
    }

	private FileConnection createConnection() { return new FileConnection("savefile.txt"); }
}
