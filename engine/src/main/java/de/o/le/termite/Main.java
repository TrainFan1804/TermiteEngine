package de.o.le.termite;

import de.o.le.termite.data.GameObject;
import de.o.le.termite.data.Player;
import de.o.le.termite.data.Room;

import de.o.le.termite.engine.util.LogService;
import javafx.application.Application;

import java.io.IOException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
public class Main {

    private static final LogService LOG = new LogService(Main.class.getName());

    public static void main(String[] args) throws IOException {
        LOG.info("Start engine");
        test();
        Application.launch(Termite.class, args);
        LOG.info("Stop engine");
    }

    private static void test() throws IOException {
        GameObjectManager manager = new GameObjectManager();
        Room room = manager.getData(GameObject.ROOM, "default");
        System.out.println(room.getName());

        Player p = manager.getData(GameObject.PLAYER, "player");
        System.out.println(p.name);
    }
}
