package de.o.le.termite.engine.core.subsystem.save;

import de.o.le.termite.engine.core.subsystem.EngineSubsystem;

/**
 * The save system will handle the save routine of the games state. 
 * 
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
