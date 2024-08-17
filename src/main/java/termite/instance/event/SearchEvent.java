package termite.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public class SearchEvent extends InstanceEvent {

    private ISearch search;

    public SearchEvent(ISearch search) {

        super(InstanceEventType.SEARCH_EVENT);
        this.search = search;
    }

    @Override
    public void startEvent() { this.search.search(); }
}
