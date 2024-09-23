package engine.core.subsystems;

import engine.instance.Instance;
import engine.instance.event.InstanceEvent;
import engine.instance.event.InstanceEventType;
import engine.core.ApplicationResources;

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

        	Instance currentInstance = ApplicationResources.GAME.getCurrentInstance();
        	InstanceEvent event;

           	event = currentInstance.getEventById(this.eventType.ID);
            	event.startEvent();
   	}
}
