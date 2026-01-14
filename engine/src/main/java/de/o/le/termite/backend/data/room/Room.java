package de.o.le.termite.backend.data.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.o.le.termite.backend.utils.annotations.InjectId;

/**
 * @author                              o.le
 * @version                             1.5
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

    public String getName() { return this.info.getName(); }

    public String getDescription() { return this.info.getDescription(); }

    public String getImage() { return this.info.getImage(); }

    public String getExitTarget(String exit) {
        RoomExitAction action = this.actions.getExit(exit);
        if (action == null) {
            return null;
        }
        return action.getTargetRoomId();
    }

    public String getLookAltMessage(String look) {
        RoomLookAction action = this.actions.getLook(look);
        if (action == null) {
            return null;
        }
        return action.getAltMessage();
    }

    public String getLookMessage(String look) {
        RoomLookAction action = this.actions.getLook(look);
        if (action == null) {
            return null;
        }
        return action.getMessage();
    }

    public String getLookItemId(String look) {
        RoomLookAction action = this.actions.getLook(look);
        if (action == null) {
            return null;
        }
        return action.getItemId();
    }

    public RoomActions getActions() { return this.actions; }
}
