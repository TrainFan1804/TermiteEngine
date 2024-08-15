package termite.engine;

import termite.GameInstanceManager;
import termite.engine.delegationsystem.CommandDelegation;
import termite.engine.delegationsystem.DelegationHandler;

import java.util.Scanner;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Application {

    private Scanner scanner;
    private CommandDelegation commandDelegation;

    public Application(GameInstanceManager instanceManager) {

        this.scanner = new Scanner(System.in);
        this.commandDelegation = new CommandDelegation();
        ApplicationResources.initResources(instanceManager);
    }

    public void start() {

        Command command;
        String input;
        while (true) {

            // ask for input
            input = scanner.next().toUpperCase();
            try {

                // decode input to command
                command = Command.valueOf(input);

            } catch (IllegalArgumentException exception) {

                System.out.println("Invalid command");
                continue;
            }

            // determine if engine / game command
            DelegationHandler handler = this.commandDelegation.determineDelegation(command);
            // send engine command to engine or game command to game instance
            handler.send();
        }
    }
}
