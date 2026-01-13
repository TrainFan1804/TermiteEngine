package de.o.le.termite.backend.manager;

import de.o.le.termite.backend.data.Inventory;
import de.o.le.termite.backend.data.Player;
import de.o.le.termite.backend.data.item.Item;
import de.o.le.termite.backend.data.item.ItemInfo;
import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.dto.StringStringDescription;
import de.o.le.termite.util.LogService;

import java.util.ArrayList;
import java.util.List;

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
        if (this.player == null) {
            this.player = player;
            LOG.config("Player set: '" + player.getName() + "'");
        }
    }

    public void setInventory(Inventory inventory) {
        if (this.inventory == null) { this.inventory = inventory; }
    }

    public void setCurrentRoom(Room room) {

        if (currentRoom != null) {
            LOG.gameEvents("Old room: '" + currentRoom.getInfo().getName()
                    + "', New room: '" + room.getInfo().getName() + "'"
            );
        } else {
            LOG.info("Load room '" + room.getInfo().getName() + "'");
        }
        currentRoom = room;
    }

    public List<StringStringDescription> getAllItemsFromInventory() {

        List<StringStringDescription> itemsAsDTO = new ArrayList<>();
        for (Item item : this.inventory.getInventory()) {
            itemsAsDTO.add(new StringStringDescription(item.getName(), item.getDescription()));
        }
        return itemsAsDTO;
    }

    public void addItemToInventory(Item item) {
        this.inventory.addItem(item);
        LOG.gameEvents("Item added to inventory: '" + item.getName() + "'");
    }
}
