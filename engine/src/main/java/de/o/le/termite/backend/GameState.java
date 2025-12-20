package de.o.le.termite.backend;

import de.o.le.termite.data.room.Room;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.6
 *
 * @apiNote See {@link Engine} for global access!
 */
public class GameState {

    private static final GameState INSTANCE = new GameState();

    private Room currentRoom;

    public static GameState getInstance() {

        return INSTANCE;
    }

    private GameState() { }

    public Room getCurrentRoom() { return currentRoom; }

    public void setCurrentRoom(Room room) { currentRoom = room; }
}
