package de.o.le.termite.engine.core.subsystem.save;

/**
 * This class is a facade to the inside of the save subsystem.
 * 
 * @author 				o.le	
 * @version				2.0
 * @since				0.37
 */
public final class SSFacade {
	
	private static final SaveSystem system = new SaveSystem();

	/**
	 * Get access to the inside of the subsystem.
	 * 
	 * @return The inside of the subsystem.
	 */
	public static SaveSystem getSystem() { return system; }

	/**
	 * Private constructor.
	 */
	private SSFacade() { }
}
