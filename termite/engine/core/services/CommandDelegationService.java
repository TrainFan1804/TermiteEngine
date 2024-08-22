package engine.core.services;

import engine.core.Command;
import engine.core.subsystems.EngineCommandSystem;
import engine.core.subsystems.SubSystemFactory;

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
