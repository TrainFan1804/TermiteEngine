package termite.backend.commands;

/**
 * This type is the actual class that will be executed when the end-user type a
 * command to the game terminal.
 * 
 * @author                              o.le
 * @version                             1.2
 * @since                               0.15
 */
public interface CommandAction {

    /**
     * Execute the saved command.
     */
    void execute();
}
