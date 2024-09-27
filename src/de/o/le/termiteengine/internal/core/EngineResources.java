package de.o.le.termiteengine.internal.core;

import de.o.le.termiteengine.internal.GameCore;
import de.o.le.termiteengine.internal.core.service.InputService;
import de.o.le.termiteengine.internal.core.service.output.OuputContentHandler;
import de.o.le.termiteengine.internal.core.service.output.OutputService;

/**
 * @author o.le
 * @version 1.0
 * @since 1.3.1
 */
public class EngineResources {

	/**
	 * When using the resources just one-two times you can use this method
	 * directly. Other wise use {@link EngineResources#getInstance()}
	 * and create a field in your class.
	 */
	public static EngineResources INSTANCE;

	private static String pathToOutputContent = "resources/engine/output/default.json";

	public static final EngineResources getInstance() {

		return INSTANCE;
	}

	static final EngineResources createInstance(GameCore game) {

		if (INSTANCE == null) {

			INSTANCE = new EngineResources(game);
		}

		return INSTANCE;
	}

	public static final void changeOutputContentPath(String path) {

		pathToOutputContent = path;
	}

	public final GameCore GAME;
	public final InputService IN;
	public final OutputService OUT;
	private final GameInstanceSwitchTracker tracker;

	private EngineResources(GameCore game) {

		this.IN = new InputService();
		this.OUT = new OutputService();
		this.GAME = game;

		this.tracker = new GameInstanceSwitchTracker();

		this.initOutputContent();
	}

	/**
	 * This method is called to track if the current instance in {@link GameCore}
	 * changed. Don't use this because that could lead to unexpected behavior.
	 * <p>
	 * This is just used internally.
	 *
	 * @param changed 	Enter {@code true} if the instance was changed. Enter
	 * 			Enter {@code false} to set set to default.	
	 */
	public void setInstanceSwitch(boolean changed) {

		this.tracker.toggle(changed);
	}

	/**
	 * Will check if the current instance in {@link GameCore} was changed.
	 * Will also reset the status that was set with {@link EngineResources#setInstanceSwitch(boolean)}.
	 * 
	 * @return {@code true} if the instance was changed else {@code false}
	 */
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