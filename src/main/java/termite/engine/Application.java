package termite.engine;

import termite.GameInstanceManager;
import termite.engine.subsystems.CommandDelegationService;
import termite.engine.subsystems.EngineSystem;

import java.util.Scanner;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Application {

    private Scanner scanner;
    private CommandDelegationService commandDelegation;

    public Application(GameInstanceManager instanceManager) {

        this.scanner = new Scanner(System.in);
        this.commandDelegation = new CommandDelegationService();
        ApplicationResources.initResources(instanceManager);
    }

    public void start() {

        Command command;
        while (true) {

            try {
                
                // represent the command decode service
                command = this.commandDecode();
                
            } catch (IllegalArgumentException exception) {
                
                System.out.println("Invalid command");
                continue;
            }
            
            EngineSystem system = this.delegateCommand(command);
            system.execute();
        }
    }
    
    private Command commandDecode() throws IllegalArgumentException {
        
        // ask for input
        String input = this.scanner.next().toUpperCase();
        // decode input to command
        return Command.valueOf(input);
    }
    
    private EngineSystem delegateCommand(Command command) {
        
        return this.commandDelegation.determineDelegation(command);
    }
}
