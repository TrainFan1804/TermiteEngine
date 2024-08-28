package engine.instance.event;

import engine.instance.Instance;
import engine.instance.exceptions.InstanceEventAlreadyPresentException;

/**
 * This is an abstract class that define different events that can be happened in
 * a {@link Instance}. To add an event to an instance use on of
 * the subtypes of this type and add it to the instance with
 * {@link Instance#addEvent(InstanceEvent)}.
 * <p>
 *     The {@link InstanceEventType} will be automatically
 *     be set by on of the subtype.
 * </p>
 * <p>
 *     When you want to add the same event type more than one time an
 *     {@link InstanceEventAlreadyPresentException}
 *     will be thrown.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public abstract class InstanceEvent {

    private InstanceEventType eventType;

    protected InstanceEvent(InstanceEventType eventType) {

        this.eventType = eventType;
    }

    /**
     * Get the id of the saved {@link InstanceEventType}.
     *
     * @return                          The id of the saved InstanceEventType.
     */
    public final int getEventTypeId() {
        
        return this.eventType.ID;
    }

    /**
     * Start the event.
     */
    public abstract void startEvent();
}
