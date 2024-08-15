package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public abstract class LeaveEvent extends InstanceEvent {

    protected LeaveEvent() {

        super(EventType.LEAVE_EVENT);
    }

    @Override
    public void startEvent() {

        this.leave();
    }

    public abstract void leave();
}
