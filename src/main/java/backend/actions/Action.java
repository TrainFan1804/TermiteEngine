package backend.actions;

// custom import
import backend.terminal.Message;

/**
 * An action is the executable form of a {@link CommandType}. Each CommandType
 * has one Action subtype that will execute the right command.
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.8
 */
public interface Action {

    /**
     * Execute the action. An send the message to the front end.
     */
    void executeEvent(int eventIndex);

    Message getEventMessage();
}
