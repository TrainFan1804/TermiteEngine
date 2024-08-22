package engine.instance.exceptions;

import engine.core.Command;
import engine.instance.Instance;

/**
 * This exception is thrown when the user enter a {@link Command} that
 * is <b>not</b> implemented in the current {@link Instance}.
 * <p>
 *     You don't need to catch this exception. The engine will handle the
 *     exception on his own.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.30
 */
public class EventIdNotPresentException extends Exception {

    /**
     * Throw a new EventIdNotPresentException.
     */
    public EventIdNotPresentException() { super("Event is not supported in this instance"); }
}
