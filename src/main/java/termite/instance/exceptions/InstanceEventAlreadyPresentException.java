package termite.instance.exceptions;

/**
 * This exception is thrown when want to add a
 * {@link termite.instance.event.InstanceEventType} that is already added in the
 * {@link termite.instance.Instance}.
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
