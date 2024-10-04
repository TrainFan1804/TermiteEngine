package de.o.le.termiteengine.engine.core;

/**
 * This class has a boolean value that will changed after the current instance the
 * player is in changed.
 * <p>
 * TODO this is a very ugly class.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.3.1
 */
class GameInstanceSwitchTracker {

	private boolean changed;

	/**
	 * This class is just use in this package to the constructor is package
	 * default.
	 */
	GameInstanceSwitchTracker() {

		this.changed = true;	// set true on init because when starting
					// the game instance message should be
					// printed
	}

	/**
	 * Will set the state of the inner value to the given argument.
	 * 
	 * @param changed New value of the innser state.
	 */
	void toggle(boolean changed) { this.changed = changed; }

	/**
	 * Get the value of the inner value.
	 * 
	 * @return The value of the inner value.
	 */
	boolean wasChanged() { return this.changed; }
}
