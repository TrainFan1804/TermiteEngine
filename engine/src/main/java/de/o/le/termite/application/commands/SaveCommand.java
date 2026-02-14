package de.o.le.termite.application.commands;

import de.o.le.termite.application.EngineContext;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.02.13
 */
public class SaveCommand implements ICommandHandler {

    @Override
    public CommandResult execute(EngineContext context) {

        context.gameObjectRepository().loadData(context.saveState());
        return CommandResult.success("Saved successfully");
    }
}
