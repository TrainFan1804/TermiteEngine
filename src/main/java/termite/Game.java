package termite;

import termite.instance.Instance;

import java.util.Map;
import java.util.HashMap;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.25
 */
public class Game {

    private class GameInstanceManager {

        private Map<Integer, Instance> instances;

        public GameInstanceManager() {

            this.instances = new HashMap<>();
        }

        /**
         * Add a new instance to the instance manager.
         * <p>
         * CAUTION: The first instance that is added is the starting instance!
         * 
         * @param instance                  The new instance.
         */
        public void addInstance(Instance instance) {

            if (instance == null) throw new IllegalArgumentException("Instance can't be null!");

            if (this.instances.isEmpty()) currentInstance = instance;

            this.instances.put(instance.ID_INSTANCE, instance);
        }

        public Instance getInstanceById(int id) {

            if (!this.instances.containsKey(id)) {
                
                throw new IllegalArgumentException("The provided id doesn't exist!");  // Null pattern
            }

            return this.instances.get(id);
        }
    }

    private GameInstanceManager manager;

    private Instance currentInstance;

    public Game() {

        this.manager = new GameInstanceManager();
    }

    public Instance getCurrentInstance() { return this.currentInstance; }

    public void setCurrentInstance(int id) { this.currentInstance = this.manager.getInstanceById(id); }

    public void addInstance(Instance instance) { this.manager.addInstance(instance); }

    public Instance getInstanceById(int id) { return this.manager.getInstanceById(id); }

}
