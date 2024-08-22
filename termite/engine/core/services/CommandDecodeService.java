package engine.core.services;

import engine.core.Command;
import engine.core.exceptions.UnknownCommandException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.28
 */
public class CommandDecodeService {

    public Command commandDecode(String commandInput) throws UnknownCommandException {

        try {

            commandInput = commandInput.toUpperCase();
            // decode input to commands
            return Command.valueOf(commandInput);
        } catch (IllegalArgumentException e) {
 
            throw new UnknownCommandException(commandInput);
        }
    }
}
