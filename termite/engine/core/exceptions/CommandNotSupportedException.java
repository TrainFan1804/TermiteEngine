package engine.core.exceptions;

/**
 * This exception will be thrown when the player enter a command that is valid
 * but not supported by the {@link engine.instance.Instance}.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.35
 */
@Deprecated
class CommandNotSupportedException extends Exception {

    CommandNotSupportedException(String command) {

        super(command + " is not supported!");
    }
}
