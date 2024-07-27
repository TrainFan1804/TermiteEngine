package example;

import java.util.List;
import java.util.LinkedList;
// custom import
import engine.Game;
import engine.Instance;
import engine.events.MoveEvent;
import backend.terminal.Message;
import backend.terminal.GameMessage;

import static backend.terminal.OutputEngine.printErrorToTerminal;
import static backend.terminal.OutputEngine.printMessasge;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               0.7
 */
class StartInstance extends Instance {

    final Game game;

    StartInstance(Game game) {

        this.game = game;
    }

    @Override
    public Message enter() {

        return new GameMessage("Welcome to " + this.game.toString() + "."
                                + "\nThis an example game using this engine.");
    }

    @Override
    public void display() {
        
        // printMessasge("You are in a dark room. " 
        //                         + "What do you want to do next?");
    }

    @Override
    public MoveEvent move() {
        
        List<Instance> nextInstances = new LinkedList<>();
        nextInstances.add(new TalkInstance(this, game));
        nextInstances.add(new SearchInstance(this, game));
        nextInstances.add(new UseInstance(this, game));
        nextInstances.add(new ExampleEndInstance());

        Message m = new GameMessage("Where do you want to go? "
                                    + "\n1. Talk"
                                    + "\n2. Search"
                                    + "\n3. Use");

        return new MoveEvent(nextInstances, m);
    }
}
