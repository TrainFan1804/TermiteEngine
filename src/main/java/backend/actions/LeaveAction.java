package backend.actions;

// custom import
import backend.TermiteSettings;
import backend.terminal.Message;

/**
 * This action will execute the leave process in the current instance.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.8
 */
class LeaveAction implements Action {

    @Override
    public Message executeEvent() {
     
        return TermiteSettings.currentInstance.leave();
    }
}
