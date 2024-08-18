package termite.instance.event;

import termite.instance.EventIdNotPresentException;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.20
 * @deprecated                          Is replaced by {@link EventIdNotPresentException}
 */
@Deprecated(since = "0.30")
class NullEvent extends InstanceEvent {

    public NullEvent() {

        super(null);
    }

    @Override
    public void startEvent() { System.out.println("Event is not supported"); }
}
