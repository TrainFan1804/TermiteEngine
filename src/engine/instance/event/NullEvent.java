package engine.instance.event;

import engine.core.EngineResources;
import engine.core.services.output.MessageType;

/**
 * This event is used to represent a not defined event. You should <b>not</b> use
 * this in your own game because that could cause some unexpected behavior!
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.20
 */
public final class NullEvent extends InstanceEvent {

    	public NullEvent() {

        	super(InstanceEventType.NULL_EVENT);
    	}

    	@Override
    	public void startEvent() { 
	    
	    	EngineResources.INSTANCE.OUT.printMessage(MessageType.MSG_EVENT_ID_NOT_PRESENT); 
    	}
}
