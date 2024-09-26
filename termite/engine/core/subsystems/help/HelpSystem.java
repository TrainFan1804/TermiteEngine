package engine.core.subsystems.help;

import engine.core.ApplicationResourcesSingleton;
import engine.core.services.output.MessageType;
import engine.core.subsystems.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.22
 */
final class HelpSystem implements EngineSubsystem {

    @Override
    public void execute() { ApplicationResourcesSingleton.INSTANCE.OUT.printMessage(MessageType.MSG_HELP); }
}
