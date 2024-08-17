package example;

import termite.*;
import termite.engine.Application;
import termite.instance.Instance;
import termite.instance.event.GoEvent;
import termite.instance.event.LeaveEvent;
import termite.instance.event.SearchEvent;
import termite.instance.event.TalkEvent;
import termite.instance.event.UseEvent;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Example {

    public static void main(String[] args) {
        
        Instance firstInstance = new Instance(0);
        firstInstance.addEvent(new TalkEvent(() -> System.out.println("Talk..")));
        firstInstance.addEvent(new UseEvent(() -> System.out.println("Use..")));

        Instance secondInstance = new Instance(1);
        secondInstance.addEvent(new SearchEvent(() -> System.out.println("Search..")));

        
        GameInstanceManager manager = new GameInstanceManager();
        manager.addInstance(firstInstance);
        manager.addInstance(secondInstance);

        firstInstance.addEvent(new GoEvent(() -> manager.setCurrentInstance(secondInstance)));
        secondInstance.addEvent(new LeaveEvent(() -> manager.setCurrentInstance(firstInstance)));

        Application application = new Application(manager);

        application.start();
    }
}
