package engine.api;

import engine.core.EngineResources;
import engine.instance.Instance;
import engine.instance.exceptions.DuplicateInstanceIdException;
import java.util.Map;
import java.util.HashMap;

/**
 * This class represent your game. 
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.25
 */
public class Game {

    private class GameInstanceManager {

        private final Map<Integer, Instance> instances;

        private GameInstanceManager() {

            this.instances = new HashMap<>();
        }

        /**
         * Add a new instance to the instance manager.
         * <p>
         * CAUTION: The first instance that is added is the starting instance!
         * 
         * @param instance                  The new instance.
         */
        private void addInstance(Instance instance) {

            if (instance == null) throw new IllegalArgumentException("Instance can't be null!");

            if (this.instances.isEmpty()) Game.this.currentInstance = instance;

			int id = instance.ID_INSTANCE;
			if (this.instances.containsKey(id)) throw new DuplicateInstanceIdException(id);

            this.instances.put(instance.ID_INSTANCE, instance);
        }

        private Instance getInstanceById(int id) {

            if (!this.instances.containsKey(id)) {
                
                throw new IllegalArgumentException("The provided id doesn't exist!");
            }

            return this.instances.get(id);
        }
    }

    private final GameInstanceManager manager;

    private Instance currentInstance;

    public Game() {

        this.manager = new GameInstanceManager();
    }

    public Instance getCurrentInstance() { return this.currentInstance; }

	public int getCurrentInstanceId() { return this.currentInstance.ID_INSTANCE; }

    public void setCurrentInstance(int id) { 
	    
	    this.currentInstance = this.manager.getInstanceById(id); 
	    EngineResources.INSTANCE.setInstanceSwitch(true);
    }

    public void addInstance(Instance instance) { this.manager.addInstance(instance); }

    public Instance getInstanceById(int id) { return this.manager.getInstanceById(id); }
}
