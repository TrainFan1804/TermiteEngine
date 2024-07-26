package engine;

// custom import
import engine.utils.InstanceAction;

import static backend.terminal.OutputEngine.printMessasgeToTerminal;

import backend.actions.CommandType;

import static backend.terminal.OutputEngine.printErrorToTerminal;

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
     */
    public void enter() {

        printMessasgeToTerminal("You enter a new instance.");
    }

    @Override
    public void talk() {

        printErrorToTerminal("You can't talk to anyone");
    }

    @Override
    public void search() {

        printErrorToTerminal("There are no secrets");
    }

    @Override
    public void use() {
        
        printErrorToTerminal("There are no items");
    }

    @Override
    public void go() {
        
        printErrorToTerminal("You can't go to another instance");
    }

    @Override
    public void leave() {
        
        printErrorToTerminal("You can't leave this instance");
    }
}
