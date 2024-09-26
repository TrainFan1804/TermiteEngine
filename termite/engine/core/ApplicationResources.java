package engine.core;

import engine.Game;
import engine.core.services.InputService;
import engine.core.services.output.OuputContentHandler;
import engine.core.services.output.OutputService;

/**
 * This class contains resources that are used everywhere in the engine and also
 * provide some resources for you.
 * <p>
 * This is class is obsolete now. Rather use {@link ApplicationResourcesSingleton}.
 * When just using this class for Output / Input this shouldn't be a problem.
 * 
 * @author                              o.le
 * @version                             1.2
 * @since                               0.21
 */
@Deprecated(since = "1.3.1", forRemoval = false)
public class ApplicationResources {

    	public static Game GAME = null;
	public static final InputService IN = new InputService();
	public static final OutputService OUT = new OutputService();

    	public static boolean wasInstanceSwitch = false;

	private static String pathToOutputContent = "resources/engine/output/default.json";

	public static final void changeOutputContentPath(String path) {

		pathToOutputContent = path;
	}

	static final void setGame(Game game) {

		GAME = game;
	}

	static final void initOutputContent() {

		OuputContentHandler.init(pathToOutputContent);
	}

    	private ApplicationResources() { }
}
