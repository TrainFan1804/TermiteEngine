package backend.actions;

// custom import
import backend.TermiteSettings;
import backend.terminal.Message;

/**
 * This action will execute the search process in the current instance.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.8
 */
class SearchAction implements Action {

    @Override
    public Message execute() {
     
        return TermiteSettings.currentInstance.search();
    }
}
