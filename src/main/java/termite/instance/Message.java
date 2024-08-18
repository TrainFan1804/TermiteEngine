package termite.instance;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Message {

    private String message;

    public Message(String message) {

        this.message = message;
    }

    @Override
    public String toString() { return this.message; }
}
