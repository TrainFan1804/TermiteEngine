package de.o.le.termite.dto.types.mapper;

import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.dto.types.RoomDTO;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class RoomMapper {

    public static RoomDTO from(Room room) {
        return new RoomDTO(room.getName());
    }
}
