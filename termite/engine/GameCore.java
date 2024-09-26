package engine;

import engine.core.EngineResources;
import engine.instance.Instance;

/**
 * This class represent the core of the game. 
 * 
 * @author                              o.le
 * @version                             1.1
 * @since                               0.25
 */
public class GameCore {

	Instance currentInstance;
    	private final GameInstanceManager manager;

    	public GameCore() {

        	this.manager = new GameInstanceManager(this);
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
