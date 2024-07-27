package termite.backend;

// java import
import java.util.List;
import java.util.LinkedList;

/**
 * @author                              o.le
 * @version                             0.3
 * @since                               0.12
 */
public abstract class Instance {

    private String name;
    private List<Instance> neighbors; 

    protected Instance(String name) {

        this.name = name;
        this.neighbors = new LinkedList<>();
    }

    void addNeighbor(Instance neighbor) {

        this.neighbors.add(neighbor);
    }

    public List<Instance> getNeighborList() {

        return this.neighbors;
    }

    public String getName() {

        return this.name;
    }

    @Override
    public String toString() {
    
        return this.name;
    }
}
