package de.o.le.termite;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.o.le.termite.data.Room;

import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        test();
        Application.launch(Termite.class, args);
    }

    static void test() throws IOException {
        File f = new File(new File(System.getProperty("user.dir")).getParentFile(), "game/default/data/rooms/default.json");
        System.out.println(f.getAbsolutePath());
        if (!f.exists()) {
            System.out.println("Datei existiert nicht!");
            return;
        }

        String json = Files.readString(f.toPath());
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Room room = mapper.readValue(json, Room.class);

        System.out.println(room.getName());
    }


}
