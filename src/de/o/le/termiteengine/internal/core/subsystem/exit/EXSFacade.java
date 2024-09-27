package de.o.le.termiteengine.internal.core.subsystem.exit;

/**
 * @author 				o.le
 * @version 				2.0
 * @since 				0.37
 */
public final class EXSFacade {
	
	private static final ExitSystem system = new ExitSystem();

	public static ExitSystem getSystem() { return system; }

	private EXSFacade() { }
}
