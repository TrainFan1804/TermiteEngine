package engine;

import engine.instance.InstanceCore;
import engine.instance.exceptions.DuplicateInstanceIdException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class was extracted from the {@link GameCore} class.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-2
 */
class GameInstanceManager {

	private final GameCore MASTER;
	private final Map<Integer, InstanceCore> INSTANCES;

	GameInstanceManager(GameCore game) {

		this.MASTER = game;
		this.INSTANCES = new HashMap<>();
	}


	/**
	 * Add a new instance to the instance manager.
	 * <p>
	 * CAUTION: The first instance that is added is the starting instance!
	 *
	 * @param instance The new instance.
	 */
	void addInstance(InstanceCore instance) {

		if (instance == null) {
			throw new IllegalArgumentException("Instance can't be null!");
		}

		if (this.INSTANCES.isEmpty()) {
			this.MASTER.currentInstance = instance;
		}

		int id = instance.ID_INSTANCE;
		if (this.INSTANCES.containsKey(id)) {
			throw new DuplicateInstanceIdException(id);
		}

		this.INSTANCES.put(instance.ID_INSTANCE, instance);
	}

	InstanceCore getInstanceById(int id) {

		if (!this.INSTANCES.containsKey(id)) {

			throw new IllegalArgumentException("The provided id doesn't exist!");
		}

		return this.INSTANCES.get(id);
	}
}
