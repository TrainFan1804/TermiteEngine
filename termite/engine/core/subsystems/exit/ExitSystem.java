package engine.core.subsystems.exit;

import engine.core.EngineResources;
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

		   EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_EXIT);
        System.exit(0);
    }
}
