package engine.instance;

import engine.core.services.output.Message;
import engine.instance.event.GoEvent;
import engine.instance.event.InstanceEvent;
import engine.instance.event.LeaveEvent;
import engine.instance.exceptions.InstanceEventAlreadyPresentException;
import engine.instance.exceptions.NoValidNeighborException;
import java.util.HashMap;
import java.util.Map;

/**
 * This builder is used to build your custom instances for the game,
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-2
 */
public class InstanceBuilderCore {

	int id;
	Message msg;

	Instance next;
	Instance prev;

	Map<Integer, InstanceEvent> events;

	public InstanceBuilderCore() {

		this.events = new HashMap<>();
	}

	public InstanceBuilderCore withId(int id) {

		this.id = id;
		return this;
	}

	public InstanceBuilderCore withMessage(Message msg) {

		this.msg = msg;
		return this;
	}

	public InstanceBuilderCore withEvent(InstanceEvent event) {

		if (event == null) throw new IllegalArgumentException("Event can't be null");

            	if (this.events.containsKey(event.getEventTypeId())) {

                	throw new InstanceEventAlreadyPresentException();
            	}

            	if ((event instanceof LeaveEvent && this.prev == null)
                   	|| (event instanceof GoEvent && this.next == null)) {

                	throw new NoValidNeighborException();
            	}

            	this.events.put(event.getEventTypeId(), event);
		return this;
	}

	/**
	 * TODO this work as expected because you cant add a next instance without
	 * creating the next instance first!
	 */
	public InstanceBuilderCore withNext(Instance next) {

		this.next = next;
		return this;
	}

	/**
	 * See comment on withNext(Instance)
	 */
	public InstanceBuilderCore withPrev(Instance prev) {

		this.prev = prev;
		return this;
	}

	public Instance build() {

		Instance instance = new Instance(this);

		this.id = 0;
		this.msg = null;
		this.next = null;
		this.prev = null;
		this.events = new HashMap<>();

		return instance;
	}
}
