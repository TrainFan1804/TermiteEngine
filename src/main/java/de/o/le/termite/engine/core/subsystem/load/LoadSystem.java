package de.o.le.termite.engine.core.subsystem.load;

import de.o.le.termite.engine.core.subsystem.EngineSubsystem;

/**
 * The load system will handle the load routine of the games state. 
 * 
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
