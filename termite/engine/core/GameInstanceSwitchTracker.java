package engine.core;

/**
 * This class has a boolean value that will changed after the current instance the
 * player is in changed.
 * 
 * @author o.le
 * @version 1.0
 * @since 1.3.1
 */
class GameInstanceSwitchTracker {

	private boolean changed;

	GameInstanceSwitchTracker() {

		this.changed = false;
	}

	void toggle(boolean changed) { this.changed = changed; }

	boolean wasChanged() { return this.changed; }
}
