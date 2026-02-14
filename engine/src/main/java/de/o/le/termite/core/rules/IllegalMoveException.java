package de.o.le.termite.core.rules;

import de.o.le.termite.core.model.room.Room;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.02.14
 */
public class IllegalMoveException extends RuntimeException {

    public IllegalMoveException(Room currentRoom, Room targetRoom) {

        super("Room " + currentRoom + " has no exit towards room " + targetRoom);
    }
}
