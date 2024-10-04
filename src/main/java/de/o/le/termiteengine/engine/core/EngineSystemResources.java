package de.o.le.termiteengine.engine.core;

import de.o.le.termiteengine.engine.util.ToBeImplemented;

/**
 * This class contains some important fields / methods that are used in the entire
 * engine regular. You shouldn't use any of this fields / methods because this 
 * could lead to unexpected behavior.
 * <p>
 * Input and Output resources are separate in {@link EngineInputResource} and
 * {@link EngineOutputResource}.
 * 
 * @author o.le
 * @version 1.1
 * @since 1.3.1
 */
@ToBeImplemented(message = "With the public api update I should hide this class"
	+ " entirely because this is very dangerous")
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

	/**
	 * Because this class is designed as a singleton you can get the instance
	 * with this method.
	 * <p>
	 * Will throw a exception when not calling 
	 * {@link EngineSystemResources#createInstance(GameCore)} first.
	 * 
	 * 
	 * @return The saved instance.
	 */
	public static final EngineSystemResources getInstance() {

		if (INSTANCE == null) throw new IllegalStateException("Instance"
			+ " wasn't created yet. First call EngineSystemResouces#createInstance(GameCore)."
			+ " Should be happen automaticly after creating a Application object.");

		return INSTANCE;
	}

	/**
	 * Create a instance.
	 * 
	 * @param game The EngineSystemResource need a {@link GameCore} to work
	 * properly.
	 */
	static final void createInstance(GameCore game) {

		if (INSTANCE == null) INSTANCE = new EngineSystemResources(game);
	}

	/**
	 * Access the saved game.
	 */
	public final GameCore GAME;
	private final GameInstanceSwitchTracker tracker;

	/**
	 * A private constructor.
	 */
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