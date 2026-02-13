package de.o.le.termite.core.model.room;

/**
 * This is a wrapper for the room model's exit data. This model doesn't
 * only contain strings so when using it a casting in the right type
 * might be necessary.
 *
 * @author                              o.le
 * @version                             1.2
 * @since                               25.12.20
 */
public class RoomLookAction {

    private String itemId;
    private String message;
    private String altMessage;

    public RoomLookAction() { }

    public String getItemId() { return this.itemId; }

    public String getMessage() { return this.message; }

    public String getAltMessage() {
        return altMessage;
    }
}
