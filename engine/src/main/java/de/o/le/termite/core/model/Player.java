package de.o.le.termite.core.model;

import de.o.le.termite.core.model.room.Room;
import de.o.le.termite.core.rules.IllegalMoveException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
public class Player {

    private String name;

    private Room currentRoom;

    private Inventory inventory;

    public Player(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
    }

    public String getName() { return this.name; }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void moveTo(Room targetRoom) {
        if (!currentRoom.findExit(targetRoom.getRoomId()).isPresent()) {
            throw new IllegalMoveException(currentRoom, targetRoom);
        }
        this.currentRoom = targetRoom;
    }
}
