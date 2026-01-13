package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.dto.CommandContext;
import de.o.le.termite.dto.CommandResult;
import de.o.le.termite.dto.StringStringDescription;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.26
 */
public class InvCommand implements CommandHandler {

    @Override
    public CommandResult execute(EngineContext context) {
        List<StringStringDescription> itemsAsDTO = context.gameState().getAllItemsFromInventory();
        return CommandResult.success("Your inventory:",
                new CommandContext().addInventoryDesc(itemsAsDTO)
        );
    }
}
