package engine.core;

import engine.Game;
import engine.core.exceptions.UnknownCommandException;
import engine.core.services.CommandDecodeService;
import engine.core.services.CommandDelegationService;
import engine.core.subsystems.EngineCommandSystem;
import engine.instance.Message;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Application {

    private CommandDecodeService decodeService;
    private CommandDelegationService delegationService;

    private InputService in;
    private OutputService out;

    public Application(Game game) {

        this.decodeService = new CommandDecodeService();
        this.delegationService = new CommandDelegationService();

        this.in = new InputService();
        this.out = new OutputService();

        /*
         * I don't like the idea of a static class that provide the resources
         * The only resources are the instances and also just one class use these
         * resources anyway (The EventSystem class)
         */
        ApplicationResources.initResources(game);
    }

    public void start() {

        String input;
        Command command;
        Message instanceMessage;

        while (true) {

            command = null;

            // I don't like this
            if (!ApplicationResources.wasInstanceSwitch) {

                instanceMessage = ApplicationResources.GAME.getCurrentInstance()
                                                            .display();
                this.out.printMessage(instanceMessage);
                ApplicationResources.wasInstanceSwitch = true;
            }

            do {
                
                input = this.in.read();

                try {
    
                    command = this.startDecodeService(input);
                } catch (UnknownCommandException e) {

                    this.out.printError(e);
                }
            } while (command == null);     
            
            EngineCommandSystem system = this.startDelegationService(command);
            system.execute();
        }
    }
    
    private Command startDecodeService(String input) throws UnknownCommandException {
    
        return this.decodeService.commandDecode(input);
    }
    
    private EngineCommandSystem startDelegationService(Command command) {
        
        return this.delegationService.determineDelegation(command);
    }
}
