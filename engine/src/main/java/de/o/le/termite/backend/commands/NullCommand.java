package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.GameState;
import de.o.le.termite.dto.CommandResult;

/**
 * This command represent the command that is executed when an invalid command
 * is entered by the user.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.26
 */
public class NullCommand implements CommandHandler {

    @Override
    public CommandResult execute(EngineContext context, GameState state) {
        return CommandResult.failure("Unknown command");
    }
}
