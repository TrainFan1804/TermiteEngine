package de.o.le.termite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        File f = new File("game/default/player/base.json");
        if (!f.exists()) {
            System.out.println("Datei existiert nicht!");
        }

        String json = Files.readString(f.toPath());
        System.out.println(json);
    }
}
