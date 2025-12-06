package de.o.le.termite.backend;

import de.o.le.termite.data.Room;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.6
 */
public class GameState {

    private Room currentRoom;

    public Room getCurrentRoom() { return currentRoom; }

    public void setCurrentRoom(Room room) { currentRoom = room; }
}
