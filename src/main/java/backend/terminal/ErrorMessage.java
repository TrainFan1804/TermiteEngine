package backend.terminal;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.10
 */
public class ErrorMessage extends Message {

    public ErrorMessage(String message) {
        
        super("[Error] " + message);
    }
}
