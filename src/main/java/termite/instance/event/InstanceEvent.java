package termite.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public abstract class InstanceEvent {

    private InstanceEventType eventType;

    protected InstanceEvent(InstanceEventType eventType) {

        this.eventType = eventType;
    }

    public int getEventTypeId() {
        
        return this.eventType.ID;
    }

    public abstract void startEvent();
}
