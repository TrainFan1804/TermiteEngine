package engine.core;

import engine.Game;
import engine.core.services.InputService;
import engine.core.services.output.OuputContentHandler;
import engine.core.services.output.OutputService;

/**
 * @author o.le
 * @version 1.0
 * @since 1.3.1
 */
public class ApplicationResourcesSingleton {

	/**
	 * When using the resources just one-two times you can use this method
	 * directly. Other wise use {@link ApplicationResourcesSingleton#getInstance()}
	 * and create a field in your class.
	 */
	public static ApplicationResourcesSingleton INSTANCE;

	private static String pathToOutputContent = "resources/engine/output/default.json";

	public static final ApplicationResourcesSingleton getInstance() {

		return INSTANCE;
	}

	static final ApplicationResourcesSingleton createInstance(Game game) {

		if (INSTANCE == null) {

			INSTANCE = new ApplicationResourcesSingleton(game);
		}

		return INSTANCE;
	}

	public static final void changeOutputContentPath(String path) {

		pathToOutputContent = path;
	}

	public final Game GAME;
	public final InputService IN;
	public final OutputService OUT;
	private final GameInstanceSwitchTracker tracker;

	private ApplicationResourcesSingleton(Game game) {

		this.IN = new InputService();
		this.OUT = new OutputService();
		this.GAME = game;

		this.tracker = new GameInstanceSwitchTracker();

		this.initOutputContent();
	}

	public void setInstanceSwitch(boolean changed) {

		this.tracker.toggle(changed);
	}

	boolean wasInstanceSwitch() {

		boolean temp = this.tracker.wasChanged();
		if (temp) {

			this.setInstanceSwitch(false);
		}

		return temp;
	}

	private void initOutputContent() {

		OuputContentHandler.init(pathToOutputContent);
	}
}