package de.o.le.termiteengine.api;

import de.o.le.termiteengine.engine.core.GameCore;

/**
 * This class represent your game. 
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-1
 */
public class Game {

	private final GameCore CORE;

	public Game() {

		this.CORE = new GameCore();
	}

	public void addInstance(Instance newInstance) {

		this.CORE.addInstance(newInstance.getCore());
	}

	GameCore getCore() { return this.CORE; }
}
