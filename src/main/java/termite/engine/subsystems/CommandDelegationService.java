package termite.engine.subsystems;

import termite.engine.Command;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class CommandDelegationService {

    private CommandInstanceEventMapper mapper;

    public CommandDelegationService() {

        this.mapper = new CommandInstanceEventMapper();
    }

    public EngineSystem determineDelegation(Command command) {

        return switch(command) {

            case SAVE -> new SaveSystem();
            case LOAD -> new LoadSystem();
            case EXIT -> new ExitSystem();
            case HELP -> new HelpSystem();
            default -> new EventSystem(this.mapper
                            .mapCommandToInstanceEventType(command));
        };
    }
}
