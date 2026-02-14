package de.o.le.termite.core;

import de.o.le.termite.core.model.GameObject;
import de.o.le.termite.core.model.Player;
import de.o.le.termite.core.model.Item;
import de.o.le.termite.infrastructure.entity.room.RoomEntity;

import de.o.le.termite.infrastructure.persistance.GameObjectManager;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.6
 */
class GameObjectRepositoryTest {

    @Test
    public void testManageRoom() {
        try {
            GameObjectManager manager = new GameObjectManager("game/default");
            Object room = manager.getData(GameObject.ROOM, "default");
            assertInstanceOf(RoomEntity.class, room);
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

    @Test
    public void testManageItem() {
        try {
            GameObjectManager manager = new GameObjectManager("game/default");
            Object room = manager.getData(GameObject.ITEM, "default");
            assertInstanceOf(Item.class, room);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}