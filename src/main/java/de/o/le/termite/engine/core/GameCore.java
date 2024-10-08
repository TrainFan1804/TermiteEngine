package de.o.le.termite.engine.core;

import de.o.le.termite.engine.instance.InstanceCore;
import de.o.le.termite.engine.instance.exception.DuplicateInstanceIdException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent the core of the game. Contains all the logic of the
 * game itself like Instance management, etc.
 * 
 * @author                              o.le
 * @version                             1.2
 * @since                               0.25
 */
public final class GameCore {

	InstanceCore currentInstance;
    	private final Map<Integer, InstanceCore> manager;

	/**
	 * Create a GameCore instance.
	 */
    	public GameCore() {

        	this.manager = new HashMap<>();
    	}

	/**
	 * Get the instance the player is currently in.
	 * 
	 * @return The current instance.
	 */
    	public InstanceCore getCurrentInstance() { return this.currentInstance; }

	/**
	 * To get easy access to the id of the current instance you can use this
	 * instance.
	 * 
	 * @return The id of the current instance.
	 */
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
	    	EngineSystemResources.INSTANCE.setInstanceSwitch(true);
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

	/**
	 * Get a instance by a given id.
	 * 
	 * @param id The id of the wanted instance.
	 * @return The instance that is associated with the given id. Will throw
	 * an exception when enter a id that isn't in the game.
	 */
    	public InstanceCore getInstanceById(int id) { 

		if (!this.manager.containsKey(id))
			throw new IllegalArgumentException("The provided id doesn't exist!");
		
		return this.manager.get(id); 
	}
}
