package termite.instance.event;

import termite.core.ApplicationResources;
import termite.instance.Instance;

/**
 * When you want to create a leave event create an object of this type and give it
 * the {@link termite.instance.Instance}.
 * <p>
 *      When adding a leave event be sure you also added a neighbor to the Instance
 *      with {@link termite.instance.Instance#setNextInstance(Instance)}! Otherwise
 *      an {@link termite.instance.exceptions.NoValidNeighborException} will be
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
    public final void startEvent() {

        ApplicationResources.wasInstanceSwitch = false;
        Instance pre = ApplicationResources.GAME.getCurrentInstance().getPreInstance();
        ApplicationResources.GAME.setCurrentInstance(pre.ID_INSTANCE);
    }
}
