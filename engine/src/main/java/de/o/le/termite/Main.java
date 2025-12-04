package de.o.le.termite;

import de.o.le.termite.data.GameObject;
import de.o.le.termite.data.Room;
import de.o.le.termite.engine.filesystem.JsonLoadHandler;

import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.3
 */
public class Main {

    public static void main(String[] args) throws IOException {
        test();
        Application.launch(Termite.class, args);
    }

    static void test() throws IOException {
//        var d = new GameObjectLoader("game/default");
//        File f = d.loadFile(Path.of("data/rooms/default.json"));
//        System.out.println(f.getAbsolutePath());
//
//        JsonLoadHandler handler = new JsonLoadHandler();
//        Room room = handler.loadFileValue(f, Room.class);
        GameObjectManager manager = new GameObjectManager();
        Room room = manager.getData("room", "default");

        System.out.println(room.getName());

//        f = DataLoader.loadFile("game/default/player.json");
//        System.out.println(f.getAbsolutePath());
//
//        handler = new JsonLoadHandler();
//        Player p = handler.loadFileValue(f, Player.class);
//        System.out.println(p.name);
    }
}
