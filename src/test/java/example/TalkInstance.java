package example;

// custom import
import engine.Game;
import engine.Instance;
import engine.NonPlayerCharacter;

import static backend.terminal.OutputEngine.printMessasgeToTerminal;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.7
 */
public class TalkInstance extends Instance {

    final Game game;
    Instance previous;

    NonPlayerCharacter npc;

    TalkInstance(Instance previous, Game game) {

        this.previous = previous;
        this.game = game;
        this.npc = new NonPlayerCharacter(null, null);
    }

    @Override
    public void display() {
        
        printMessasgeToTerminal("You are in room without a roof. "
                                + "You see an NPC in the middle of the room."
                                + "\nWhat do you want to do next?");
    }

    @Override
    public void talk() {
        // TODO implement the talking
    }

    @Override
    public void leave() {
    
        printMessasgeToTerminal("Leave this instance.");
        this.game.setInstance(this.previous);
    }
}
