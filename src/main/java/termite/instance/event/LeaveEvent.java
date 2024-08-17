package termite.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public class LeaveEvent extends InstanceEvent {

    private ILeave leave;

    public LeaveEvent(ILeave leave) {

        super(InstanceEventType.LEAVE_EVENT);
        this.leave = leave;
    }

    @Override
    public void startEvent() { this.leave.leave(); }
}
