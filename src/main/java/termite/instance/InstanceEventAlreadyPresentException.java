package termite.instance;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.19
 */
public class InstanceEventAlreadyPresentException extends RuntimeException {

    public InstanceEventAlreadyPresentException() {

        super("You can't add more than two events of the same type!");
    }
}
