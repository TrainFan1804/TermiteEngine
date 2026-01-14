package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.EngineContext;
import de.o.le.termite.backend.manager.state.GameState;
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
 * @version                             1.5
 * @since                               25.12.13
 */
public class WalkCommand implements CommandHandler {

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
        Room currentRoom = gs.getCurrentRoom();

        String target = currentRoom.getExitTarget(a);
        if (target== null) {
            return CommandResult.failure("You can't go that way!");
        }
        Room nextRoom = context.gameObjectManager().getData(GameObject.ROOM, target);

        // TODO check here for requirement to enter next room

        gs.setCurrentRoom(nextRoom);

        // TODO save new room state permanently

        return CommandResult.success(nextRoom.getDescription(), new CommandContext().addRoom(nextRoom));
    }
}
