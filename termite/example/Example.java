package example;

import api.Application;
import api.Game;
import api.InstanceBuilder;
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
 * @version                             1.3
 * @since                               0.17
 * 
 * @deprecated A example will be created in a new repo.
 */
@Deprecated(forRemoval = true)
public class Example {

    	public static void main(String[] args) {

		InstanceBuilder builder = new InstanceBuilder();

		Instance first = builder
				.withId(0)
				.withEvent(new TalkEvent(() -> System.out.println("Talk..")))
				.withEvent(new UseEvent(() -> System.out.println("Use..")))
				.build();

		Instance second = builder
				.withId(1)
				.withEvent(new TalkEvent(() -> System.out.println("Talk..")))
				.withEvent(new UseEvent(() -> System.out.println("Use..")))
				.build();

		Game game = new Game();
		game.addInstance(first);
		game.addInstance(second);
		Application app = new Application(game);
		app.start();
				
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

        //Game game = new Game();
        //game.addInstance(firstInstance);
        //game.addInstance(secondInstance);

        //Application application = new Application(game);

        //application.start();
    }
}
