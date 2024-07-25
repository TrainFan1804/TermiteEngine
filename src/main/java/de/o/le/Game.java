package de.o.le;

/**
 * A game contains everything the user needs during the course of the game no
 * matter where he is. Things that the user may need during the game are:
 * <p>
 * - {@link PlayerCharacter}
 * <p>
 * - {@link Inventory}
 * 
 * @author                              o.le
 * @version                             0.4
 * @since                               0.1
 */
public abstract class Game {

    protected Instance instance;

    /**
     * This method is the entry point to the game itself. In this method you
     * create everything that is used in the game through the whole game process.
     */
    public abstract void create();

    /**
     * Get the {@link Instance} the game is currently in.
     * 
     * @return                          The current instance.
     */
    public Instance getInstance() {

        return this.instance;
    }

    /**
     * Set the {@link Instance} the game should be in after the execution.
     * 
     * @param instance                  The new instance.
     */
    public void setInstance(Instance instance) {

        this.instance = instance;
    }
}
