package example;

import termite.Engine;
import termite.Game;
import termite.Instance;
import termite.InstanceManager;
import termite.TalkEvent;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Example {

    public static void main(String[] args) {
        
        Instance firstInstance = new Instance(0);
        firstInstance.addEvent(new TalkEvent());

        InstanceManager manager = new InstanceManager();
        manager.addInstance(firstInstance);

        Game game = new Game(manager);

        Engine engine = new Engine(game);

        engine.start();
    }
}
