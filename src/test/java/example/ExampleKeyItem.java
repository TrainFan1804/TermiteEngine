package example;

// custom import
import engine.Item;

import static backend.terminal.OutputEngine.printMessasgeToTerminal;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.7
 */
class ExampleKeyItem extends Item {

    
    protected ExampleKeyItem() {
        
        super("Key");
    }

    @Override
    public void useItem() {
     
        printMessasgeToTerminal("You found a key!");   
    }
}
