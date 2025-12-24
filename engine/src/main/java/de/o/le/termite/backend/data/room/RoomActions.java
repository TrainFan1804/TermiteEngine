package de.o.le.termite.backend.data.room;

import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.20
 */
class RoomActions {

    private Map<String, RoomExitAction> exit;
    private Map<String, RoomLookAction> look;

    public RoomActions() {}

    Map<String, RoomExitAction> getExit() { return this.exit; }

    Map<String, RoomLookAction> getLook() { return this.look; }
}
