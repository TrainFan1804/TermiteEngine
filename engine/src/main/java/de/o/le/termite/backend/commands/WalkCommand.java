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
 * @version                             1.4
 * @since                               25.12.13
 */
public class WalkCommand implements CommandHandler {

    private List<String> args;

    public WalkCommand(List<String> args) {
        this.args = args;
    }

    @Override
    public CommandResult execute(EngineContext context, GameState state) {
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
        Room nextRoom = context.gameObjectManager().getData(GameObject.ROOM, target);

        // TODO check here for requirement to enter next room

        GameState.getInstance().setCurrentRoom(nextRoom);

        // TODO save new room state permanently

        return CommandResult.success(nextRoom.getInfo().getDescription(), new CommandContext().addRoom(nextRoom));
    }
}
