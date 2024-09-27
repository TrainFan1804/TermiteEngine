package engine.instance.event;

import engine.instance.exceptions.NoValidNeighborException;
import engine.core.EngineResources;
import engine.instance.InstanceCore;

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

    public GoEvent() {

        super(InstanceEventType.GO_EVENT);
    }

    @Override
    public void startEvent() {
    
	    final EngineResources RES = EngineResources.getInstance();
        // get current instance?
        // get the neighbor
        // set current instance to neighbor?
        InstanceCore next = RES.GAME.getCurrentInstance().getNextInstance();
        RES.GAME.setCurrentInstance(next.ID_INSTANCE);
    }
}
