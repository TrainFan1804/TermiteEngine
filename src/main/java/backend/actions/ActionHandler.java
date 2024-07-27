package backend.actions;

import backend.terminal.Message;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.11
 */
public class ActionHandler {

    private Action action;

    public void setAction(Action action) {

        this.action = action;
    }

    public void exectuteAction(int userChoice) {

        this.action.executeEvent(userChoice);
    }

    public Message actionMessage() {

        return this.action.getEventMessage();
    }
}
