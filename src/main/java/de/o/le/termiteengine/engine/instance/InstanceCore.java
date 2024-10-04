package de.o.le.termiteengine.engine.instance;

import de.o.le.termiteengine.engine.core.service.output.Message;
import de.o.le.termiteengine.engine.instance.event.GoEvent;
import de.o.le.termiteengine.engine.instance.event.InstanceEvent;
import de.o.le.termiteengine.engine.instance.event.LeaveEvent;
import de.o.le.termiteengine.engine.instance.event.NullEvent;
import de.o.le.termiteengine.engine.instance.exception.InstanceEventAlreadyPresentException;
import java.util.Map;

/**
 * This is the InstanceCore. A instance is something the player is inside. A
 * instance can have events that will be executed when the player enter a command.
 * 
 * @author                              o.le
 * @version                             1.4
 * @since                               0.17
 */
public class InstanceCore {

	/**
	 * The id of the instance. Is public because it's easier to access this
	 * final field.
	 */
    	public final int ID_INSTANCE;
    
    	private final Message instanceMessage;
	private final Map<Integer, InstanceEvent> events;

    	private InstanceCore nextInstance;
    	private InstanceCore preInstance;

	/**
	 * Create a new InstanceCore instance with a builder.
	 * 
	 * @param builder The builder that will build the instance.
	 */
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

	/**
	 * Get the next instance of the instance.
	 * 
	 * @return The next instance.
	 */
    	public InstanceCore getNextInstance() { return this.nextInstance; }

    	/*
     	* TODO should handle some error like put the same instance, nextinstance 
     	* already exists and so on.
     	*/
	/**
	 * Will set the next instance.
	 * 
	 * @param nextInstance The new next instance.
	 */
    	public void setNextInstance(InstanceCore nextInstance) { 

	    	InstanceEvent event = new GoEvent();
		// this is so bad haha..
		if (this.events.containsKey(event.getEventTypeId())) {

        		throw new InstanceEventAlreadyPresentException();
       		}

		this.nextInstance = nextInstance; 
		this.events.put(event.getEventTypeId(), event);
    	}

	/**
	 * Get the previous instance of the instance.
	 * 
	 * @return The previous instance.
	 */
    	public InstanceCore getPreInstance() { return this.preInstance; }

    	/*
     	* TODO see setNextInstance(Instance).
     	*/
	/**
	 * Will set the previous instance.
	 * 
	 * @param preInstance The new previous instance.
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
    
	/**
	 * Will return the event by a given id.
	 * 
	 * @param id The id of the event that should be returned.
	 * @return The event that is belong to the id. When there is no event with
	 * the id a {@link NullEvent} will be returned.
	 */
    	public InstanceEvent getEventById(int id) {
        
        	return this.events.getOrDefault(id, new NullEvent());
    	}
    
	/**
	 * Get the saved instance message.
	 * 
	 * @return The saved instance msssage.
	 */
    	public Message display() { return this.instanceMessage; }
}
