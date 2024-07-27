package termite.backend;

// java import
import java.util.function.BiConsumer;

/**
 * This consumer add a bi directional connection between two instances.
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.12
 */
public class BiDirectionalConnection implements BiConsumer<Instance, Instance> {

    @Override
    public void accept(Instance parent, Instance child) {
        
        parent.addNeighbor(child);
        child.addNeighbor(parent);
    }
}
