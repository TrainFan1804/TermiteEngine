package de.o.le.termiteengine.engine.instance.event;

import de.o.le.termiteengine.engine.core.EngineResources;
import de.o.le.termiteengine.internal.instance.exception.NoValidNeighborException;
import de.o.le.termiteengine.engine.instance.InstanceCore;

/**
 * When you want to create a leave event create an object of this type and give it
 * the {@link InstanceCore}.
 * <p>
 *      When adding a leave event be sure you also added a neighbor to the Instance
 *      with {@link InstanceCore#setNextInstance(Instance)}! Otherwise
 *      an {@link NoValidNeighborException} will be
 *      thrown.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public final class LeaveEvent extends InstanceEvent {

    public LeaveEvent() {

        super(InstanceEventType.LEAVE_EVENT);
    }

    @Override
    public void startEvent() {

	    final EngineResources RES = EngineResources.getInstance();
        InstanceCore pre = RES.GAME.getCurrentInstance().getPreInstance();
        RES.GAME.setCurrentInstance(pre.ID_INSTANCE);
    }
}
