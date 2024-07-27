package engine;

// custom import
import backend.actions.CommandType;
import backend.terminal.Message;
import backend.terminal.GameMessage;
import engine.events.MoveEvent;
import engine.utils.InstanceAction;

/**
 * A instance represent the most used asset in an textadventure. The current 
 * place where the user's {@link Character} can be inside is an instance. Each
 * instance <b>may</b> contain one NPC's to talk with, secret to find, or item 
 * to use.
 * 
 * @author                              o.le
 * @version                             1.2
 * @since                               0.1
 */
public abstract class Instance implements InstanceAction {
    
    /**
     * This method will be executed after each {@link CommandType} the user has
     * entered in the terminal. The user also need to be in this instance.
     */
    public abstract void display();

    /**
     * This method is do something as soon as the player enter this instance.
     * 
     * TODO it's not very pretty that an EndInstance will execute this one more time
     */
    public Message enter() {

        return new GameMessage("You enter a new instance.");
    }

    @Override
    public Message talk() {

        return new GameMessage("You can't talk to anyone");
    }

    @Override
    public Message search() {

        return new GameMessage("There are no secrets");
    }

    @Override
    public Message use() {
        
        return new GameMessage("There are no items");
    }

    @Override
    public MoveEvent move() {
        
        return new MoveEvent(null, 
                new GameMessage("You can't move to another instance")); 
    }

    @Override
    public Message leave() {
        
        return new GameMessage("You can't leave this instance");
    }
}
