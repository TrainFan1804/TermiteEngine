package termite.instance.event;

import termite.core.ApplicationResources;
import termite.instance.Instance;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public class GoEvent extends InstanceEvent {

    public GoEvent() {

        super(InstanceEventType.GO_EVENT);
    }

    @Override
    public void startEvent() { 
    
        // get current instance?
        // get the neighbor
        // set current instance to neighbor?
        ApplicationResources.wasInstanceSwitch = false; // bad 
        Instance next = ApplicationResources.GAME.getCurrentInstance().getNextInstance();
        ApplicationResources.GAME.setCurrentInstance(next.ID_INSTANCE);
    }
}
