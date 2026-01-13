package de.o.le.termite.backend;

import de.o.le.termite.backend.manager.GameObjectManager;

/**
 * This class is containing different manager that are needed in the engine itself.
 * Currently only the {@link GameObjectManager} is wrapped inside that class.
 *
 * @author                              o.le
 * @version                             2.0
 * @since                               25.12.13
 */
public class EngineContext {

    private GameObjectManager gom;

    public EngineContext(GameObjectManager gom) {
        this.gom = gom;
    }

    public GameObjectManager gameObjectManager() { return this.gom; }
}
