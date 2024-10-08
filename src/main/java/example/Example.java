package example;

import de.o.le.termite.api.Application;
import de.o.le.termite.api.EventFactory;
import de.o.le.termite.api.Game;
import de.o.le.termite.api.Instance;
import de.o.le.termite.api.InstanceBuilder;
import de.o.le.termite.engine.core.EngineOutputResource;
import de.o.le.termite.engine.core.service.output.Message;
import de.o.le.termite.engine.instance.dialogue.InstanceNPC;
import de.o.le.termite.engine.instance.event.ITalk;
import de.o.le.termite.engine.instance.event.IUse;
import de.o.le.termite.engine.instance.event.NPCTalkEvent;
import de.o.le.termite.engine.instance.event.SearchEvent;

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
					EngineOutputResource.getInstance().OUT.printString("Talk..");
				}))
				.withEvent(factory.create((IUse) () -> {
					EngineOutputResource.getInstance().OUT.printString("Use..");
				}))
				.build();

		Instance second = builder
				.withId(1)
				.withMessage(new Message("This is a custom message!"))
				.withEvent(new NPCTalkEvent(new InstanceNPC("John", "./npctemplate.json")))
				.withEvent(new SearchEvent(() -> EngineOutputResource.getInstance().OUT.printString("Search..")))
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
