package example;

// custom import
import backend.terminal.Message;
import backend.terminal.GameMessage;
import engine.Game;
import engine.Instance;
import engine.Item;

/**
 * @author                              o.le
 * @version                             1.2
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
        
        // printMessasge("You are in a small room. "
        //                         + "You see a key on the table." 
        //                         + "\nWhat do you want to do next?");
    }

    @Override
    public Message use() {
     
        this.item.useItem();
        return null;
    }

    @Override
    public Message leave() {
    
        this.game.setInstance(this.previous);
        return new GameMessage("Leave this instance.");
    }
}
