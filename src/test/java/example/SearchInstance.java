package example;

// custom import
import backend.terminal.Message;
import backend.terminal.GameMessage;
import engine.Game;
import engine.Instance;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               0.7
 */
public class SearchInstance extends Instance {

    final Game game;
    Instance previous;

    SearchInstance(Instance previous, Game game) {

        this.previous = previous;
        this.game = game;
    }

    @Override
    public void display() {
        
        // printMessasge("You enter an emtpy room." 
        //                         + "\nWhat do you want to do next?");
    }

    @Override
    public Message search() {
        
        // TODO implement the secret search
        return null;
    }

    @Override
    public Message leave() {
    
        this.game.setInstance(this.previous);
        return new GameMessage("Leave this instance.");
    }
}
