package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class Game {

    private InstanceManager instanceManger;

    public Game(InstanceManager instanceManager) { 
        
        this.instanceManger = instanceManager;
    }

    public InstanceManager getInstanceManger() { return this.instanceManger; }
}
