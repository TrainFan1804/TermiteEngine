package de.o.le.termiteengine.engine.core.subsystem.help;

/**
 * This class is a facade to the inside of the help subsystem.
 * 
 * @author				o.le
 * @version 				2.0
 * @since 				0.37
 */
public final class HSFacade {
	
	private static final HelpSystem system = new HelpSystem();

	/**
	 * Get access to the inside of the subsystem.
	 * 
	 * @return The inside of the subsystem.
	 */
	public static HelpSystem getSystem() { return system; }

	/**
	 * Private constructor.
	 */
	private HSFacade() { }
}
