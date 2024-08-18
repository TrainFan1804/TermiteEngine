package termite.core.services;

import termite.core.Command;
import termite.core.exceptions.UnknownCommandException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.28
 */
public class CommandDecodeService {

    public Command commandDecode(String commandInput) throws UnknownCommandException {

        try {

            // decode input to commands
            return Command.valueOf(commandInput);
        } catch (IllegalArgumentException e) {
 
            throw new UnknownCommandException(commandInput);
        }
    }
}
