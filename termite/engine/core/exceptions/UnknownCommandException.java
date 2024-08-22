package engine.core.exceptions;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.26
 */
public class UnknownCommandException extends Exception {

    public UnknownCommandException() { super("Unknown command"); }

    public UnknownCommandException(String msg) { super("Unknown command: " + msg); }
}
