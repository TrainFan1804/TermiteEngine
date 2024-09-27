package engine;

import engine.core.EngineResources;
import engine.instance.InstanceCore;

/**
 * This class represent the core of the game.
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.25
 */
public class GameCore {

	InstanceCore currentInstance;
    	private final GameInstanceManager manager;

    	public GameCore() {

        	this.manager = new GameInstanceManager(this);
    	}

    	public InstanceCore getCurrentInstance() { return this.currentInstance; }

	public int getCurrentInstanceId() { return this.currentInstance.ID_INSTANCE; }

    	public void setCurrentInstance(int id) { 
	    
	    	this.currentInstance = this.manager.getInstanceById(id); 
	    	EngineResources.INSTANCE.setInstanceSwitch(true);
    	}

    	public void addInstance(InstanceCore instance) { this.manager.addInstance(instance); }

    	public InstanceCore getInstanceById(int id) { return this.manager.getInstanceById(id); }
}
