package de.o.le.termiteengine.engine.core.subsystem.exit;

/**
 * This class is a facade to the inside of the exit subsystem.
 * 
 * @author 				o.le
 * @version 				2.0
 * @since 				0.37
 */
public final class EXSFacade {
	
	private static final ExitSystem system = new ExitSystem();

	/**
	 * Get access to the inside of the subsystem.
	 * 
	 * @return The inside of the subsystem.
	 */
	public static ExitSystem getSystem() { return system; }
	
	/**
	 * Private constructor.
	 */
	private EXSFacade() { }
}
