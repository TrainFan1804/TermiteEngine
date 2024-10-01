package de.o.le.termiteengine.engine.core.subsystem;

import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.engine.instance.InstanceCore;
import de.o.le.termiteengine.engine.instance.event.InstanceEvent;
import de.o.le.termiteengine.engine.instance.event.InstanceEventType;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.22
 */
class EventSystem implements EngineSubsystem {

    	private final InstanceEventType eventType;

    	EventSystem(InstanceEventType event) {

        	this.eventType = event;
    	}

    	@Override
    	public void execute() {

        	InstanceCore currentInstance = EngineResources.INSTANCE.GAME.getCurrentInstance();
        	InstanceEvent event;

           	event = currentInstance.getEventById(this.eventType.ID);
            	event.startEvent();
   	}
}
