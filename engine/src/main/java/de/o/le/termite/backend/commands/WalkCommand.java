package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.GameState;
import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.backend.data.room.RoomExitAction;
import de.o.le.termite.dto.CommandContext;
import de.o.le.termite.dto.CommandResult;

import java.util.List;

/**
 * This command will execute a walking action. That means the new room data file
 * will be loaded into memory and the state that hold the information about the
 * current room will be updated.
 *
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.13
 */
public class WalkCommand {

    public CommandResult walk(List<String> args) {

        if (args.isEmpty()) {
            return CommandResult.failure("You didn't decided where to walk yet.");
        }

        String a = args.getFirst();
        Room currentRoom = GameState.getInstance().getCurrentRoom();

        RoomExitAction action = currentRoom.getExit(a);
        if (action == null) {
            return CommandResult.failure("You can't go that way!");
        }

        String target = action.getTarget();
        Room nextRoom = EngineContext.getInstance().gameObjectManager().getData(GameObject.ROOM, target);
        GameState.getInstance().setCurrentRoom(nextRoom);
        return CommandResult.success(nextRoom.getInfo().getDescription(), new CommandContext().addRoom(nextRoom));
    }
}
