package engine.core.subsystems.help;

import engine.core.ApplicationResources;
import engine.core.services.output.MessageType;
import engine.core.subsystems.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.22
 */
class HelpSystem implements EngineSubsystem {

    @Override
    public void execute() { ApplicationResources.OUT.printMessage(MessageType.MSG_HELP); }
}
