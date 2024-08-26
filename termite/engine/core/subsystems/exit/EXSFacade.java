package engine.core.subsystems.exit;

/**
 * @author 				o.le
 * @version 				1.0
 * @since 				0.37
 */
public class EXSFacade {
	
	private static final ExitSystem system = new ExitSystem();

	public static ExitSystem getSystem() { return system; }

	private EXSFacade() { }
}
