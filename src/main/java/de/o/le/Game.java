package de.o.le;

// custom import
import backend.terminal.Command;

/**
 * A game contains everything the user needs during the course of the game no
 * matter where he is. Things that the user may need during the game are:
 * <p>
 * - {@link PlayerCharacter}
 * <p>
 * - {@link Inventory}
 * 
 * @author                              o.le
 * @version                             0.8
 * @since                               0.1
 */
public abstract class Game {

    protected Instance instance;
    private Command lastCommand;

    /**
     * Set the command that should be executed next.
     * 
     * @param command                   The command the user entered.
     */
    public void setCommand(Command command) {

        this.lastCommand = command;
    }

    /**
     * Execute the saved command.
     */
    public void execute() {

        switch (this.lastCommand) {
            case SAVE:
                System.out.println("Save game");
                break;
            case LOAD:
                System.out.println("Load game");;
                break;
            case EXIT:
                System.out.println("Exit game");;
                break;
            case HELP:
                System.out.println("Help");;
                break;
            default:
                this.instance.setState(InstanceState.valueOf(this.lastCommand.toString()));
                this.instance.executeAction();
        }
    }
    /**
     * Get the {@link Instance} the game is currently in.
     * 
     * @return                          The current instance.
     */
    public Instance getInstance() {

        return this.instance;
    }

    /**
     * Set the {@link Instance} the game should be in after the execution.
     * This will also execute {@link Instance#enter()}.
     * 
     * @param instance                  The new instance.
     */
    public void setInstance(Instance instance) {

        this.instance = instance;
        this.instance.enter();
    }

    /**
     * This method is the entry point to the game itself. In this method you
     * create everything that is used in the game through the whole game process.
     */
    public abstract void create();
}
