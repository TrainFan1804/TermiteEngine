package example;

// custom import
import engine.Instance;
import engine.utils.EndInstance;

import static backend.terminal.OutputEngine.printMessasgeToTerminal;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.7
 */
class ExampleEndInstance extends Instance implements EndInstance {
    
    @Override
    public void enter() {

        printMessasgeToTerminal("This is the enter method in EndInstance");
    }

    @Override
    public void display() {}
}
