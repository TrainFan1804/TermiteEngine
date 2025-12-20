package de.o.le.termite.data.room;

/**
 * This is a wrapper for the room model's exit data. This model doesn't
 * only contain strings so when using it a casting in the right type
 * might be necessary.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.20
 */
public class RoomLookAction {

    private String item;
    private String message;

    public RoomLookAction() { }

    public String getItem() { return this.item; }

    public String getMessage() { return this.message; }
}
