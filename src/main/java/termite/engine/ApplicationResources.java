package termite.engine;

import termite.Game;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.21
 */
public class ApplicationResources {

    public static Game GAME;

    static {
        GAME = null;
    }

    public static void initResources(Game game) {

        if (GAME == null) GAME = game;
    }

    private ApplicationResources() { }
}

