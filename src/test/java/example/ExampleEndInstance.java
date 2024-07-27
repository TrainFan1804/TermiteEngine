package example;

// custom import
import backend.terminal.Message;
import backend.terminal.GameMessage;
import engine.Instance;
import engine.utils.EndInstance;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.7
 */
class ExampleEndInstance extends Instance implements EndInstance {
    
    @Override
    public Message enter() {

        return new GameMessage("This is the enter method in EndInstance");
    }

    @Override
    public void display() {}
}
