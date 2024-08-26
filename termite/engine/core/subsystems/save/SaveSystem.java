package engine.core.subsystems.save;

import engine.core.subsystems.EngineCommandSystem;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class SaveSystem implements EngineCommandSystem {

    @Override
    public void execute() {

        System.out.println("Save game..");
    }
}
