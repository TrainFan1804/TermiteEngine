package de.o.le.termiteengine.engine.core.subsystem.filesystem.save;

import de.o.le.termiteengine.engine.core.subsystem.EngineSubsystem;

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
