package de.o.le.termite.application.dto.types.mapper;

import de.o.le.termite.infrastructure.entity.room.RoomEntity;
import de.o.le.termite.application.dto.types.RoomDTO;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class RoomMapper {

    public static RoomDTO from(RoomEntity room) {
        return new RoomDTO(room.getName());
    }
}
