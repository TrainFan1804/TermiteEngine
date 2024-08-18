package termite.core.services;

import termite.core.Command;
import termite.core.subsystems.EngineCommandSystem;
import termite.core.subsystems.SubSystemFactory;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.22
 */
public class CommandDelegationService {

    private final SubSystemFactory systemFactory;

    public CommandDelegationService() {

        this.systemFactory = SubSystemFactory.getFactory(); 
    }
    public EngineCommandSystem determineDelegation(Command command) {

        return this.systemFactory.getSystem(command);
    }
}
