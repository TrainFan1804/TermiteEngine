package de.o.le.termite.backend;

import de.o.le.termite.Main;
import de.o.le.termite.data.GameObject;
import de.o.le.termite.data.Room;
import de.o.le.termite.util.LogService;

import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.6
 */
public class Engine {

    private static final LogService LOG = new LogService(Main.class.getName());

    private GameObjectManager manager;
    private final GameState STATE;

    public Engine() throws IOException {
        this("game/default");
    }

    public Engine(String startPath) throws IOException {
        LOG.info("Start engine");

        this.manager = new GameObjectManager(startPath);
        this.STATE = new GameState();
        loadGame();

        LOG.info("Stop engine");
    }

    private void loadGame() {
        Room startRoom = manager.getData(GameObject.ROOM, "default");
        STATE.setCurrentRoom(startRoom);
    }
}
