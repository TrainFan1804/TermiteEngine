package termite.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public class GoEvent extends InstanceEvent {

    private IGo go;

    public GoEvent(IGo go) {

        super(InstanceEventType.GO_EVENT);
        this.go = go;
    }

    @Override
    public void startEvent() { this.go.go(); }
}
