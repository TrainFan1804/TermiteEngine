package termite.backend;

// java import
import java.util.List;
import java.util.LinkedList;

/**
 * @author                              o.le
 * @version                             0.6
 * @since                               0.12
 */
public abstract class Instance implements Displayable {

    private final int ID;
    private List<Instance> neighbors;
    private Message message;

    protected Instance(int id) {

        this(id, null); // TODO change to dummy message
    }
    
    protected Instance(int id, Message message) {
        
        this.ID = id;
        this.neighbors = new LinkedList<>();
        this.message = message;
    }

    /**
     * Add a new neighbor to the instance. Each neighbor represent an instance 
     * the user can move to from the current instance.
     * <p>
     * The visibility of this method could change in future versions.
     * 
     * @param neighbor                  A new neighbor.
     */
    void addNeighbor(Instance neighbor) {

        this.neighbors.add(neighbor);
    }

    /**
     * Get a list of all neighbors.
     * 
     * @return                          The list of the neighbors.
     */
    public List<Instance> getNeighborList() {

        return this.neighbors;
    }

    /**
     * Get the ID of the instance. The ID is a special number for the instance.
     * Each instance type should have a unique ID.
     * 
     * @return                          The ID of the instance.
     */
    public int getID() {

        return this.ID;
    }

    @Override
    public Message display() {
        
        return this.message;
    }
}
