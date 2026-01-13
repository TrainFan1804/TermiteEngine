package de.o.le.termite.backend.data.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.o.le.termite.backend.utils.annotations.InjectId;

/**
 * @author                              o.le
 * @version                             1.3
 * @since                               25.12.3
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    @InjectId
    @JsonIgnore
    private String roomId;

    private RoomInfo info;
    private RoomActions actions;

    public String getRoomId() { return this.roomId; }

    public void setRoomId(String roomId) { this.roomId = roomId; }

    public RoomInfo getInfo() { return this.info; }

    public RoomLookAction getLook(String look) { return actions.getLook(look); }

    public RoomExitAction getExit(String exit) { return actions.getExit(exit); }

    public RoomActions getActions() { return this.actions; }
}
