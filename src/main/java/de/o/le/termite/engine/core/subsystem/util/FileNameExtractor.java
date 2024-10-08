package de.o.le.termite.engine.core.subsystem.util;

import de.o.le.termite.engine.core.EngineInputResource;
import de.o.le.termite.engine.core.EngineOutputResource;
import de.o.le.termite.engine.core.service.output.MessageType;

/**
 * This class will extract a file name that should be loaded / saved.
 * <p>
 * Is only used in {@link LSFacade} and {@link SSFacade}.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.2.3
 */
public final class FileNameExtractor {

	/**
	 * Extract a file name from the terminal.
	 * <p>
	 * TODO maybe this should return the file directly?
	 * 
	 * @param msgType The message type that will be printed when asking for 
	 * a file name.
	 * @return The entered string from the terminal.
	 * @throws ExitFileMenuException When the player enter 'exit' the subsystem
	 * will be closed.
	 */
	public String extractFileName(MessageType msgType) throws ExitFileMenuException {
		
		EngineOutputResource.getInstance().OUT.printMessage(msgType);
		String fileName = EngineInputResource.getInstance().IN.read();

		if (fileName.toUpperCase().equals("EXIT")) throw new ExitFileMenuException();

		if (fileName.isEmpty()) return "default"; 

		return fileName;
	}
}
