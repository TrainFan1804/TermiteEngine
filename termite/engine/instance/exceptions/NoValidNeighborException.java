package engine.instance.exceptions;

import engine.instance.InstanceCore;
import engine.instance.event.GoEvent;
import engine.instance.event.LeaveEvent;

/**
 * This exception will be thrown when you want to add a
 * {@link GoEvent} or {@link LeaveEvent}
 * without adding a neighbor instance with
 * {@link InstanceCore#setNextInstance(Instance)} or
 * {@link InstanceCore#setPreInstance(Instance)}.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.34
 */
public class NoValidNeighborException extends RuntimeException {

    /**
     * Throw a new NoValidNeighborException.
     */
    public NoValidNeighborException() {

        super("You need to add a neighbor with Instance#setNextInstance "
                + "/ Instance#setPreInstance");
    }
}
