package termite.engine.subsystems;

import termite.engine.ApplicationResources;
import termite.instance.Instance;
import termite.instance.event.InstanceEvent;
import termite.instance.event.InstanceEventType;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class EventSystem implements EngineSystem {

    private InstanceEventType event;

    public EventSystem(InstanceEventType event) {

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
        InstanceEvent event = currentInstance.getEventById(this.event.ID);
        event.startEvent();
    }
}
