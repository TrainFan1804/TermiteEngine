package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.dto.CommandResult;

/**
 * @author                              o.le
 * @version                             2.1
 * @since                               25.12.26
 */
public interface CommandHandler {

    /**
     * @param context
     * @return
     */
    CommandResult execute(EngineContext context);
}
