package de.o.le.termiteengine.engine.core.subsystem.save;

/**
 * @author 				o.le	
 * @version				2.0
 * @since				0.37
 */
public final class SSFacade {
	
	private static final SaveSystem system = new SaveSystem();

	public static SaveSystem getSystem() { return system; }

	private SSFacade() { }
}
