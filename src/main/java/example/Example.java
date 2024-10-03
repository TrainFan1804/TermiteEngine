package example;

import de.o.le.termiteengine.api.Application;
import de.o.le.termiteengine.api.EngineOutput;
import de.o.le.termiteengine.api.EventFactory;
import de.o.le.termiteengine.api.Game;
import de.o.le.termiteengine.api.Instance;
import de.o.le.termiteengine.api.InstanceBuilder;
import de.o.le.termiteengine.engine.core.service.output.Message;
import de.o.le.termiteengine.engine.instance.dialogue.InstanceNPC;
import de.o.le.termiteengine.engine.instance.event.ITalk;
import de.o.le.termiteengine.engine.instance.event.IUse;
import de.o.le.termiteengine.engine.instance.event.NPCTalkEvent;
import de.o.le.termiteengine.engine.instance.event.SearchEvent;

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
			EventFactory factory = EventFactory.FACTORY;

		Instance first = builder
				.withId(0)
				.withEvent(factory.create((ITalk) () -> {
					EngineOutput.out("Talk..");
					
				}))
				.withEvent(factory.create((IUse) () -> {
					EngineOutput.out("Use..");
				}))
				.build();

		Instance second = builder
				.withId(1)
				.withMessage(new Message("This is a custom message!"))
				.withEvent(new NPCTalkEvent(new InstanceNPC("John", "./npctemplate.json")))
				.withEvent(new SearchEvent(() -> EngineOutput.out("Search..")))
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
