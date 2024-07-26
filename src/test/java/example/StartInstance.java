package example;

// custom import
import engine.Game;
import engine.Instance;

import static backend.terminal.OutputEngine.printMessasgeToTerminal;
import static backend.terminal.OutputEngine.printErrorToTerminal;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.7
 */
class StartInstance extends Instance {

    final Game game;

    StartInstance(Game game) {

        this.game = game;
    }

    @Override
    public void enter() {

        printMessasgeToTerminal("Welcome to " + this.game.toString() + "."
                                + "\nThis an example game using this engine.");
    }

    @Override
    public void display() {
        
        printMessasgeToTerminal("You are in a dark room. " 
                                + "What do you want to do next?");
    }

    @Override
    public void go() {

        printMessasgeToTerminal("Where do you want to go? "
        + "\n1. Talk"
        + "\n2. Search"
        + "\n3. Use");

        // scanner
        int input = 1;

        // I could make this easier but I don't want to
        if (input == 1) {

            this.game.setInstance(new TalkInstance(this, this.game));
        } else if (input == 2) {

            this.game.setInstance(new SearchInstance(this, this.game));
        } else if (input == 3) {

            this.game.setInstance(new UseInstance(this, this.game));
        } else if (input == 0) {
            
            this.game.setInstance(new ExampleEndInstance());
        } else {

            printErrorToTerminal("Wrong input");
        }
    }
}
