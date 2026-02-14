package de.o.le.termite.application.commands;

import de.o.le.termite.application.EngineContext;

/**
 * @author                              o.le
 * @version                             2.1
 * @since                               25.12.26
 */
public interface ICommandHandler {

    CommandResult execute(EngineContext context);
}
