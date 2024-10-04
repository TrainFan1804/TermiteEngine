package de.o.le.termiteengine.engine.core.subsystem.util;

import de.o.le.termiteengine.engine.core.EngineInputResource;
import de.o.le.termiteengine.engine.core.EngineOutputResource;
import de.o.le.termiteengine.engine.core.service.output.MessageType;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.3
 */
public final class FileNameExtractor {

	public String extractFileName(MessageType msgType) throws ExitFileMenuException {
		
		EngineOutputResource.getInstance().OUT.printMessage(msgType);
		String fileName = EngineInputResource.getInstance().IN.read();

		if (fileName.toUpperCase().equals("EXIT")) throw new ExitFileMenuException();

		if (fileName.isEmpty()) return "default"; 

		return fileName;
	}
}
