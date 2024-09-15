package engine.core.subsystems.filesystem.utils;

import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.3
 */
public class FileNameExtractor {

	public String extractFileName(MessageType msgType) throws ExitFileMenuException {
		
		ApplicationResources.OUT.printMessage(msgType);
		String fileName = ApplicationResources.IN.read();

		if (fileName.toUpperCase().equals("EXIT")) throw new ExitFileMenuException();

		if (fileName.isEmpty()) return "default"; 

		return fileName;
	}
}
