package engine.core;

/**
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
