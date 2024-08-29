package engine.core;

import engine.Game;
import engine.core.services.InputService;
import engine.core.services.OutputService;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.21
 */
public class ApplicationResources {

    public static Game GAME;
	public static final InputService IN = new InputService();
	public static final OutputService OUT = new OutputService();

    public static boolean wasInstanceSwitch = false;

    static {
        GAME = null;
    }

    public static void initResources(Game game) {

        if (GAME == null) GAME = game;
    }

    private ApplicationResources() { }
}

