package termite.engine.delegationsystem;

import termite.engine.Application;
import termite.engine.ApplicationResources;
import termite.instance.Instance;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class EventSystem implements EngineSystem {

    /*
     TODO
     I need to create subclasses? for each unique event type.

     I could also create a constructor that take a Command / InstanceEvent
     as a parameter. Than I could use the saved instance in the handle method.
     */
    @Override
    public void handle() {

        Instance currentInstance = ApplicationResources.INSTANCE_MANAGER.getInstanceById(0);


        System.out.println("Handle event..");
    }
}
