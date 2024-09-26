package api;

import engine.core.ApplicationCore;

/**
 * @author o.le
 * @version 1.0
 * @since 1.4.0-2
 */
public class Application {

	private final ApplicationCore CORE;

	public Application(Game game) {

		this.CORE = new ApplicationCore(game.getCore());
	}

	public void start() { this.CORE.start(); }
}
