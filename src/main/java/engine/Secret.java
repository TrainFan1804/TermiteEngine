package engine;

/**
 * A secret is a hidden object in the {@link Instance} that must be found by 
 * the {@code SEARCH} command.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.1
 */
public abstract class Secret {

    /**
     * Expose the secret.
     */
    public abstract void expose();
}
