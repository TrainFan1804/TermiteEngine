package engine.core.services;

import engine.core.ApplicationResourcesSingleton;
import engine.core.Command;
import engine.core.services.output.MessageType;

/**
 * This service will decode a String to a {@link Command}.
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.28
 */
public class CommandDecodeService {

	/**
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
 
			ApplicationResourcesSingleton.INSTANCE.OUT.printMessage(MessageType.MSG_UNKNOWN_COMMAND);
			return null; // bad, really bad...
        }
    }
}
