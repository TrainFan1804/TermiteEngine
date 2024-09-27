package de.o.le.termiteengine.internal.core.subsystem.exit;

import de.o.le.termiteengine.internal.core.EngineResources;
import de.o.le.termiteengine.internal.core.service.output.MessageType;
import de.o.le.termiteengine.internal.core.subsystem.EngineSubsystem;


/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class ExitSystem implements EngineSubsystem {

    @Override
    public void execute() {

		   EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_EXIT);
        System.exit(0);
    }
}
