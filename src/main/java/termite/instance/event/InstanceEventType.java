package termite.instance.event;

/**
 * This enum define the different event types that can be created and be used
 * inside an {@link termite.instance.Instance}.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public enum InstanceEventType {

    TALK_EVENT(0),
    SEARCH_EVENT(1),
    USE_EVENT(2),
    GO_EVENT(3),
    LEAVE_EVENT(4);

    public final int ID;

    InstanceEventType(int id) {

        this.ID = id;
    }
}
