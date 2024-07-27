package backend.actions;

// custom import
import backend.TermiteSettings;
import backend.terminal.Message;

/**
 * This action will execute the talk process in the current instance.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.8
 */
class TalkAction implements Action {

    @Override
    public Message execute() {
        
        // get the npc in the instance
        // start the talk prorcess
        return TermiteSettings.currentInstance.talk();
    }
}
