package de.o.le.termite.engine.instance.event;

import de.o.le.termite.engine.instance.InstanceCore;
import de.o.le.termite.engine.instance.exception.InstanceEventAlreadyPresentException;

/**
 * This is an abstract class that define different events that can be happened in
 * a {@link InstanceCore}. To add an event to an instance use on of
 * the subtypes of this type and add it to the instance with
 * {@link InstanceCore#addEvent(InstanceEvent)}.
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

    	private final InstanceEventType eventType;

    	/**
     	 * Create a InstanceEvent instance.
     	 * 
     	 * @param eventType The type of the created InstanceEvent. Important for the
     	 * engine.
     	 */
    	protected InstanceEvent(InstanceEventType eventType) {

        	this.eventType = eventType;
    	}

    	/**
     	 * Get the id of the saved {@link InstanceEventType}.
     	 *
     	 * @return                          The id of the saved InstanceEventType.
     	 */
    	public final int getEventTypeId() { return this.eventType.ID; }

    	/**
     	 * Start the event.
     	 */
    	public abstract void startEvent();
}
