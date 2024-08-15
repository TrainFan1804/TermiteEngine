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

    public GameInstanceManager() {

        this.instances = new HashMap<>();
    }

    public void addInstance(Instance instance) {

        if (instance == null) throw new IllegalArgumentException();

        this.instances.put(instance.ID_INSTANCE, instance);
    }

    public Instance getInstanceById(int id) { return this.instances.get(id); }
}
