package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.GameState;
import de.o.le.termite.dto.CommandContext;
import de.o.le.termite.dto.CommandResult;
import de.o.le.termite.dto.StringStringDescription;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.26
 */
public class InvCommand implements CommandHandler {

    @Override
    public CommandResult execute(List<String> args, EngineContext context, GameState state) {
        List<StringStringDescription> itemsAsDTO = GameState.getInstance().getAllItemsFromInventory();
        return CommandResult.success("Your inventory:",
                new CommandContext().addInventoryDesc(itemsAsDTO)
        );
    }
}
