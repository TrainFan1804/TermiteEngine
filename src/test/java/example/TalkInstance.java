package example;

// custom import
import backend.terminal.Message;
import backend.terminal.GameMessage;
import engine.Game;
import engine.Instance;
import engine.NonPlayerCharacter;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               0.7
 */
public class TalkInstance extends Instance {

    final Game game;
    Instance previous;

    NonPlayerCharacter npc;

    TalkInstance(Instance previous, Game game) {

        this.previous = previous;
        this.game = game;
        this.npc = new ExampleNPC(null);
    }

    @Override
    public void display() {
        
        // printMessasge("You are in room without a roof. "
        //                         + "You see an NPC in the middle of the room."
        //                         + "\nWhat do you want to do next?");
    }

    @Override
    public Message talk() {
        
        this.npc.getDialog();
        return null;
    }

    @Override
    public Message leave() {
    
        this.game.setInstance(this.previous);
        return new GameMessage("Leave this instance.");
    }
}
