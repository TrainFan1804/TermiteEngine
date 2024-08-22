package engine.core;

import engine.Game;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.21
 */
public class ApplicationResources {

    public static Game GAME;

    public static boolean wasInstanceSwitch = false;

    static {
        GAME = null;
    }

    public static void initResources(Game game) {

        if (GAME == null) GAME = game;
    }

    private ApplicationResources() { }
}

