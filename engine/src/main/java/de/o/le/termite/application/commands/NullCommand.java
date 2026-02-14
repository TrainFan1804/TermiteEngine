package de.o.le.termite.application.commands;

import de.o.le.termite.application.EngineContext;

/**
 * This command represent the command that is executed when an invalid command
 * is entered by the user.
 *
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.26
 */
public class NullCommand implements ICommandHandler {

    @Override
    public CommandResult execute(EngineContext context) {
        return CommandResult.failure("Unknown command");
    }
}
