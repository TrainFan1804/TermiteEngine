package de.o.le.termiteengine.internal.core.subsystem.help;

import de.o.le.termiteengine.internal.core.EngineResources;
import de.o.le.termiteengine.internal.core.service.output.MessageType;
import de.o.le.termiteengine.internal.core.subsystem.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.22
 */
final class HelpSystem implements EngineSubsystem {

    @Override
    public void execute() { EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_HELP); }
}
