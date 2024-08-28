package engine.core.subsystems.load;

/**
 * @author 				o.le
 * @version 				1.0
 * @since				0.37
 */
public class LSFacade {
	
	private static final LoadSystem system = new LoadSystem();
	
	public static LoadSystem getSystem() { return system; }

	private LSFacade() { }
}
