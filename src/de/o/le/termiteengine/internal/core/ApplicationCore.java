package de.o.le.termiteengine.internal.core;

import de.o.le.termiteengine.internal.GameCore;
import de.o.le.termiteengine.internal.core.service.CommandDecodeService;
import de.o.le.termiteengine.internal.core.service.CommandDeterminationService;
import de.o.le.termiteengine.internal.core.service.SystemDelegationService;
import de.o.le.termiteengine.internal.core.service.output.Message;
import de.o.le.termiteengine.internal.core.subsystem.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               0.17
 */
public class ApplicationCore {

	private final EngineResources RES;
    	private final CommandDecodeService decodeService;
    	private final CommandDeterminationService determineService;
    	private final SystemDelegationService delegationService;

    	public ApplicationCore(GameCore game) {

        	this.decodeService = new CommandDecodeService();
        	this.determineService = new CommandDeterminationService();
		this.delegationService = new SystemDelegationService();

		this.RES = EngineResources.createInstance(game);
    	}

    	public void start() {

       		Command command;
        	Message instanceMessage;

        	while (true) {

			/*
			When starting the game there should be printed the message
			from the first instance
			*/
            		if (this.RES.wasInstanceSwitch()) {

                		instanceMessage = this.RES.GAME.getCurrentInstance()
                                                            	.display();
                		this.RES.OUT.printMessage(instanceMessage);
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

			input = this.RES.IN.read();
			if (input.isEmpty()) continue;

			command = this.decodeService.commandDecode(input);

		} while(command == null);

		return command;
	} 
}
