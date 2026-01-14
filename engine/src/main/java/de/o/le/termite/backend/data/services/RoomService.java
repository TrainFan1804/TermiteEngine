package de.o.le.termite.backend.data.services;

import de.o.le.termite.backend.data.room.Room;
import de.o.le.termite.backend.data.room.RoomActions;
import de.o.le.termite.backend.data.room.RoomExitAction;
import de.o.le.termite.backend.data.room.RoomLookAction;
import de.o.le.termite.dto.RoomActionsDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public class RoomService {

    public static List<RoomActionsDTO> getRoomActionNames(Room room) {

        List<RoomActionsDTO> actions = new ArrayList<>();

        RoomActions a = room.getActions();

        Map<String, RoomExitAction> exit = a._exitMap();
        Map<String, RoomLookAction> look = a._lookMap();

        exit.keySet().forEach(key ->
                actions.add(new RoomActionsDTO("EXIT", key))
        );
        look.keySet().forEach(key ->
                actions.add(new RoomActionsDTO("LOOK", key))
        );
        return actions;
    }
}
