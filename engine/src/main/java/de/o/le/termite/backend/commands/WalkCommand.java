package de.o.le.termite.backend.commands;

import de.o.le.termite.backend.GameState;
import de.o.le.termite.data.room.Room;

import java.util.List;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.13
 */
public class WalkCommand {

    public String walk(List<String> args) {

        if (args.isEmpty()) {
            return "You didn't decided where to walk yet.";
        }

        String a = args.getFirst();
        Room currentRoom = GameState.getInstance().getCurrentRoom();
        // TODO implement walking logic and check for when direction is unknown
        return currentRoom.getExit(a).getTarget();
    }
}
