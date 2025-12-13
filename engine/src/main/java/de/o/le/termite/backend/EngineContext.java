package de.o.le.termite.backend;

import java.io.FileNotFoundException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               25.12.13
 *
 * @implNote This class is designed as a <b>singleton</b> because that class holds an
 * unambiguous context for the engine.
 */
public class EngineContext {

    private static EngineContext INSTANCE;
    private boolean init = false;

    private GameObjectManager OBJECT_MANAGER;

    public static EngineContext getInstance() {

        if (INSTANCE == null) { INSTANCE = new EngineContext(); }

        return INSTANCE;
    }

    private EngineContext() { }

    public void init(String gamePath) throws FileNotFoundException {
        if (!init) {
            this.OBJECT_MANAGER = new GameObjectManager(gamePath);
            init = true;
        }
    }

    public GameObjectManager gameObjectManager() { return this.OBJECT_MANAGER; }
}
