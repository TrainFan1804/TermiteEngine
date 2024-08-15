package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Game {

    private GameInstanceManager instanceManger;

    public Game(GameInstanceManager instanceManager) {
        
        this.instanceManger = instanceManager;
    }

    public GameInstanceManager getInstanceManger() { return this.instanceManger; }
}
