package engine.instance.event;

import engine.instance.Instance;

/**
 * When you want to create a use event create an object of this type and give it
 * the {@link Instance}. See {@link IUse}
 * for more information.
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               0.18
 */
public final class UseEvent extends InstanceEvent {

    private IUse use;

    /**
     * Create a new use event with the behavior of the given
     * {@link IUse}.
     *
     * @param use                       The wanted use behavior that should
     *                                  be executed when stating the use event.
     */
    public UseEvent(IUse use) {

        super(InstanceEventType.USE_EVENT);
        this.use = use;
    }

    @Override
    public void startEvent() { this.use.use(); }
}
