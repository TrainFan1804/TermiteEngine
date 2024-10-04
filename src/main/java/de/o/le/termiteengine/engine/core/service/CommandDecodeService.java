package de.o.le.termiteengine.engine.core.service;

import de.o.le.termiteengine.engine.core.Command;
import de.o.le.termiteengine.engine.core.EngineOutputResource;
import de.o.le.termiteengine.engine.core.service.output.MessageType;

/**
 * This service will decode a String to a {@link Command}.
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.28
 */
public class CommandDecodeService {

	/**
	 * Decode the string and return the matching command.
	 * 
	 * @param commandInput The input from the user that should me mapped to a
	 * {@link Command}.
	 * @return The mapped command. Will return {@code null} if the given argument
	 * was invalid.
	 */
    	public Command commandDecode(String commandInput) {

        	try {

            		commandInput = commandInput.toUpperCase();
            		// decode input to commands
            		return Command.valueOf(commandInput);
        	} catch (IllegalArgumentException e) {
 
			EngineOutputResource.getInstance().OUT.printMessage(MessageType.MSG_UNKNOWN_COMMAND);
			return null; // bad, really bad...
        	}
    	}
}
