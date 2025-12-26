package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.GameState;
import de.o.le.termite.dto.CommandContext;
import de.o.le.termite.dto.CommandResult;
import de.o.le.termite.dto.StringStringDescription;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.26
 */
public class InvCommand {

    public CommandResult inv() {

        List<StringStringDescription> itemsAsDTO = GameState.getInstance().getAllItemsFromInventory();
        return CommandResult.success("Your inventory:",
                new CommandContext().addInventoryDesc(itemsAsDTO)
        );
    }
}
