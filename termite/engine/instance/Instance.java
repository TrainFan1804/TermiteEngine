package engine.instance;

import engine.core.services.output.Message;
import engine.instance.event.InstanceEvent;
import engine.instance.event.NullEvent;
import java.util.Map;

/**
 * @author                              o.le
 * @version                             1.3
 * @since                               0.17
 */
public class Instance {

    	public final int ID_INSTANCE;
    
    	private final Message instanceMessage;
    	private final InstanceEventHandler eventHandler;
	private final Map<Integer, InstanceEvent> events;

    	private Instance nextInstance;
    	private Instance preInstance;

	Instance(InstanceBuilderCore builder) {

		this.ID_INSTANCE = builder.id;
		this.instanceMessage = builder.msg;
		this.nextInstance = builder.next;
		this.preInstance = builder.prev;
		this.events = builder.events;

		this.eventHandler = null;
	}

    public Instance(int id) {

        this.ID_INSTANCE = id;
        this.eventHandler = new InstanceEventHandler(this);

	this.events = null;
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
    @Deprecated
    public void setNextInstance(Instance nexInstance) { this.nextInstance = nexInstance; }

    public Instance getPreInstance() { return this.preInstance; }

    /**
     * TODO see setNextInstance(Instance).
     */
    @Deprecated
    public void setPreInstance(Instance preInstance) { this.preInstance = preInstance; }

    @Deprecated
    public void addEvent(InstanceEvent event) { this.eventHandler.addEvent(event); }
    
    public InstanceEvent getEventById(int id) {
        
        return this.events.getOrDefault(id, new NullEvent());
    }
    
    public Message display() { return this.instanceMessage; }
}
