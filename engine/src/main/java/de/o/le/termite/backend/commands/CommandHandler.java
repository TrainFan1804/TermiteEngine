package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.GameState;
import de.o.le.termite.dto.CommandResult;

/**
 * @author                              o.le
 * @version                             2.0
 * @since                               25.12.26
 */
public interface CommandHandler {

    /**
     *
     * @param context
     * @param state
     * @return
     */
    CommandResult execute(EngineContext context, GameState state);
}
