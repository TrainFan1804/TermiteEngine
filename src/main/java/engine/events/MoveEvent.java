package engine.events;

// java import
import java.util.List;
// custom import
import backend.terminal.Message;
import engine.Instance;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.11
 */
public class MoveEvent {

    private List<Instance> possibleInstances;
    private Message message;

    public MoveEvent(List<Instance> possibleInstances, Message message) {

        this.possibleInstances = possibleInstances;
        this.message = message;
    }

    public List<Instance> getInstances() {

        return this.possibleInstances;
    }
    
    public Message getMessage() {

        return this.message;
    }
}
