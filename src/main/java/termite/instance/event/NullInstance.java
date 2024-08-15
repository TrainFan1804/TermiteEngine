package termite.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.20
 */
public class NullInstance extends InstanceEvent {

    public NullInstance() {

        super(null);
    }

    @Override
    public void startEvent() {

        System.out.println("Command is not supported");
    }
}
