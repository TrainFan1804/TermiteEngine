package de.o.le.termiteengine.engine.instance.exception;

import de.o.le.termiteengine.engine.instance.InstanceCore;
import de.o.le.termiteengine.engine.instance.event.GoEvent;
import de.o.le.termiteengine.engine.instance.event.LeaveEvent;

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
