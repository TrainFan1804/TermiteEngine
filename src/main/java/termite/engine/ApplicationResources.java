package termite.engine;

import termite.GameInstanceManager;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.21
 */
public class ApplicationResources {

    public static GameInstanceManager INSTANCE_MANAGER;

    static {
        INSTANCE_MANAGER = null;
    }

    public static void initResources(GameInstanceManager manager) {

        if (INSTANCE_MANAGER == null) INSTANCE_MANAGER = manager;
    }

    private ApplicationResources() { }
}

