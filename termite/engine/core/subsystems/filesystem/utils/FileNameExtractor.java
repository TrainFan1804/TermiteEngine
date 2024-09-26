package engine.core.subsystems.filesystem.utils;

import engine.core.ApplicationResourcesSingleton;
import engine.core.services.output.MessageType;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.3
 */
public final class FileNameExtractor {

	public String extractFileName(MessageType msgType) throws ExitFileMenuException {
		
		ApplicationResourcesSingleton.INSTANCE.OUT.printMessage(msgType);
		String fileName = ApplicationResourcesSingleton.INSTANCE.IN.read();

		if (fileName.toUpperCase().equals("EXIT")) throw new ExitFileMenuException();

		if (fileName.isEmpty()) return "default"; 

		return fileName;
	}
}
