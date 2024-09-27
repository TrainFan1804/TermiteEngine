package engine.core.services.output;

/**
 * A message is a data holder class that holds the message that should be displayed
 * when the user <b>enter</b> a {@link Instance}. If you don't
 * set the message of the instance with
 * {@link Instance#setMessage(String)} the instance will display
 * a pre-defined message.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               0.17
 */
public class Message {

    private final String message;

    public Message(String message) {

        this.message = message;
    }

    @Override
    public String toString() { return this.message; }
}
