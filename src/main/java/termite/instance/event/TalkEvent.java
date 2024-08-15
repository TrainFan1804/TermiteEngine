package termite.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class TalkEvent extends InstanceEvent {

    private ITalk talk;

    public TalkEvent(ITalk talk) {

        super(InstanceEventType.TALK_EVENT);
        this.talk = talk;
    }

    @Override
    public void startEvent() { this.talk.talk(); }
}
