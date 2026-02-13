package de.o.le.termite.application.commands;

import de.o.le.termite.application.EngineContext;
import de.o.le.termite.core.commands.ICommandHandler;
import de.o.le.termite.core.model.Inventory;
import de.o.le.termite.core.commands.CommandResult;

import de.o.le.termite.application.dto.trans.TransContext;
import de.o.le.termite.application.dto.trans.TransInventoryContext;
import de.o.le.termite.application.dto.types.ItemDTO;
import de.o.le.termite.application.dto.types.mapper.InventoryMapper;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.26
 */
public class InvCommand implements ICommandHandler {

    @Override
    public CommandResult execute(EngineContext context) {
        Inventory inv = context.gameState().getInventory();
        List<ItemDTO> itemsAsDTO = InventoryMapper.asDisplayList(inv);

        TransContext ctx = new TransInventoryContext(itemsAsDTO);
        return CommandResult.success("Your inventory:", ctx);
    }
}
