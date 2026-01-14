package de.o.le.termite.backend.manager.state;

import de.o.le.termite.backend.data.Inventory;
import de.o.le.termite.backend.data.Player;
import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.util.LogService;

/**
 * This class is containing and managing the state of the game. For example saving
 * the current room or providing simple access to the player's inventory.
 *
 * @author                              o.le
 * @version                             1.3
 * @since                               25.12.6
 */
public class GameState {

    private static final LogService LOG = new LogService(GameState.class.getName());

    private Player player;
    private Inventory inventory;
    private Room currentRoom;

    public Room getCurrentRoom() { return currentRoom; }

    public void setPlayer(Player player) {
        if (this.player != null) {
            throw new IllegalStateException("Player already set!");
        }
        this.player = player;
        LOG.config("Player set: '" + player.getName() + "'");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        if (this.inventory != null) {
            throw new IllegalStateException("Inventory already set!");
        }
        this.inventory = inventory;
        LOG.config("Inventory set");
    }

    public void setCurrentRoom(Room room) {

        if (currentRoom != null) {
            LOG.gameEvents("Old room: '" + currentRoom.getName()
                    + "', New room: '" + room.getName() + "'"
            );
        } else {
            LOG.info("Load room '" + room.getName() + "'");
        }
        currentRoom = room;
    }

    public void addItemToInventory(Item item) {
        this.inventory.addItem(item);
        LOG.gameEvents("Item added to inventory: '" + item.getName() + "'");
    }
}
