package backend.actions;

// custom import
import backend.terminal.Message;

/**
 * This action will end the game process.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.8
 */
class ExitAction implements Action {

    @Override
    public Message execute() {
        
        System.out.println("Close game");
        System.exit(0);
        return null;   
    }
}
