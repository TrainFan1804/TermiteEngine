package backend.actions;

// custom import
import backend.TermiteSettings;
import backend.terminal.Message;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.8
 */
class GoAction implements Action {

    @Override
    public Message execute() {

        return TermiteSettings.currentInstance.go();
    }
}
