package example;

import termite.*;
import termite.engine.Application;
import termite.instance.Instance;
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
        firstInstance.addEvent(new TalkEvent(() -> System.out.println("Talk")));
        firstInstance.addEvent(new UseEvent(() -> System.out.println("Use")));

        GameInstanceManager manager = new GameInstanceManager();
        manager.addInstance(firstInstance);

        Application application = new Application(manager);

        application.start();
    }
}
