package de.o.le.termiteengine.engine.core.subsystem.help;

import de.o.le.termiteengine.engine.core.EngineOutputResource;
import de.o.le.termiteengine.engine.core.service.output.MessageType;
import de.o.le.termiteengine.engine.core.subsystem.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.22
 */
final class HelpSystem implements EngineSubsystem {

    @Override
    public void execute() { EngineOutputResource.getInstance().OUT.printMessage(MessageType.MSG_HELP); }
}
