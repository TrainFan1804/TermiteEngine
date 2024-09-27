package engine.core.subsystems.filesystem.load;

import engine.core.subsystems.EngineSubsystem;

/**
 * @author                              o.le
 * @version                             2.0
 * @since                               0.22
 */
class LoadSystem implements EngineSubsystem {

    @Override
    public void execute() {

		LoadSystemController controller = new LoadSystemController();
		controller.init();
    }
}
