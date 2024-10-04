package de.o.le.termiteengine.engine.instance.event;

import de.o.le.termiteengine.engine.core.EngineSystemResources;
import de.o.le.termiteengine.engine.instance.exception.NoValidNeighborException;
import de.o.le.termiteengine.engine.instance.InstanceCore;

/**
 * When you want to create a go event create an object of this type and give it
 * the {@link InstanceCore}.
 * <p>
 *      When adding a go event be sure you also added a neighbor to the Instance
 *      with {@link InstanceCore#setPreInstance(Instance)}! Otherwise
 *      an {@link NoValidNeighborException} will be
 *      thrown.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public final class GoEvent extends InstanceEvent {

	
	/**
	 * Create a new GoEvent that will be executed when the player enter
	 * go into the terminal.
	 * <p>
	 * You don't need to do anything but add this event to your instance that
	 * should support this event. Everything will be handled by this event.
	 */
    	public GoEvent() {

        	super(InstanceEventType.GO_EVENT);
    	}

    	@Override
    	public void startEvent() {
    
	    	final EngineSystemResources RES = EngineSystemResources.getInstance();
        	// get current instance?
        	// get the neighbor
        	// set current instance to neighbor?
        	InstanceCore next = RES.GAME.getCurrentInstance().getNextInstance();
        	RES.GAME.setCurrentInstance(next.ID_INSTANCE);
    	}
}
