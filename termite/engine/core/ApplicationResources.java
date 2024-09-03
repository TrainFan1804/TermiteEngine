package engine.core;

import engine.Game;
import engine.core.services.InputService;
import engine.core.services.output.OutputService;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.21
 */
public class ApplicationResources {

    public static Game GAME = null;
	public static final InputService IN = new InputService();
	public static OutputService OUT = new OutputService();

    public static boolean wasInstanceSwitch = false;

	public static final void setGame(Game game) {

		GAME = game;
	}

	public static final void setCustomMessages(String path) {
	
		OUT.RES_PATH.setPath(path);
		// open file, read file, put content into MessageDisk.java
	}

    private ApplicationResources() { }
}

