package backend;

// java import
import java.io.InputStream;
// custom import
import engine.Instance;

/**
 * @author                              o.le
 * @version                             0.5
 * @since                               0.8
 */
public final class TermiteSettings {

    private TermiteSettings() {}

    public static final InputStream DEFAULT_INPUT = System.in;

    public static Instance currentInstance;
}
