package engine.core.subsystems.save;

/**
 * @author 				o.le	
 * @version				1.0
 * @since				0.37
 */
public class SSFacade {
	
	private static final SaveSystem system = new SaveSystem();

	public static SaveSystem getSystem() { return system; }

	private SSFacade() { }
}
