package de.o.le.termite.application.services;

import de.o.le.termite.infrastructure.entity.room.RoomEntity;
import de.o.le.termite.infrastructure.entity.room.RoomActionsEntity;
import de.o.le.termite.infrastructure.entity.room.RoomExitActionEntity;
import de.o.le.termite.infrastructure.entity.room.RoomLookActionEntity;

import de.o.le.termite.application.dto.types.RoomActionsDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class RoomService {

    public static List<RoomActionsDTO> getRoomActionNames(RoomEntity room) {

        List<RoomActionsDTO> actions = new ArrayList<>();

        RoomActionsEntity a = room.getActions();

        Map<String, RoomExitActionEntity> exit = a._exitMap();
        Map<String, RoomLookActionEntity> look = a._lookMap();

        exit.keySet().forEach(key ->
                actions.add(new RoomActionsDTO("EXIT", key))
        );
        look.keySet().forEach(key ->
                actions.add(new RoomActionsDTO("LOOK", key))
        );
        return actions;
    }
}
