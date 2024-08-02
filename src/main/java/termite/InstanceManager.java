package termite;

import java.util.Map;
import java.util.HashMap;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class InstanceManager {

    private Map<Integer, Instance> instances;

    public InstanceManager() {

        this.instances = new HashMap<>();
    }

    public void addInstance(Instance instance) {

        if (instance == null) throw new IllegalArgumentException();

        this.instances.put(instance.ID_INSTANCE, instance);
    }

    public Instance getInstanceById(int id) { return this.instances.get(id); }
}
