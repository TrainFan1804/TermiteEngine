package termite;

import termite.instance.Instance;

import java.util.Map;
import java.util.HashMap;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class GameInstanceManager {

    private Map<Integer, Instance> instances;

    private Instance currentInstance;

    public GameInstanceManager() {

        this.instances = new HashMap<>();
    }

    public Instance getCurrentInstance() { return this.currentInstance; }

    public void setCurrentInstance(Instance instance) { this.currentInstance = instance; }

    /**
     * Add a new instance to the instance manager.
     * <p>
     * CAUTION: The first instance that is added is the starting instance!
     * 
     * @param instance                  The new instance.
     */
    public void addInstance(Instance instance) {

        if (instance == null) throw new IllegalArgumentException();

        if (this.instances.isEmpty()) this.currentInstance = instance;

        this.instances.put(instance.ID_INSTANCE, instance);
    }

    public Instance getInstanceById(int id) { return this.instances.get(id); }
}
