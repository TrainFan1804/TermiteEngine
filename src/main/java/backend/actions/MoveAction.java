package backend.actions;

// custom import
import backend.TermiteSettings;
import backend.terminal.Message;
import engine.events.MoveEvent;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               0.8
 */
class MoveAction implements Action {

    MoveEvent event;

    public MoveAction() {

        this.event = TermiteSettings.currentInstance.move();
    }

    @Override
    public void executeEvent(int eventIndex) {

        this.event.getInstances().get(eventIndex);
    }

    @Override
    public Message getEventMessage() {

        return this.event.getMessage();
    }
}
