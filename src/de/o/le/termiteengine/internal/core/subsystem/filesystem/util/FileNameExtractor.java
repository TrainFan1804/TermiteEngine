package de.o.le.termiteengine.internal.core.subsystem.filesystem.util;

import de.o.le.termiteengine.internal.core.EngineResources;
import de.o.le.termiteengine.internal.core.service.output.MessageType;

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
