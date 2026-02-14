package de.o.le.termite.infrastructure.entity.room;

import de.o.le.termite.application.services.RoomService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.3
 * @since                               25.12.20
 */
public class RoomActionsEntity {

    private Map<String, RoomExitActionEntity> exit = new HashMap<>();
    private Map<String, RoomLookActionEntity> look = new HashMap<>();

    public RoomActionsEntity() { }

    /**
     *
     * @param exit
     * @return {@code null} if <b>exit</b> is an unknown key. (Unknown exit)
     */
    public RoomExitActionEntity getExit(String exit) { return this.exit.get(exit); }

    /**
     *
     * @param look
     * @return {@code null} if <b>look</b> is an unknown key (No item is at the
     * given location)
     */
    public RoomLookActionEntity getLook(String look) { return this.look.get(look); }

    /**
     * This is used in {@link RoomService}
     * and <b>shouldn't be used anywhere else!</b>
     *
     * @return
     */
    public Map<String, RoomExitActionEntity> _exitMap() { return exit; }

    /**
     * This is used in {@link RoomService}
     * and <b>shouldn't be used anywhere else!</b>
     *
     * @return
     */
    public Map<String, RoomLookActionEntity> _lookMap() { return look; }
}
