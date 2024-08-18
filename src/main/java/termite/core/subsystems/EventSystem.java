package termite.core.subsystems;

import termite.core.ApplicationResources;
import termite.instance.EventIdNotPresentException;
import termite.instance.Instance;
import termite.instance.event.InstanceEvent;
import termite.instance.event.InstanceEventType;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
class EventSystem implements EngineCommandSystem {

    private InstanceEventType event;

    EventSystem(InstanceEventType event) {

        this.event = event;
    }

    /*
     I need to create subclasses? for each unique event type.

     I could also create a constructor that take a Command / InstanceEvent
     as a parameter. Than I could use the saved instance in the handle method.
     */
    @Override
    public void execute() {

        Instance currentInstance = ApplicationResources.GAME.getCurrentInstance();
        InstanceEvent event;

        try {
            event = currentInstance.getEventById(this.event.ID);
            event.startEvent();
        } catch (EventIdNotPresentException e) {
            
            System.out.println(e.getLocalizedMessage());
        }
    }
}
