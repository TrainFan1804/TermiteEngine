package engine.core;

import engine.Game;
import engine.core.services.CommandDecodeService;
import engine.core.services.CommandDeterminationService;
import engine.core.services.SystemDelegationService;
import engine.core.services.output.Message;
import engine.core.subsystems.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.17
 */
public class Application {

    private final CommandDecodeService decodeService;
    private final CommandDeterminationService determineService;
    private final SystemDelegationService delegationService;

    public Application(Game game) {

        this.decodeService = new CommandDecodeService();
        this.determineService = new CommandDeterminationService();
		this.delegationService = new SystemDelegationService();

        /*
         * I don't like the idea of a static class that provide the resources
         * The only resources are the instances and also just one class use these
         * resources anyway (The EventSystem class)
         */
		ApplicationResources.setGame(game);
		ApplicationResources.initOutputContent();
    }

    public void start() {

        Command command;
        Message instanceMessage;

        while (true) {

            // I don't like this
            if (!ApplicationResources.wasInstanceSwitch) {

                instanceMessage = ApplicationResources.GAME.getCurrentInstance()
                                                            .display();
                ApplicationResources.OUT.printMessage(instanceMessage);
                ApplicationResources.wasInstanceSwitch = true;
            }

			command = this.inputCommandLoop();
            
            EngineSubsystem system = this.determineService
                                                .determineEngineSubsystem(command);

	    this.delegationService.delegate(system);
        }
    }

	private Command inputCommandLoop() {

		Command command = null;
		String input;

		do {

			input = ApplicationResources.IN.read();
			if (input.isEmpty()) continue;

			command = this.decodeService.commandDecode(input);

		} while(command == null);

		return command;
	} 
}
