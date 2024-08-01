package termite.backend.instances;

// java import
import java.util.Map;
import java.util.HashMap;
import java.util.function.BiConsumer;
// custom import
import termite.backend.utils.SameArgumentObjectException;

/**
 * @author                              o.le
 * @version                             0.5
 * @since                               0.12
 */
public class InstanceManager {

    private Map<Integer, Instance> instances;

    public InstanceManager() {

        this.instances = new HashMap<>();
    }

    /**
     * Get the instance by it's name.
     * 
     * @param id                        The id of the instance. Can't be 
     *                                  below 0.
     * @return                          The instance with the given name. When
     *                                  there is no instance with the given id
     *                                  return {@code null}.
     */
    public Instance getInstance(int id) {

        if (id < 0) {

            throw new IllegalArgumentException("Argument can't be below 0");
        }

        return this.instances.get(id);
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

        this.instances.put(newInstance.getID(), newInstance);
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
