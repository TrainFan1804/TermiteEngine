package de.o.le.termiteengine.internal.core.subsystem.filesystem.load;

import de.o.le.termiteengine.internal.core.subsystem.EngineSubsystem;

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
