package engine.core.subsystems.exit;

import engine.core.subsystems.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class ExitSystem implements EngineSubsystem {

    @Override
    public void execute() {

        System.out.println("Exit game");
        System.exit(0);
    }
}
