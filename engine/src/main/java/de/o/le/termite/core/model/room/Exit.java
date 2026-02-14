package de.o.le.termite.core.model.room;

import de.o.le.termite.core.model.ModelIdGenerator;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.02.14
 */
public class Exit {

    private String exitId;

    private Direction direction;

    private Room targetRoom;

    public Exit(Direction direction, Room targetRoom) {
        this.direction = direction;
        this.targetRoom = targetRoom;
        this.exitId = ModelIdGenerator.generateId(this);
    }

    public String getExitId() {
        return exitId;
    }

    public Direction getDirection() {
        return direction;
    }

    public Room getTargetRoom() {
        return targetRoom;
    }
}
