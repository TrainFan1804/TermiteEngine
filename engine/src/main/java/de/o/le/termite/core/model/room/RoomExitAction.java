package de.o.le.termite.core.model.room;

/**
 * This is a wrapper for the room model's exit data. This model doesn't
 * only contain strings so when using it a casting in the right type
 * might be necessary.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.20
 */
public class RoomExitAction {

    private String requiredItemId;
    private String targetRoomId;
    private String failureMessage;

    public RoomExitAction() { }

    public String getRequiredItemId() { return requiredItemId; }

    public String getTargetRoomId() { return targetRoomId; }

    public String getFailureMessage() { return failureMessage; }
}
