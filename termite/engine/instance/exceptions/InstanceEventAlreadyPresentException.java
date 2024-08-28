package engine.instance.exceptions;

import engine.instance.Instance;
import engine.instance.event.InstanceEventType;

/**
 * This exception is thrown when want to add a
 * {@link InstanceEventType} that is already added in the
 * {@link Instance}.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.19
 */
public class InstanceEventAlreadyPresentException extends RuntimeException {

    /**
     * Throw a new InstanceEventAlreadyPresentException.
     */
    public InstanceEventAlreadyPresentException() {

        super("You can't add more than two events of the same type!");
    }
}
