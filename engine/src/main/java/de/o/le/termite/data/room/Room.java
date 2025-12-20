package de.o.le.termite.data.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.3
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    private RoomInfo info;
    private RoomActions actions;

    public RoomInfo getInfo() { return this.info; }

    public RoomLookAction getLook(String look) {

        return actions.getLook().get(look);
    }

    public RoomExitAction getExit(String exit) {

        return actions.getExit().get(exit);
    }
}
