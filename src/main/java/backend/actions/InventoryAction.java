package backend.actions;

import backend.terminal.GameMessage;

/**
 * @author                              o.le
 * @version                             0.1
 * @since                               0.8
 */
class InventoryAction implements Action {

    @Override
    public void executeEvent() {
        
        return new GameMessage("Open inventory");
    }
}
