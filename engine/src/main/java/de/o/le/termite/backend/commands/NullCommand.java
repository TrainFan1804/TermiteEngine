package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.GameState;
import de.o.le.termite.dto.CommandResult;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 */
public class NullCommand implements CommandHandler {

    @Override
    public CommandResult execute(List<String> args, EngineContext context, GameState state) {
        return CommandResult.failure("If you can read this message, the engine developer did something wrong!");
    }
}
