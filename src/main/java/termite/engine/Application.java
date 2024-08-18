package termite.engine;

import termite.Game;
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

    public Application(Game game) {

        this.scanner = new Scanner(System.in);
        this.commandDelegation = new CommandDelegationService();

        /*
         * I don't like the idea of a static class that provide the resources
         * The only resources are the instances and also just one class use these
         * resources anyway (The EventSystem class)
         */
        ApplicationResources.initResources(game);
    }

    public void start() {

        Command command;
        while (true) {
    
            command = this.askForUserInput();            
            
            EngineSystem system = this.delegateCommand(command);
            system.execute();
        }
    }
    
    private Command askForUserInput() {
        
        while (true) {
            
            try {
                
                // represent the command decode service
                return this.commandDecode();
            } catch (UnknownCommandException e) {
                
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
    
    private Command commandDecode() throws UnknownCommandException {
        
        // ask for input
        String input = this.scanner.next().toUpperCase();
        
        try {

            // decode input to commands
            return Command.valueOf(input);
        } catch (IllegalArgumentException e) {
 
            throw new UnknownCommandException(input);
        }
    }
    
    private EngineSystem delegateCommand(Command command) {
        
        return this.commandDelegation.determineDelegation(command);
    }
}
