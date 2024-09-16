package engine.instance;

/**
 * @author o.le
 * @version 1.0
 * @since 1.2.6
 */
public class InstanceIdCounter {

	static boolean enabled = false;

	static final InstanceIdCounter ENTITY = new InstanceIdCounter();

	public static void enable() {

		if (!enabled) {

			enabled = true;
		} else {

			throw new IllegalStateException("Id counter can't be changed two times!");
		}
	}

	private int idCount;

	private InstanceIdCounter() {

		this.idCount = 0;
	}

	int getIdCount() { 
		
		if (enabled) return this.idCount++;

		throw new IllegalStateException("You need to activate the id counter first!");
	}
}
