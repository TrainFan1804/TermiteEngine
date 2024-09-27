package de.o.le.termiteengine.internal.instance.exception;

import de.o.le.termiteengine.internal.instance.InstanceCore;
import de.o.le.termiteengine.internal.instance.event.InstanceEventType;

/**
 * This exception is thrown when want to add a
 * {@link InstanceEventType} that is already added in the
 * {@link InstanceCore}.
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
