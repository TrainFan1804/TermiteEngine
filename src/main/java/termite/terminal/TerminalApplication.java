package termite.terminal;

// custom import
import termite.backend.Application;
import termite.backend.Game;
import termite.backend.commands.CommandAction;
import termite.backend.commands.CommandType;

/**
 * @author                              o.le
 * @version                             0.2
 * @since                               0.13
 */
public class TerminalApplication extends Application {

    private InputEngine inEngine;
    private OutputEngine outEngine;

    public TerminalApplication(Game game) {

        super(game);
        this.inEngine = InputEngine.getEngine();
        this.outEngine = OutputEngine.getEngine();
    }

    @Override
    public void start() {
    
        // start game
        /*
         * Steps:
         * 1. display instance screen   -- check
         * 2. wait for input    -- check
         * 3. check if input is valid command, if not go back to 2. -- check
         * 4. determie what action is decoded in the command
         * 5. if action is engine command handle here else send the command to game ?
         * 6. 
         */

        while(true) {

            this.outEngine.printMessasge(this.game.getCurrentInstance()
                                                .display()
                                                .getMessage());

            CommandAction action = this.askForCommand();
        }
    }

    private CommandAction askForCommand() {

        CommandAction command = null;

        while (command == null) {

            try {
                    
                String input = this.inEngine.strInput();
                command = super.decode(input);
            } catch (IllegalArgumentException e) {

                outEngine.printErrorMessage("Invalid input");
            }
        }

        return command;
    }
}
