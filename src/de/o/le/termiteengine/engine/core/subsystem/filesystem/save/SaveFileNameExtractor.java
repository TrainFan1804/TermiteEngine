package de.o.le.termiteengine.engine.core.subsystem.filesystem.save;

import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.engine.core.service.output.MessageType;

/**
 * @author o.le
 * @version 1.1
 * @since 1.1.1
 */
@Deprecated
class SaveFileNameExtractor {

	String extractFileName() throws ExitSaveMenuException {

		EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_SAVE_ASK_FILE);
		String fileName = EngineResources.INSTANCE.IN.read();

		if (fileName.toUpperCase().equals("EXIT")) throw new ExitSaveMenuException();

		if (fileName.isEmpty()) fileName = "default";

		return fileName;
	}
}
