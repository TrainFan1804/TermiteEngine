package termite.instance;

import termite.instance.event.InstanceEvent;
import termite.instance.event.NullInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Instance {

    private static class InstanceEventHandler {

        private Map<Integer, InstanceEvent> events;

        public InstanceEventHandler() {

            this.events = new HashMap<>();
        }

        public void addEvent(InstanceEvent event) {

            if (event == null) throw new IllegalArgumentException("Event can't be null");

            if (this.events.containsKey(event.getEventTypeId())) throw new InstanceEventAlreadyPresentException();
            
            this.events.put(event.getEventTypeId(), event);
        }

        public InstanceEvent getEventById(int id) {

            if (!this.events.containsKey(id)) return new NullInstance();

            return this.events.get(id);
        }
    }

    public final int ID_INSTANCE;
    
    private Message instanceMessage;
    private InstanceEventHandler eventHandler;

    public Instance(int id) {

        this.ID_INSTANCE = id;
        this.eventHandler = new InstanceEventHandler();
    }

    public void addEvent(InstanceEvent event) { this.eventHandler.addEvent(event); }

    public InstanceEvent getEventById(int id) {  return this.eventHandler.getEventById(id); }

    public Message display() { return this.instanceMessage; }
}
