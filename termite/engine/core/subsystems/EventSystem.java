package engine.core.subsystems;

import engine.instance.InstanceCore;
import engine.instance.event.InstanceEvent;
import engine.instance.event.InstanceEventType;
import engine.core.EngineResources;

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
