package de.o.le.termiteengine.api;

import de.o.le.termiteengine.engine.core.ApplicationCore;

/**
 * This class is the heart of the engine. After init everything for your game
 * call {@link Application#start()} to start the game.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.4.0-2
 */
public class Application {

	private final ApplicationCore CORE;

	public Application(Game game) {

		this.CORE = new ApplicationCore(game.getCore());
	}
	
	/**
	 * Will start the application.
	 */
	public void start() { this.CORE.start(); }
}
