package de.o.le.termite.backend.data.room;

import de.o.le.termite.dto.ActionDescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               25.12.20
 */
public class RoomActions {

    private Map<String, RoomExitAction> exit = new HashMap<>();
    private Map<String, RoomLookAction> look = new HashMap<>();

    public RoomActions() {}

    public Map<String, RoomExitAction> getExit() { return this.exit; }

    public Map<String, RoomLookAction> getLook() { return this.look; }

    public List<ActionDescription> getActionNames() {

        List<ActionDescription> actions = new ArrayList<>();
        exit.keySet().forEach(key ->
                actions.add(new ActionDescription(RoomActionType.EXIT, key))
        );
        look.keySet().forEach(key ->
                actions.add(new ActionDescription(RoomActionType.LOOK, key))
        );
        return actions;
    }
}
