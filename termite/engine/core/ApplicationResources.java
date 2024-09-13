package engine.core;

import engine.Game;
import engine.core.services.InputService;
import engine.core.services.output.OuputContentHandler;
import engine.core.services.output.OutputService;

/**
 * @author                              o.le
 * @version                             1.1
 * @since                               0.21
 */
public class ApplicationResources {

    public static Game GAME = null;
	public static final InputService IN = new InputService();
	public static final OutputService OUT = new OutputService();

    public static boolean wasInstanceSwitch = false;

	private static String pathToOutputContent = "resources/engine/default.json";

	public static final void setGame(Game game) {

		GAME = game;
	}

	public static final void initOutputContent() {

		OuputContentHandler.init(pathToOutputContent);
	}

	public static final void changeOutputContentPath(String path) {

		pathToOutputContent = path;
	}

    private ApplicationResources() { }
}

