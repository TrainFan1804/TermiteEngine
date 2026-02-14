package de.o.le.termite.application.commands;

import de.o.le.termite.application.EngineContext;
import de.o.le.termite.application.state.GameState;
import de.o.le.termite.core.model.GameObject;
import de.o.le.termite.infrastructure.entity.room.RoomEntity;

import de.o.le.termite.application.dto.trans.TransContext;
import de.o.le.termite.application.dto.trans.TransRoomContext;
import de.o.le.termite.application.dto.types.mapper.RoomMapper;

import java.util.List;

/**
 * This command will execute a walking action. That means the new room data file
 * will be loaded into memory and the state that hold the information about the
 * current room will be updated.
 *
 * @author                              o.le
 * @version                             1.5
 * @since                               25.12.13
 */
public class WalkCommand implements ICommandHandler {

    private List<String> args;

    public WalkCommand(List<String> args) {
        this.args = args;
    }

    @Override
    public CommandResult execute(EngineContext context) {
        if (args.isEmpty()) {
            return CommandResult.failure("You didn't decided where to walk yet.");
        }

        GameState gs = context.gameState();

        String a = args.getFirst();
        RoomEntity currentRoom = gs.getCurrentRoom();

        String target = currentRoom.getExitTarget(a);
        if (target== null) {
            return CommandResult.failure("You can't go that way!");
        }
        RoomEntity nextRoom = context.gameObjectManager().getData(GameObject.ROOM, target);

        // TODO check here for requirement to enter next room

        gs.setCurrentRoom(nextRoom);

        // TODO save new room state permanently

        TransContext ctx = new TransRoomContext(RoomMapper.from(nextRoom));
        return CommandResult.success(nextRoom.getDescription(), ctx);
    }
}
