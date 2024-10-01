package de.o.le.termiteengine.engine.instance;

import de.o.le.termiteengine.engine.core.service.output.Message;
import de.o.le.termiteengine.engine.instance.event.GoEvent;
import de.o.le.termiteengine.engine.instance.event.InstanceEvent;
import de.o.le.termiteengine.engine.instance.event.LeaveEvent;
import de.o.le.termiteengine.engine.instance.exception.InstanceEventAlreadyPresentException;
import de.o.le.termiteengine.engine.instance.exception.NoValidNeighborException;
import java.util.HashMap;
import java.util.Map;

/**
 * This builder is used to build custom instances for the game. The developer
 * don't see this class and just use the public API to interact with this builder.
 * This class contains the logic of the instance build process.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-2
 */
public class InstanceBuilderCore {

	int id;
	Message msg;

	InstanceCore next;
	InstanceCore pre;

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

            	if ((event instanceof LeaveEvent && this.pre == null)
                   	|| (event instanceof GoEvent && this.next == null)) {

                	throw new NoValidNeighborException();
            	}

            	this.events.put(event.getEventTypeId(), event);
		return this;
	}

	public InstanceBuilderCore withNext(InstanceCore next) {

		this.next = next;
		return this;
	}

	public InstanceBuilderCore withPrev(InstanceCore pre) {

		this.pre = pre;
		return this;
	}

	public InstanceCore build() {

		InstanceCore instance = new InstanceCore(this);

		this.id = 0;
		this.msg = null;
		this.next = null;
		this.pre = null;
		this.events = new HashMap<>();

		return instance;
	}
}
