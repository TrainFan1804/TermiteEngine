package engine.core.subsystems.filesystem.save;

import engine.core.subsystems.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               0.22
 */
class SaveSystem implements EngineSubsystem {

    @Override
    public void execute() {

		SaveSystemController controller = new SaveSystemController();
		controller.init();
    }
}
