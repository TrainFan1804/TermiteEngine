package engine.core.exceptions;

/**
 * This exception will be thrown when the player enter a command that is not
 * supported by the engine.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.26
 */
@Deprecated(since = "1.2.2", forRemoval = true)
public class UnknownCommandException extends Exception {

    public UnknownCommandException() { super("Unknown command"); }

    public UnknownCommandException(String msg) { super("Unknown command: " + msg); }
}
