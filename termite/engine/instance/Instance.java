package engine.instance;

import engine.core.services.output.Message;
import engine.instance.event.InstanceEvent;

/**
 * @author                              o.le
 * @version                             1.2
 * @since                               0.17
 */
public class Instance {

    	public final int ID_INSTANCE;
    
    	private final Message instanceMessage;
    	private final InstanceEventHandler eventHandler;

    	private Instance nextInstance;
    	private Instance preInstance;

    public Instance(int id) {

        this.ID_INSTANCE = id;
        this.eventHandler = new InstanceEventHandler(this);

		// TODO this need to be variable via JSON!
        this.instanceMessage = new Message("You enter: " + this);
    }

	/**
	 * Don't use this. You should get the id via the public field
	 * {@link Instance#ID_INSTANCE}
	 */
	@Deprecated(since = "1.2.6")
	public int getID() { return this.ID_INSTANCE; }

    public Instance getNextInstance() { return this.nextInstance; }

    /**
     * TODO should handle some error like put the same instance, nextinstance 
     * already exists and so on.
     */
    public void setNextInstance(Instance nexInstance) { this.nextInstance = nexInstance; }

    public Instance getPreInstance() { return this.preInstance; }

    /**
     * TODO see setNextInstance(Instance).
     */
    public void setPreInstance(Instance preInstance) { this.preInstance = preInstance; }

    public void addEvent(InstanceEvent event) { this.eventHandler.addEvent(event); }
    
    public InstanceEvent getEventById(int id) {
        
        return this.eventHandler.getEventById(id); 
    }
    
    public Message display() { return this.instanceMessage; }
}
