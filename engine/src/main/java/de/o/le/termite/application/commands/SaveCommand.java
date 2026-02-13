package de.o.le.termite.application.commands;

import de.o.le.termite.application.EngineContext;
import de.o.le.termite.core.commands.ICommandHandler;
import de.o.le.termite.core.commands.CommandResult;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.02.13
 */
public class SaveCommand implements ICommandHandler {

    @Override
    public CommandResult execute(EngineContext context) {

        context.gameObjectManager().loadData(context.saveState());
        return CommandResult.success("Saved successfully");
    }
}
