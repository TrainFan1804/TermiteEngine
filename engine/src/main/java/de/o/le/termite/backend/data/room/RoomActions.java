package de.o.le.termite.backend.data.room;

import java.util.HashMap;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.3
 * @since                               25.12.20
 */
public class RoomActions {

    private Map<String, RoomExitAction> exit = new HashMap<>();
    private Map<String, RoomLookAction> look = new HashMap<>();

    public RoomActions() { }

    /**
     *
     * @param exit
     * @return {@code null} if <b>exit</b> is an unknown key. (Unknown exit)
     */
    public RoomExitAction getExit(String exit) { return this.exit.get(exit); }

    /**
     *
     * @param look
     * @return {@code null} if <b>look</b> is an unknown key (No item is at the
     * given location)
     */
    public RoomLookAction getLook(String look) { return this.look.get(look); }

    /**
     * This is used in {@link de.o.le.termite.backend.data.services.RoomService}
     * and <b>shouldn't be used anywhere else!</b>
     *
     * @return
     */
    public Map<String, RoomExitAction> _exitMap() { return exit; }

    /**
     * This is used in {@link de.o.le.termite.backend.data.services.RoomService}
     * and <b>shouldn't be used anywhere else!</b>
     *
     * @return
     */
    public Map<String, RoomLookAction> _lookMap() { return look; }
}
