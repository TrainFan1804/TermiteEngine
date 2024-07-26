package example;

// custom import
import engine.Game;
import engine.Instance;
import engine.Item;

import static backend.terminal.OutputEngine.printMessasgeToTerminal;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.7
 */
public class UseInstance extends Instance {

    final Game game;
    Instance previous;
    Item item;

    UseInstance(Instance previous, Game game) {

        this.previous = previous;
        this.game = game;
        this.item = new ExampleKeyItem();
    }

    @Override
    public void display() {
        
        printMessasgeToTerminal("You are in a small room. "
                                + "You see a key on the table." 
                                + "\nWhat do you want to do next?");
    }

    @Override
    public void use() {
     
        this.item.useItem();
    }

    @Override
    public void leave() {
    
        printMessasgeToTerminal("Leave this instance.");
        this.game.setInstance(this.previous);
    }
}
