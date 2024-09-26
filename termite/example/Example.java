package example;

import engine.api.Game;
import engine.api.Application;
import engine.instance.Instance;
import engine.instance.dialog.InstanceNPC;
import engine.instance.event.GoEvent;
import engine.instance.event.LeaveEvent;
import engine.instance.event.NPCTalkEvent;
import engine.instance.event.SearchEvent;
import engine.instance.event.TalkEvent;
import engine.instance.event.UseEvent;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               0.17
 * 
 * @deprecated A example will be created in a new repo.
 */
@Deprecated(forRemoval = true)
public class Example {

    public static void main(String[] args) {

        Instance firstInstance = new Instance(0);
        firstInstance.addEvent(new TalkEvent(() -> System.out.println("Talk..")));
        firstInstance.addEvent(new UseEvent(() -> System.out.println("Use..")));

        Instance secondInstance = new Instance(1);
        secondInstance.addEvent(new SearchEvent(() -> System.out.println("Search..")));
        InstanceNPC npc = new InstanceNPC("John", "./npctemplate.json"); // just for testing
	secondInstance.addEvent(new NPCTalkEvent(npc));

        firstInstance.setNextInstance(secondInstance);
        secondInstance.setPreInstance(firstInstance);
        
        firstInstance.addEvent(new GoEvent());
        secondInstance.addEvent(new LeaveEvent());

        Game game = new Game();
        game.addInstance(firstInstance);
        game.addInstance(secondInstance);

        Application application = new Application(game);

        application.start();
    }
}
