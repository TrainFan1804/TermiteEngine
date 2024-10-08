package de.o.le.termite.api;

/**
 * When creating a {@link Instance} with the {@link InstanceBuilder} you need to
 * set a unique id for each instance. You must manage those id's by yourself.
 * <p>
 * If you don't want to manage the id's you can use this class. This class will
 * count the id's for you. The counter will count from 0.
 * <p>
 * <b>Caution</b>: You should decide at the beginning if you want to handle the
 * id's by your own or use this counter class. Mixing both methods will lead
 * to unexpected behavior!
 * 
 * @author o.le
 * @version 1.1
 * @since 1.2.6
 */
public class InstanceIdCounter {

	/**
	 * This class is designed as a singleton so you can use this field
	 * multiple times in your program without need to worry about any
	 * unexpected id's.
	 */
	public static final InstanceIdCounter ENTITY = new InstanceIdCounter();

	private static boolean enabled = false;

	/**
	 * You need to enable the counter first to use the counter.
	 * <p>
	 * <b>Caution</b>: You can't disable the counter after enabled id once!
	 */
	public static void enable() {

		if (!enabled) {

			enabled = true;
		} else {

			throw new IllegalStateException("Id counter can't be changed two times!");
		}
	}

	private int idCount;

	/**
	 * Create a new counter instance. Will only be called once.
	 */
	private InstanceIdCounter() {

		this.idCount = 0;
	}

	/**
	 * Will return the new id.
	 * 
	 * @return The id that is set to the instance.
	 */
	int getIdCount() { 
		
		if (enabled) return this.idCount++;

		throw new IllegalStateException("You need to activate the id counter first!");
	}
}
