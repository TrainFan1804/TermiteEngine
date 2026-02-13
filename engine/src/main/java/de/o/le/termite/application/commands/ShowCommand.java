package de.o.le.termite.application.commands;

import de.o.le.termite.application.EngineContext;
import de.o.le.termite.core.commands.ICommandHandler;
import de.o.le.termite.core.model.room.Room;
import de.o.le.termite.application.services.RoomService;
import de.o.le.termite.core.commands.CommandResult;

import de.o.le.termite.application.dto.trans.TransContext;
import de.o.le.termite.application.dto.trans.TransRoomActionsContext;
import de.o.le.termite.application.dto.types.RoomActionsDTO;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.4
 * @since                               25.12.25
 */
public class ShowCommand implements ICommandHandler {

    @Override
    public CommandResult execute(EngineContext context) {
        Room currentRoom = context.gameState().getCurrentRoom();

        List<RoomActionsDTO> desc = RoomService.getRoomActionNames(currentRoom);

        TransContext ctx = new TransRoomActionsContext(desc);
        return CommandResult.success("You search the room and found following things:", ctx);
    }
}
