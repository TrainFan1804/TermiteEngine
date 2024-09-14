package engine.core.subsystems.filesystem.utils;

/**
 * @author 								o.le
 * @version 							1.0
 * @since								0.47
 */
@Deprecated(since = "1.1.1", forRemoval = true)
public class NoOverrideException extends Exception {

	public NoOverrideException() { super("End save process, Returning to game."); }
}
