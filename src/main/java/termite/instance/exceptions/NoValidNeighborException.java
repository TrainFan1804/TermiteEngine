package termite.instance.exceptions;

import termite.instance.Instance;
/**
 * This exception will be thrown when you want to add a
 * {@link termite.instance.event.GoEvent} or {@link termite.instance.event.LeaveEvent}
 * without adding a neighbor instance with
 * {@link termite.instance.Instance#setNextInstance(Instance)} or
 * {@link termite.instance.Instance#setPreInstance(Instance)}.
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
