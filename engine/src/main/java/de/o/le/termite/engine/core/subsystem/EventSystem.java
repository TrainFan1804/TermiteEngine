package de.o.le.termite.engine.core.subsystem;

import de.o.le.termite.engine.core.EngineSystemResources;
import de.o.le.termite.engine.instance.InstanceCore;
import de.o.le.termite.engine.instance.event.InstanceEvent;
import de.o.le.termite.engine.instance.event.InstanceEventType;

/**
 * This is the event subsystem that will handle the event that was executed in
 * the instance.
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.22
 */
class EventSystem implements EngineSubsystem {

    	private final InstanceEventType eventType;

	/**
	 * Create a new EventSystem instance.
	 * 
	 * @param event The type of the event.
	 */
    	EventSystem(InstanceEventType event) {

        	this.eventType = event;
    	}

    	@Override
    	public void execute() {

        	InstanceCore currentInstance = EngineSystemResources.INSTANCE.GAME.getCurrentInstance();
        	InstanceEvent event;

           	event = currentInstance.getEventById(this.eventType.ID);
            	event.startEvent();
   	}
}
