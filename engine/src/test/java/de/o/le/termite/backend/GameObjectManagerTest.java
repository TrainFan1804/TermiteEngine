package de.o.le.termite.backend;

import de.o.le.termite.backend.data.GameObject;
import de.o.le.termite.backend.data.Player;
import de.o.le.termite.backend.data.room.Room;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.6
 */
class GameObjectManagerTest {

    @Test
    public void testManageRoom() {
        try {
            GameObjectManager manager = new GameObjectManager("game/default");
            Object room = manager.getData(GameObject.ROOM, "default");
            assertInstanceOf(Room.class, room);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testManagePlayer() {
        try {
            GameObjectManager manager = new GameObjectManager("game/default");
            Object room = manager.getData(GameObject.PLAYER, "player");
            assertInstanceOf(Player.class, room);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}