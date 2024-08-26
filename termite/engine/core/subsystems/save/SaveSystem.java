package engine.core.subsystems.save;

import engine.core.ApplicationResources;
import engine.core.subsystems.EngineSubsystem;
import engine.instance.Instance;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class SaveSystem implements EngineSubsystem {

    @Override
    public void execute() {

		Instance i = ApplicationResources.GAME.getCurrentInstance();

		File file = new File("savefile.txt");
		FileWriter writer = null;
		try {

			writer = new FileWriter(file);
			writer.write("Test");
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException ex) {
			Logger.getLogger(SaveSystem.class.getName()).log(Level.SEVERE, null, ex);
		}

        System.out.println("Save game..");
    }
}
