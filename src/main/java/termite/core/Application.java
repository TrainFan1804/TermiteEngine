package termite.core;

import termite.Game;
import termite.core.exceptions.UnknownCommandException;
import termite.core.services.CommandDecodeService;
import termite.core.services.CommandDelegationService;
import termite.core.subsystems.EngineCommandSystem;
import termite.instance.Message;

import java.util.Scanner;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Application {

    private Scanner scanner;
    private CommandDecodeService decodeService;
    private CommandDelegationService delegationService;

    public Application(Game game) {

        this.scanner = new Scanner(System.in);
        this.decodeService = new CommandDecodeService();
        this.delegationService = new CommandDelegationService();

        /*
         * I don't like the idea of a static class that provide the resources
         * The only resources are the instances and also just one class use these
         * resources anyway (The EventSystem class)
         */
        ApplicationResources.initResources(game);
    }

    public void start() {

        String input;
        Command command = null;
        Message instanceMessage;
        
        while (true) {
    
            // I don't like this
            if (!ApplicationResources.wasInstanceSwitch) {

                instanceMessage = ApplicationResources.GAME.getCurrentInstance()
                                                            .display();
                System.out.println(instanceMessage);
                ApplicationResources.wasInstanceSwitch = true;
            }

            do {
                
                input = this.startInputService();

                try {
    
                    command = this.startDecodeService(input);
                } catch (UnknownCommandException e) {
                    
                    System.out.println(e.getLocalizedMessage());
                }
            } while (command == null);     
            
            EngineCommandSystem system = this.startDelegationService(command);
            system.execute();
            command = null; // don't delete because than it doesn't work as expected
        }
    }
    
    /*
     * TODO
     * This can be in a input class or something like that
     */
    private String startInputService() {
        
        return this.scanner.next();
    }

    private Command startDecodeService(String input) throws UnknownCommandException {
    
        return this.decodeService.commandDecode(input);
    }
    
    private EngineCommandSystem startDelegationService(Command command) {
        
        return this.delegationService.determineDelegation(command);
    }
}
