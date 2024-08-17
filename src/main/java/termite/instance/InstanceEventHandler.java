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
public class InstanceEventHandler {

    /*
    If I could change this to a list I wouldn't need a ID 
     */
    private Map<Integer, InstanceEvent> events;
    
    public InstanceEventHandler() {

        this.events = new HashMap<>();
    }

    public void addEvent(InstanceEvent event) {

        if (event == null) throw new IllegalArgumentException("Instance can't be null");

        if (this.events.containsKey(event.getEventTypeId())) throw new InstanceEventAlreadyPresentException();

        this.events.put(event.getEventTypeId(), event);
    }

    public InstanceEvent getEventById(int id) {

        if (!this.events.containsKey(id)) return new NullInstance();

        return this.events.get(id);
    }
}
