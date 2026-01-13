package de.o.le.termite.backend;

import de.o.le.termite.backend.manager.GameObjectManager;
import de.o.le.termite.backend.manager.GameState;

/**
 * This class is containing different manager that are needed in the engine itself.
 *
 * <p>
 *     Following manager are currently wrapped inside this context:     <br>
 *
 *     1. {@link GameObjectManager}                                     <br>
 *     2. {@link GameState}                                             <br>
 * </p>
 *
 * The interface for this context is rather simple and provide directly access
 * to the manager.
 *
 * @author                              o.le
 * @version                             2.0
 * @since                               25.12.13
 */
public class EngineContext {

    private GameObjectManager gom;
    private GameState gs;

    public EngineContext(GameObjectManager gom, GameState gs) {
        this.gom = gom;
        this.gs = gs;
    }

    public GameObjectManager gameObjectManager() { return this.gom; }

    public GameState gameState() { return this.gs; }
}
