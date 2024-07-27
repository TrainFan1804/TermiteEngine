package backend.terminal;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.10
 */
public abstract class Message {

    private String message;

    public Message(String message) {

        this.message = message;
    }

    public String getMessage() {

        return this.message;
    }

    @Override
    public String toString() {
    
        return this.message;
    }
}
