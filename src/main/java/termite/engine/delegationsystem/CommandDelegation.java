package termite.engine.delegationsystem;

import termite.engine.Command;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class CommandDelegation {

    public DelegationHandler determineDelegation(Command command) {

        return switch (command) {
            case SAVE -> new DelegationHandler(new SaveSystem());
            case LOAD -> new DelegationHandler(new LoadSystem());
            case EXIT -> new DelegationHandler(new ExitSystem());
            case HELP -> new DelegationHandler(new HelpSystem());
            default -> new DelegationHandler(new EventSystem());
            /*
            TODO expansion from the event system type

            The default case must use the CommandInstanceEventMapper to determine
            the right InstanceEventType and then he can eject this into the event system
            */
        };
    }
}
