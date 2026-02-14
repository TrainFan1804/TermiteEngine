package de.o.le.termite.application;

import de.o.le.termite.application.port.GameObjectRepository;
import de.o.le.termite.application.services.SaveStateMapper;

import de.o.le.termite.application.state.GameState;
import de.o.le.termite.application.state.SaveState;

/**
 * This class is containing different manager that are needed in the engine itself.
 *
 * <p>
 *     Following manager are currently wrapped inside this context:     <br>
 *
 *     1. {@link GameObjectRepository}                                     <br>
 *     2. {@link GameState}                                             <br>
 * </p>
 *
 * The interface for this context is rather simple and provide directly access
 * to the manager.
 *
 * @author                              o.le
 * @version                             2.2
 * @since                               25.12.13
 */
public class EngineContext {

    private GameObjectRepository gor;
    private GameState gs;

    public EngineContext(GameObjectRepository gor, GameState gs) {
        this.gor = gor;
        this.gs = gs;
    }

    public GameObjectRepository gameObjectManager() { return this.gor; }

    public GameState gameState() { return this.gs; }

    public SaveState saveState() { return SaveStateMapper.from(this.gs); }
}
