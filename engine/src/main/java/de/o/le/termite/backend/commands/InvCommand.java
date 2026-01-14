package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.data.Inventory;
import de.o.le.termite.backend.manager.state.SaveState;
import de.o.le.termite.dto.CommandContext;
import de.o.le.termite.dto.CommandResult;
import de.o.le.termite.dto.StringStringDescription;
import de.o.le.termite.dto.datamapper.InventoryMapper;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.26
 */
public class InvCommand implements CommandHandler {

    @Override
    public CommandResult execute(EngineContext context) {
        Inventory inv = context.gameState().getInventory();
        List<StringStringDescription> itemsAsDTO = InventoryMapper.asDisplayList(inv);
        return CommandResult.success("Your inventory:",
                new CommandContext().addInventoryDesc(itemsAsDTO)
        );
    }
}
