package engine.core.subsystems.help;

/**
 * @author				o.le
 * @version 				1.0
 * @since 				0.37
 */
public class HSFacade {
	
	private static final HelpSystem system = new HelpSystem();

	public static HelpSystem getSystem() { return system; }

	private HSFacade() { }
}
