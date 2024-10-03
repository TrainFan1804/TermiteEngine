package de.o.le.termiteengine.engine.core.subsystem.load;

/**
 * @author 				o.le
 * @version 				2.0
 * @since				0.37
 */
public final class LSFacade {
	
	private static final LoadSystem system = new LoadSystem();
	
	public static LoadSystem getSystem() { return system; }

	private LSFacade() { }
}
