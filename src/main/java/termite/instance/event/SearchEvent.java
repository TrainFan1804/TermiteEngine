package termite.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public abstract class SearchEvent extends InstanceEvent {

    protected SearchEvent() {

        super(InstanceEventType.SEARCH_EVENT);
    }

    @Override
    public void startEvent() {

        this.search();
    }

    public abstract void search();
}
