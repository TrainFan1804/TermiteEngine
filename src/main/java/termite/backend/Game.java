package termite.backend;

import termite.backend.instances.Instance;
import termite.backend.instances.InstanceManager;

/**
 * @author                              o.le
 * @version                             0.1
 * @since                               0.12
 */
public abstract class Game {

    protected final InstanceManager manager;
    protected Instance currentInstance;

    protected Game(InstanceManager manager) {

        this.manager = manager;
    }

    public Instance getCurrentInstance() {

        return this.currentInstance;
    }

    public abstract void init();
}
