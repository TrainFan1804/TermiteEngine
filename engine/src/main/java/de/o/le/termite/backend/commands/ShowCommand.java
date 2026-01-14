package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.backend.data.services.RoomService;
import de.o.le.termite.dto.CommandResult;
import de.o.le.termite.dto.trans.TransContext;
import de.o.le.termite.dto.trans.TransRoomActionsContext;
import de.o.le.termite.dto.types.RoomActionsDTO;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.4
 * @since                               25.12.25
 */
public class ShowCommand implements CommandHandler {

    @Override
    public CommandResult execute(EngineContext context) {
        Room currentRoom = context.gameState().getCurrentRoom();

        List<RoomActionsDTO> desc = RoomService.getRoomActionNames(currentRoom);

        TransContext ctx = new TransRoomActionsContext(desc);
        return CommandResult.success("You search the room and found following things:", ctx);
    }
}
