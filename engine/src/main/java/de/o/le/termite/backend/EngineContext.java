package de.o.le.termite.backend;

import java.io.FileNotFoundException;

/**
 * This class is containing different manager that are needed in the engine itself.
 * Currently only the {@link GameObjectManager} is wrapped inside that class.
 *
 * @author                              o.le
 * @version                             2.0
 * @since                               25.12.13
 */
public class EngineContext {

    private static EngineContext INSTANCE;

    private GameObjectManager gom;
    private CommandRegistry cr;

    public EngineContext(GameObjectManager gom, CommandRegistry cr) {
        this.gom = gom;
        this.cr = cr;
    }

    public GameObjectManager gameObjectManager() { return this.gom; }

    public CommandRegistry commandRegistry() { return this.cr; }
}
