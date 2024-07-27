package termite.backend;

// java import
import java.util.function.BiConsumer;

/**
 * This consumer add a uni directional connection between two instances. The
 * parent is the 'starting' point of the connection. So you can only move from
 * the parent to the child but <b>not</b> vice versa!
 * 
 * @author                              o.le
 * @version                             1.0
 * @since                               0.12
 */
public class UniDirectionalConnection implements BiConsumer<Instance, Instance> {

    @Override
    public void accept(Instance parent, Instance child) {
    
        parent.addNeighbor(child);
    }
}
