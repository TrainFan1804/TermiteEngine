package termite.instance;

import termite.instance.event.GoEvent;
import termite.instance.event.InstanceEvent;
import termite.instance.event.InstanceEventType;
import termite.instance.event.LeaveEvent;
import termite.instance.exceptions.EventIdNotPresentException;
import termite.instance.exceptions.InstanceEventAlreadyPresentException;
import termite.instance.exceptions.NoValidNeighborException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.0
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

            // TODO can this be done better?
            if (event instanceof LeaveEvent
                    && preInstance == null) {

                throw new NoValidNeighborException();
            }

            if (event instanceof GoEvent
                    && nextInstance == null) {

                throw new NoValidNeighborException();
            }

            this.events.put(event.getEventTypeId(), event);
        }

        public InstanceEvent getEventById(int id) throws EventIdNotPresentException {

            if (!this.events.containsKey(id)) throw new EventIdNotPresentException(); // return new NullEvent();

            return this.events.get(id);
        }
    }

    public final int ID_INSTANCE;
    
    private Message instanceMessage;
    private InstanceEventHandler eventHandler;

    private Instance nextInstance;
    private Instance preInstance;

    public Instance(int id) {

        this.ID_INSTANCE = id;
        this.eventHandler = new InstanceEventHandler();
        this.instanceMessage = new Message("You enter: " + this);
    }

    public Instance getNextInstance() { return this.nextInstance; }

    public void setNextInstance(Instance nexInstance) { this.nextInstance = nexInstance; }

    public Instance getPreInstance() { return this.preInstance; }

    public void setPreInstance(Instance preInstance) { this.preInstance = preInstance; }

    public void addEvent(InstanceEvent event) { this.eventHandler.addEvent(event); }
    
    public InstanceEvent getEventById(int id) throws EventIdNotPresentException {  
        
        return this.eventHandler.getEventById(id); 
    }
    
    public Message display() { return this.instanceMessage; }
    
    public void setMessage(String msg) { this.instanceMessage = new Message(msg); }
}
