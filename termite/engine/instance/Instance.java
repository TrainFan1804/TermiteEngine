package engine.instance;

import engine.core.services.output.Message;
import engine.instance.event.GoEvent;
import engine.instance.event.InstanceEvent;
import engine.instance.event.LeaveEvent;
import engine.instance.event.NullEvent;
import engine.instance.exceptions.InstanceEventAlreadyPresentException;
import engine.instance.exceptions.NoValidNeighborException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.17
 */
public class Instance {

    	private class InstanceEventHandler {

        	private Map<Integer, InstanceEvent> events;

        	public InstanceEventHandler() {

            		this.events = new HashMap<>();
        	}

        	public void addEvent(InstanceEvent event) {

            		if (event == null) throw new IllegalArgumentException("Event can't be null");

            		if (this.events.containsKey(event.getEventTypeId())) {

                		throw new InstanceEventAlreadyPresentException();
            		}

            		if ((event instanceof LeaveEvent && Instance.this.preInstance == null)
                    		|| (event instanceof GoEvent && Instance.this.nextInstance == null)) {

                		throw new NoValidNeighborException();
            		}

            		this.events.put(event.getEventTypeId(), event);
        	}

		public InstanceEvent getEventById(int id) { 
		
			return this.events.getOrDefault(id, new NullEvent());
        	}
    	}

    	public final int ID_INSTANCE;
    
    	private Message instanceMessage;
    	private final InstanceEventHandler eventHandler;

    	private Instance nextInstance;
    	private Instance preInstance;

	public Instance() {

		this(InstanceIdCounter.ENTITY.getIdCount());
	}

    public Instance(int id) {

        this.ID_INSTANCE = id;
        this.eventHandler = new InstanceEventHandler();

		// TODO this need to be variable via JSON!
        this.instanceMessage = new Message("You enter: " + this);
    }

	/**
	 * Don't use this. You should get the id via the public field
	 * {@link Instance#ID_INSTANCE}
	 */
	@Deprecated(since = "1.2.6")
	public int getID() { return this.ID_INSTANCE; }

    public Instance getNextInstance() { return this.nextInstance; }

    public void setNextInstance(Instance nexInstance) { this.nextInstance = nexInstance; }

    public Instance getPreInstance() { return this.preInstance; }

    public void setPreInstance(Instance preInstance) { this.preInstance = preInstance; }

	/**
	 * @deprecated The saved message shouldn't be changed anymore. After removing
	 * the filed will go final!
	 */
	@Deprecated(since = "1.2.6", forRemoval = true)
   	public void setMessage(Message msg) { this.instanceMessage = msg; } 
    
    public void addEvent(InstanceEvent event) { this.eventHandler.addEvent(event); }
    
    public InstanceEvent getEventById(int id) {
        
        return this.eventHandler.getEventById(id); 
    }
    
    public Message display() { return this.instanceMessage; }
}
