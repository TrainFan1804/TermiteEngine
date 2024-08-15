package termite.instance;

import termite.instance.event.InstanceEvent;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Instance {

    public final int ID_INSTANCE;
    // private List<Instance> neighbors;
    private Message instanceMessage;
    private InstanceEventHandler eventHandler;

    public Instance(int id) {

        this.ID_INSTANCE = id;
        this.eventHandler = new InstanceEventHandler();
        // this.neighbors = new ArrayList<>();
    }

    public InstanceEventHandler getEventHandler() { return this.eventHandler; }

    public void addEvent(InstanceEvent event) {

        if (event == null) throw new IllegalArgumentException("Event can't be null");

        this.eventHandler.addEvent(event);
    }

    public Message display() {

        return this.instanceMessage;
    }
}
