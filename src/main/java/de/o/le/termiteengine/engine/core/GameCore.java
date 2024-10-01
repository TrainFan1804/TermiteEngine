package de.o.le.termiteengine.engine.core;

import de.o.le.termiteengine.engine.instance.InstanceCore;
import de.o.le.termiteengine.engine.instance.exception.DuplicateInstanceIdException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent the core of the game.
 * 
 * @author                              o.le
 * @version                             1.2
 * @since                               0.25
 */
public final class GameCore {

	InstanceCore currentInstance;
    	private final Map<Integer, InstanceCore> manager;

    	public GameCore() {

        	this.manager = new HashMap<>();
    	}

    	public InstanceCore getCurrentInstance() { return this.currentInstance; }

	public int getCurrentInstanceId() { return this.currentInstance.ID_INSTANCE; }

	/**
	 * TODO this isn't very good because that can lead to errors during runtime
	 * when the developer use {@link InstanceCore#setNextInstance(de.o.le.termiteengine.engine.instance.InstanceCore)} 
	 * or {@link InstanceCore#setPreInstance(de.o.le.termiteengine.engine.instance.InstanceCore)}
	 * without adding the instance with {@link GameCore#addInstance(de.o.le.termiteengine.engine.instance.InstanceCore)}
	 * 
	 * @param id 
	 */
    	public void setCurrentInstance(int id) { 
	    
	    	this.currentInstance = this.getInstanceById(id); 
	    	EngineResources.INSTANCE.setInstanceSwitch(true);
    	}

	/**
	 * Add a new instance to the instance manager.
	 * <p>
	 * CAUTION: The first instance that is added is the starting instance!
	 *
	 * @param instance The new instance.
	 */
    	public void addInstance(InstanceCore instance) { 

		if (instance == null)
			throw new IllegalArgumentException("Instance can't be null!");

		if (this.manager.isEmpty())
			this.currentInstance = instance;

		final int id = instance.ID_INSTANCE;

		if (this.manager.containsKey(id))
			throw new DuplicateInstanceIdException(id);
		
		this.manager.put(id, instance); 
	}

    	public InstanceCore getInstanceById(int id) { 

		if (!this.manager.containsKey(id))
			throw new IllegalArgumentException("The provided id doesn't exist!");
		
		return this.manager.get(id); 
	}
}
