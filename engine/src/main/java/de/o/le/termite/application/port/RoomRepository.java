package de.o.le.termite.application.port;

import de.o.le.termite.core.model.room.Room;

import java.util.Optional;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.02.14
 */
public interface RoomRepository {

    void save(Room room);

    Optional<Room> getRoom(String name);
}
