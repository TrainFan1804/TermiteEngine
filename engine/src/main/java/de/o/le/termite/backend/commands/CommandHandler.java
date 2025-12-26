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
public interface CommandHandler {

    /**
     *
     * @param args
     * @param context
     * @param state
     * @return
     *
     * @implNote Because param {@code context} give access to {@link de.o.le.termite.backend.CommandRegistry}
     *  it is theoretically possible to access the registry inside a command handler. <b>Don't do that!</b>
     */
    CommandResult execute(List<String> args, EngineContext context, GameState state);
}
