package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public abstract class GoEvent extends InstanceEvent {

    protected GoEvent() {

        super(EventType.GO_EVENT);
    }

    @Override
    public void startEvent() {

        this.go();
    }

    public abstract void go();
}
