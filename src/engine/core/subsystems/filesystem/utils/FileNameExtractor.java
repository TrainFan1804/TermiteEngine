package engine.core.subsystems.filesystem.utils;

import engine.core.EngineResources;
import engine.core.services.output.MessageType;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.3
 */
public final class FileNameExtractor {

	public String extractFileName(MessageType msgType) throws ExitFileMenuException {
		
		EngineResources.INSTANCE.OUT.printMessage(msgType);
		String fileName = EngineResources.INSTANCE.IN.read();

		if (fileName.toUpperCase().equals("EXIT")) throw new ExitFileMenuException();

		if (fileName.isEmpty()) return "default"; 

		return fileName;
	}
}
