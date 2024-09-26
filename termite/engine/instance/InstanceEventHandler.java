package engine.instance;

import engine.instance.event.GoEvent;
import engine.instance.event.InstanceEvent;
import engine.instance.event.LeaveEvent;
import engine.instance.event.NullEvent;
import engine.instance.exceptions.InstanceEventAlreadyPresentException;
import engine.instance.exceptions.NoValidNeighborException;
import java.util.HashMap;
import java.util.Map;

/**
 * This was extracted from the {@link Instance} class.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-2
 */
class InstanceEventHandler {

	private final Instance MASTER;
	private final Map<Integer, InstanceEvent> EVENTS;

	InstanceEventHandler(Instance instance) {

		this.MASTER = instance;
		this.EVENTS = new HashMap<>();
	}

	public void addEvent(InstanceEvent event) {

           	if (event == null) throw new IllegalArgumentException("Event can't be null");

            	if (this.EVENTS.containsKey(event.getEventTypeId())) {

                	throw new InstanceEventAlreadyPresentException();
            	}

            	if ((event instanceof LeaveEvent && this.MASTER.getPreInstance() == null)
                   	|| (event instanceof GoEvent && this.MASTER.getNextInstance() == null)) {

                	throw new NoValidNeighborException();
            	}

            	this.EVENTS.put(event.getEventTypeId(), event);
        }

	public InstanceEvent getEventById(int id) { 
		
		return this.EVENTS.getOrDefault(id, new NullEvent());
        }
}
