package de.o.le.termite.engine.core.subsystem.load;

/**
 * This class is a facade to the inside of the load subsystem.
 * 
 * @author 				o.le
 * @version 				2.0
 * @since				0.37
 */
public final class LSFacade {
	
	private static final LoadSystem system = new LoadSystem();
	
	/**
	 * Get access to the inside of the subsystem.
	 * 
	 * @return The inside of the subsystem.
	 */
	public static LoadSystem getSystem() { return system; }

	/**
	 * Private constructor.
	 */
	private LSFacade() { }
}
