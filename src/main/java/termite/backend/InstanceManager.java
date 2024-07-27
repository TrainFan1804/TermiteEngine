package termite.backend;

// java import
import java.util.function.BiConsumer;
import java.util.Map;
import java.util.HashMap;
// custom import
import termite.backend.utils.SameArgumentObjectException;

/**
 * @author                              o.le
 * @version                             0.4
 * @since                               0.12
 */
public class InstanceManager {

    private Map<String, Instance> instances;

    public InstanceManager() {

        this.instances = new HashMap<>();
    }

    /**
     * Get the instance by it's name.
     * 
     * @param name                      The name of the instance. Can't be 
     *                                  {@code null}.
     * @return                          The instance with the given name. When
     *                                  there is no instance with the given name
     *                                  return {@code null}.
     */
    public Instance getInstance(String name) {

        if (name == null) {

            throw new IllegalArgumentException("Argument can't be null");
        }

        return this.instances.get(name);
    }

    /**
     * Add a new instance <b>without</b> without creating a connection 
     * between two instances.
     * 
     * @param newInstance               The new instance. Can't be {@code null}.
     */
    public void addInstance(Instance newInstance) {

        if (newInstance == null) {

            throw new IllegalArgumentException("Argument can't be null!");
        }

        this.instances.put(newInstance.getName(), newInstance);
    }

    /**
     * Add two different instances to the manager with adding a connection
     * between two instances. All arguments can't be {@code null}. Use
     * {@link BiDirectionalConnection} and {@link UniDirectionalConnection} to
     * create to seperate ways to create a connection.
     * 
     * @param first                     The first instance that is added.
     * @param second                    The second instance that is added.
     * @param connection                The type of the connection.
     */
    public void addInstanceConnection(
                Instance first, Instance second, 
                BiConsumer<Instance, Instance> connection) {

        if (first == null || second == null || connection == null) {

            throw new IllegalArgumentException("Arguments can't be null!");
        }

        if (first == second) {

            throw new SameArgumentObjectException();
        }

        this.addInstance(first);
        this.addInstance(second);
        connection.accept(first, second);
    }
}
