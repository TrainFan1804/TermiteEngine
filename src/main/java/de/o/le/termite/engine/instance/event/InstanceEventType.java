package de.o.le.termite.engine.instance.event;

import de.o.le.termite.engine.instance.InstanceCore;

/**
 * This enum define the different event types that can be created and be used
 * inside an {@link InstanceCore}.
 *
 * @author                              o.le
 * @version                             1.1
 * @since                               0.17
 */
public enum InstanceEventType {

	NULL_EVENT(-1),
    	TALK_EVENT(0),
    	SEARCH_EVENT(1),
    	USE_EVENT(2),
    	GO_EVENT(3),
    	LEAVE_EVENT(4);

    	public final int ID;

    	InstanceEventType(int id) {

        	this.ID = id;
    	}
}
