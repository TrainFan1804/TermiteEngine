package termite;

import java.util.HashMap;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class InstanceEventHandler {

    private Map<Integer, InstanceEvent> events;
    
    InstanceEventHandler() {

        this.events = new HashMap<>();
    }

    public void addEvent(InstanceEvent event) {

        if (event == null) throw new IllegalArgumentException();

        this.events.put(event.getEventTypeId(), event);
    }

    public InstanceEvent getEventById(int id) { return this.events.get(id); }
}
