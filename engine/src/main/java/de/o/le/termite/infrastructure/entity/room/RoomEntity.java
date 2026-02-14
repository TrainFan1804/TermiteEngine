package de.o.le.termite.infrastructure.entity.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.o.le.termite.infrastructure.persistance.utils.annotations.InjectId;

/**
 * @author                              o.le
 * @version                             1.5
 * @since                               25.12.3
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomEntity {

    @InjectId
    @JsonIgnore
    private String roomId;

    private RoomInfoEntity info;
    private RoomActionsEntity actions;

    public String getRoomId() { return this.roomId; }

    public String getName() { return this.info.getName(); }

    public String getDescription() { return this.info.getDescription(); }

    public String getImage() { return this.info.getImage(); }

    public String getExitTarget(String exit) {
        RoomExitActionEntity action = this.actions.getExit(exit);
        if (action == null) {
            return null;
        }
        return action.getTargetRoomId();
    }

    public String getLookAltMessage(String look) {
        RoomLookActionEntity action = this.actions.getLook(look);
        if (action == null) {
            return null;
        }
        return action.getAltMessage();
    }

    public String getLookMessage(String look) {
        RoomLookActionEntity action = this.actions.getLook(look);
        if (action == null) {
            return null;
        }
        return action.getMessage();
    }

    public String getLookItemId(String look) {
        RoomLookActionEntity action = this.actions.getLook(look);
        if (action == null) {
            return null;
        }
        return action.getItemId();
    }

    public RoomActionsEntity getActions() { return this.actions; }
}
