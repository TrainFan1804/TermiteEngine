package de.o.le.termite.backend;

import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.util.LogService;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.6
 */
public class GameState {

    private static final LogService LOG = new LogService(GameState.class.getName());
    private static final GameState INSTANCE = new GameState();

    private Room currentRoom;

    public static GameState getInstance() {

        return INSTANCE;
    }

    private GameState() { }

    public Room getCurrentRoom() { return currentRoom; }

    public void setCurrentRoom(Room room) {

        if (currentRoom != null) {
            LOG.info("Old room: '" + currentRoom.getInfo().getName()
                    + "', New room: '" + room.getInfo().getName() + "'"
            );
        }
        currentRoom = room;
    }
}
