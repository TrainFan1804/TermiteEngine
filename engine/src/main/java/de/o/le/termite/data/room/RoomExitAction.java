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
public class RoomExitAction {

    private String required;
    private String target;
    private String failure;

    public RoomExitAction() { }

    public String getRequired() { return required; }

    public String getTarget() { return target; }

    public String getFailure() { return failure; }
}
