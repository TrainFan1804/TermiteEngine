package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public abstract class SearchEvent extends  InstanceEvent {

    protected SearchEvent() {

        super(EventType.SEARCH_EVENT);
    }

    @Override
    public void startEvent() {

        this.search();
    }

    public abstract void search();
}
