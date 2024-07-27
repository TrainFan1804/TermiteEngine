package backend.actions;

// custom import
import backend.terminal.Message;
import backend.terminal.GameMessage;

/**
 * @author                              o.le
 * @version                             0.1
 * @since                               0.8
 */
class LoadAction implements Action {

    @Override
    public Message executeEvent() {
        
        return new GameMessage("Load a save game"); // TODO make a SystemMessage type
    }
}
