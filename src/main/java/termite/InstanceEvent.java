package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public abstract class InstanceEvent {

    private EventType eventType;

    protected InstanceEvent(EventType eventType) {

        this.eventType = eventType;
    }

    public int getEventTypeId() {
        
        return this.eventType.ID;
    }

    public abstract void startEvent();
}
