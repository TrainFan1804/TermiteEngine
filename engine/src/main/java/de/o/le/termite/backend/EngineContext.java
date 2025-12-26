package de.o.le.termite.backend;

import java.io.FileNotFoundException;

/**
 * This class is containing different manager that are needed in the engine itself.
 * Currently only the {@link GameObjectManager} is wrapped inside that class.
 *
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

    private GameObjectManager gom;

    public static EngineContext getInstance() {

        if (INSTANCE == null) { INSTANCE = new EngineContext(); }
        return INSTANCE;
    }

    private EngineContext() { }

    public void init(String gamePath) throws FileNotFoundException {
        if (this.gom != null) {
            throw new IllegalStateException("EngineContext already initialized");
        }
        this.gom = new GameObjectManager(gamePath);
    }

    public GameObjectManager gameObjectManager() { return this.gom; }
}
