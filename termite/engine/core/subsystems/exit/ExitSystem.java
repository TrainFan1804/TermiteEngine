package engine.core.subsystems.exit;

import engine.core.ApplicationResourcesSingleton;
import engine.core.subsystems.EngineSubsystem;
import engine.core.services.output.MessageType;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class ExitSystem implements EngineSubsystem {

    @Override
    public void execute() {

		   ApplicationResourcesSingleton.INSTANCE.OUT.printMessage(MessageType.MSG_EXIT);
        System.exit(0);
    }
}
