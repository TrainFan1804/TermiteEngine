package termite;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.17
 */
public class TalkEvent extends InstanceEvent {

    public TalkEvent() {
        
        super(EventType.TALK_EVENT);
    }

    @Override
    public void startEvent() {
       
        System.out.println("Talk");
    }
}
