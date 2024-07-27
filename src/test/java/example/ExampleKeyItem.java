package example;

import static backend.terminal.OutputEngine.printMessasge;

// custom import
import engine.Item;

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
     
        // printMessasge("You found a key!");
    }
}
