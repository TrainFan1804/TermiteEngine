package termite;


/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public abstract class UseEvent extends  InstanceEvent {

    protected UseEvent() {

        super(EventType.USE_EVENT);
    }

    @Override
    public void startEvent() {

        this.use();
    }

    public abstract void use();
}
