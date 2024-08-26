package engine.core.subsystems.exit;

import engine.core.subsystems.EngineCommandSystem;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class ExitSystem implements EngineCommandSystem {

    @Override
    public void execute() {

        System.out.println("Exit game");
        System.exit(0);
    }
}
