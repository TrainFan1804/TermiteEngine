package termite.instance.event;

import termite.core.ApplicationResources;
import termite.instance.Instance;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public class LeaveEvent extends InstanceEvent {

    public LeaveEvent() {

        super(InstanceEventType.LEAVE_EVENT);
    }

    @Override
    public void startEvent() { 

        ApplicationResources.wasInstanceSwitch = false;
        Instance pre = ApplicationResources.GAME.getCurrentInstance().getPreInstance();
        ApplicationResources.GAME.setCurrentInstance(pre.ID_INSTANCE);
    }
}
