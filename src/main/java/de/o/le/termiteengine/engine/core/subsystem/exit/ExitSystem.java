package de.o.le.termiteengine.engine.core.subsystem.exit;

import de.o.le.termiteengine.engine.core.EngineOutputResource;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.core.subsystem.EngineSubsystem;


/**
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
