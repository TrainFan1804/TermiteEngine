package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.backend.data.services.RoomService;
import de.o.le.termite.dto.CommandContext;
import de.o.le.termite.dto.CommandResult;
import de.o.le.termite.dto.RoomActionsDTO;

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
        return CommandResult.success("You search the room and found following things:",
                new CommandContext().addActionDescription(desc)
        );
    }
}
