package termite.backend.utils;

/**
 * @author                              o.le
 * @version                             0.1
 * @since                               0.12
 */
public class SameArgumentObjectException extends RuntimeException {

    public SameArgumentObjectException() {

        super("The same argument isn't allowed!");
    }
}
