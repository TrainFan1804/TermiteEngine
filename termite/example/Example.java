package example;

import api.Application;
import api.Game;
import api.Instance;
import api.InstanceBuilder;
import engine.instance.dialog.InstanceNPC;
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
				.withEvent(new NPCTalkEvent(new InstanceNPC("John", "./npctemplate.json")))
				.withEvent(new SearchEvent(() -> System.out.println("Search..")))
				.build();

		first.setNext(second);
		second.setPre(first);

		Game game = new Game();
		game.addInstance(first);
		game.addInstance(second);
		Application app = new Application(game);
		app.start();
    }
}
