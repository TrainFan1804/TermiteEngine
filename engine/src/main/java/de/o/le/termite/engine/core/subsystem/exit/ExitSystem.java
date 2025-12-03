package de.o.le.termite.engine.core.subsystem.exit;

import de.o.le.termite.engine.core.EngineOutputResource;
import de.o.le.termite.engine.core.service.output.MessageType;
import de.o.le.termite.engine.core.subsystem.EngineSubsystem;


/**
 * The exit subsystem will handle the exit of the game. Will also print a exit
 * message.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class ExitSystem implements EngineSubsystem {

    @Override
    public void execute() {

	EngineOutputResource.getInstance().OUT.printMessage(MessageType.MSG_EXIT);
        System.exit(0);
    }
}
