package engine.utils;

// custom import
import engine.Instance;

/**
 * This is a marker interface that marker the {@link Instance} that should be
 * the end screen.
 * <p>
 * <b>CAUTION:</b> The instance that implement this interface will execute the 
 * {@link Instance#enter()} method <b>one</b> more time.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.5
 */
public interface EndInstance {}
