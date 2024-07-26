package example;

// custom import
import engine.Game;
import engine.Instance;
import static backend.terminal.OutputEngine.printMessasgeToTerminal;

/**
 * @author                              o.le
 * @version                             1.1
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
        
        printMessasgeToTerminal("You enter an emtpy room." 
                                + "\nWhat do you want to do next?");
    }

    @Override
    public void search() {
        
        // TODO implement the secret search
    }

    @Override
    public void leave() {
    
        printMessasgeToTerminal("Leave this instance.");
        this.game.setInstance(this.previous);
    }
}
