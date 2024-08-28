package engine.core;

import engine.core.services.InputService;
import engine.core.services.OutputService;
import engine.Game;
import engine.core.exceptions.UnknownCommandException;
import engine.core.services.CommandDecodeService;
import engine.core.services.CommandDeterminationService;
import engine.core.services.SystemDelegationService;
import engine.instance.Message;
import engine.core.subsystems.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Application {

    private CommandDecodeService decodeService;
    private CommandDeterminationService determineService;
    private SystemDelegationService delegationService;

    private InputService in;
    private OutputService out;

    public Application(Game game) {

        this.decodeService = new CommandDecodeService();
        this.determineService = new CommandDeterminationService();
	this.delegationService = new SystemDelegationService();

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

            command = null; // make sure the command is cleared each iteration

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
    
                    command = this.decodeService.commandDecode(input);
                } catch (UnknownCommandException e) {

                    this.out.printError(e);
                }
            } while (command == null);     
            
            EngineSubsystem system = this.determineService
                                                .determineEngineSubsystem(command);

	    this.delegationService.delegate(system);
        }
    }
}
