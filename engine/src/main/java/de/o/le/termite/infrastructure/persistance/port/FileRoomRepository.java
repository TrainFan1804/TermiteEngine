package de.o.le.termite.infrastructure.persistance.port;

import de.o.le.termite.application.port.RoomRepository;
import de.o.le.termite.core.model.room.Room;
import de.o.le.termite.infrastructure.persistance.GameFileHandler;
import de.o.le.termite.infrastructure.persistance.JsonLoadHandler;
import de.o.le.termite.infrastructure.persistance.utils.IdInjector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.02.14
 */
public class FileRoomRepository implements RoomRepository {

    private static final Path BASE_PATH = Paths.get("data/rooms");

    private GameFileHandler loader;
    private JsonLoadHandler jsonHandler;

    public FileRoomRepository(GameFileHandler loader, JsonLoadHandler jsonHandler) {
        this.loader = loader;
        this.jsonHandler = jsonHandler;
    }

    @Override
    public void save(Room room) {
        throw new RuntimeException();
    }

    @Override
    public Optional<Room> getRoom(String name) {

        Path path = BASE_PATH.resolve(name);
        try {
            File dataFile = loader.createFileHander(path);
            Room room = jsonHandler.loadFileValue(dataFile, Room.class);
            IdInjector.inject(room, path);
            return Optional.of(room);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
