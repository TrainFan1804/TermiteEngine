package de.o.le.termiteengine.api;

import de.o.le.termiteengine.engine.core.GameCore;

/**
 * This class represent your game. A game can have multiple {@link Instance} that.
 * The player is always in one instance and can be navigate through the instance
 * with the commands that are defined by the engine.
 * <p>
 * Instances must be build via the {@link InstanceBuilder}.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-1
 */
public class Game {

	private final GameCore CORE;

	/**
	 * Will create a new game. The created game is empty.
	 */
	public Game() {

		this.CORE = new GameCore();
	}

	/**
	 * Will add a new instance to your game.
	 * 
	 * @param newInstance The added instance.
	 */
	public void addInstance(Instance newInstance) {

		this.CORE.addInstance(newInstance.getCore());
	}

	/**
	 * Because this class is just a facade for the {@link GameCore} the 
	 * {@link Application} this is just a package private method.
	 * 
	 * @return The core that is saved in this object.
	 */
	GameCore getCore() { return this.CORE; }
}
