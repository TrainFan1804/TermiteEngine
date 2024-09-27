package de.o.le.termiteengine.internal.instance;

import de.o.le.termiteengine.internal.core.service.output.Message;
import de.o.le.termiteengine.internal.instance.event.GoEvent;
import de.o.le.termiteengine.internal.instance.event.InstanceEvent;
import de.o.le.termiteengine.internal.instance.event.LeaveEvent;
import de.o.le.termiteengine.internal.instance.event.NullEvent;
import de.o.le.termiteengine.internal.instance.exception.InstanceEventAlreadyPresentException;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.4
 * @since                               0.17
 */
public class InstanceCore {

    	public final int ID_INSTANCE;
    
    	private final Message instanceMessage;
	private final Map<Integer, InstanceEvent> events;

    	private InstanceCore nextInstance;
    	private InstanceCore preInstance;

	InstanceCore(InstanceBuilderCore builder) {

		this.ID_INSTANCE = builder.id;

		if (builder.msg == null) {

			this.instanceMessage = new Message("You entered: " + this);
		} else {

			this.instanceMessage = builder.msg;
		}

		this.nextInstance = builder.next;
		this.preInstance = builder.pre;
		this.events = builder.events;
	}

    public InstanceCore getNextInstance() { return this.nextInstance; }

    /**
     * TODO should handle some error like put the same instance, nextinstance 
     * already exists and so on.
     */
    public void setNextInstance(InstanceCore nexInstance) { 

	    InstanceEvent event = new GoEvent();
	// this is so bad haha..
	if (this.events.containsKey(event.getEventTypeId())) {

        	throw new InstanceEventAlreadyPresentException();
       	}

	this.nextInstance = nexInstance; 
	this.events.put(event.getEventTypeId(), event);
    }


    public InstanceCore getPreInstance() { return this.preInstance; }

    /**
     * TODO see setNextInstance(Instance).
     */
    public void setPreInstance(InstanceCore preInstance) { 
	    
	    InstanceEvent event = new LeaveEvent();
	// this is so bad haha..
	if (this.events.containsKey(event.getEventTypeId())) {

        	throw new InstanceEventAlreadyPresentException();
       	}

	    this.preInstance = preInstance; 
	    this.events.put(event.getEventTypeId(), event);
    }
    
    public InstanceEvent getEventById(int id) {
        
        return this.events.getOrDefault(id, new NullEvent());
    }
    
    public Message display() { return this.instanceMessage; }
}
