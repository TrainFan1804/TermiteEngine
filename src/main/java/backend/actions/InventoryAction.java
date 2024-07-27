package backend.actions;

// custom import
import backend.terminal.Message;
import backend.terminal.GameMessage;

/**
 * @author                              o.le
 * @version                             0.1
 * @since                               0.8
 */
class InventoryAction implements Action {

    @Override
    public Message execute() {
        
        return new GameMessage("Open inventory");
    }
}
