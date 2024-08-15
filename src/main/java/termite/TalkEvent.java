package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public abstract class TalkEvent extends InstanceEvent {

    protected TalkEvent() {
        
        super(EventType.TALK_EVENT);
    }

    @Override
    public void startEvent() {

        this.talk();
    }

    public abstract void talk();
}
