package termite.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public class UseEvent extends InstanceEvent {

    private IUse use;

    public UseEvent(IUse use) {

        super(InstanceEventType.USE_EVENT);
        this.use = use;
    }

    @Override
    public void startEvent() { this.use.use(); }
}
