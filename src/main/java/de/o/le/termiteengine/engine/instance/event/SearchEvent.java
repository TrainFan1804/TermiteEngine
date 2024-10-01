package de.o.le.termiteengine.engine.instance.event;

import de.o.le.termiteengine.engine.instance.InstanceCore;

/**
 * When you want to create a search event create an object of this type and give it
 * the {@link InstanceCore}. See {@link ISearch}
 * for more information.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public final class SearchEvent extends InstanceEvent {

    private final ISearch search;

    /**
     * Create a new search event with the behavior of the given
     * {@link ISearch}.
     *
     * @param search                    The wanted search behavior that should
     *                                  be executed when stating the search event.
     */
    public SearchEvent(ISearch search) {

        super(InstanceEventType.SEARCH_EVENT);
        this.search = search;
    }

    @Override
    public void startEvent() { this.search.search(); }
}
