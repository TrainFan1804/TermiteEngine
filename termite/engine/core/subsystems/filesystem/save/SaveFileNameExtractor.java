package engine.core.subsystems.filesystem.save;

import engine.core.ApplicationResourcesSingleton;
import engine.core.services.output.MessageType;

/**
 * @author o.le
 * @version 1.1
 * @since 1.1.1
 */
@Deprecated
class SaveFileNameExtractor {

	String extractFileName() throws ExitSaveMenuException {

		ApplicationResourcesSingleton.INSTANCE.OUT.printMessage(MessageType.MSG_SAVE_ASK_FILE);
		String fileName = ApplicationResourcesSingleton.INSTANCE.IN.read();

		if (fileName.toUpperCase().equals("EXIT")) throw new ExitSaveMenuException();

		if (fileName.isEmpty()) fileName = "default";

		return fileName;
	}
}
