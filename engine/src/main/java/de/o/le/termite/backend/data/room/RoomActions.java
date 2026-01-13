package de.o.le.termite.backend.data.room;

import de.o.le.termite.dto.StringStringDescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.20
 */
public class RoomActions {

    private Map<String, RoomExitAction> exit = new HashMap<>();
    private Map<String, RoomLookAction> look = new HashMap<>();

    public RoomActions() {}

    public RoomExitAction getExit(String exit) { return this.exit.get(exit); }

    public RoomLookAction getLook(String look) { return this.look.get(look); }

    public List<StringStringDescription> getActionNames() {

        List<StringStringDescription> actions = new ArrayList<>();
        exit.keySet().forEach(key ->
                actions.add(new StringStringDescription("EXIT", key))
        );
        look.keySet().forEach(key ->
                actions.add(new StringStringDescription("LOOK", key))
        );
        return actions;
    }
}
