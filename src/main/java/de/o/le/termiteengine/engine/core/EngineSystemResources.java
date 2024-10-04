package de.o.le.termiteengine.engine.core;

/**
 * @author o.le
 * @version 1.1
 * @since 1.3.1
 */
public class EngineSystemResources {

	/**
	 * When using the resources just one-two times you can use this method
	 * directly. Other wise use {@link EngineSystemResources#getInstance()}
	 * and create a field in your class.
	 * <p>
	 * @deprecated Will be made private in a future version so use
	 * {@link EngineResources#getInstance()} instead!
	 */
	@Deprecated
	public static EngineSystemResources INSTANCE;

	public static final EngineSystemResources getInstance() {

		return INSTANCE;
	}

	static final void createInstance(GameCore game) {

		if (INSTANCE == null) INSTANCE = new EngineSystemResources(game);
	}

	public final GameCore GAME;
	private final GameInstanceSwitchTracker tracker;

	private EngineSystemResources(GameCore game) {

		this.GAME = game;

		this.tracker = new GameInstanceSwitchTracker();
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
	 * Will also reset the status that was set with {@link EngineSystemResources#setInstanceSwitch(boolean)}.
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
}